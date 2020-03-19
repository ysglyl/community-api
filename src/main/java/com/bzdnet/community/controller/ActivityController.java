package com.bzdnet.community.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bzdnet.community.form.ActivityForm;
import com.bzdnet.community.holder.SessionContextHolder;
import com.bzdnet.community.model.ActivityModel;
import com.bzdnet.community.model.UserModel;
import com.bzdnet.community.service.*;
import com.bzdnet.community.vo.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * 活动 API
 *
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 17:24
 **/
@RestController
@RequestMapping("/activity")
public class ActivityController extends BaseController {

    @Resource
    private ActivityService activityService;
    @Resource
    private NoticeService noticeService;
    @Resource
    private TopicService topicService;
    @Resource
    private VoteService voteService;
    @Resource
    private VoteItemService voteItemService;
    @Resource
    private StatisticsService statisticsService;
    @Resource
    private PurchaseService purchaseService;
    @Resource
    private PurchaseProductService purchaseProductService;
    @Resource
    private DemandService demandService;

    @PostMapping("/loadingList")
    public ResultVO pageList(@RequestBody ActivityForm form) {
        QueryWrapper<ActivityModel> query = new QueryWrapper<>();
        if (form.getType() != 0) {
            query.eq("type_", form.getType());
        }
        if (form.getLoadMode() == 1) {//如果为加载更多
            query.lt("row_id_", form.getReferenceId());
            query.orderByDesc("row_id_");
        } else { //如果为刷新
            query.gt("row_id_", form.getReferenceId());
            if (form.getReferenceId() == 0) {
                query.orderByDesc("row_id_");
            }
        }
        IPage<ActivityModel> pageList = activityService.page(new Page<>(1, form.getPageSize()), query);

        return success(pageList);
    }

    @PostMapping("/insert")
    public ResultVO insert(@RequestBody ActivityModel model) {
        UserModel loginUser = SessionContextHolder.get();
        model.setInitiator(loginUser.getRowId());
        model.setStatus(0);
        activityService.save(model);
        switch (ActivityModel.Type.instance(model.getType())) {
            case NOTICE:
                model.getNotice().setActivityId(model.getRowId());
                noticeService.save(model.getNotice());
                break;
            case TOPIC:
                model.getTopic().setActivityId(model.getRowId());
                topicService.save(model.getTopic());
                break;
            case VOTE:
                model.getVote().setActivityId(model.getRowId());
                voteService.save(model.getVote());
                voteItemService.saveBatch(model.getVote().getItems().stream().peek(item -> {
                    item.setVoteId(model.getVote().getRowId());
                    item.setNum(0);
                }).collect(Collectors.toList()));
                break;
            case STATISTICS:
                model.getStatistics().setActivityId(model.getRowId());
                statisticsService.save(model.getStatistics());
                break;
            case PURCHASE:
                model.getPurchase().setActivityId(model.getRowId());
                purchaseService.save(model.getPurchase());
                purchaseProductService.saveBatch(model.getPurchase().getProducts().stream().peek(item -> item.setPurchaseId(model.getPurchase().getRowId())).collect(Collectors.toList()));
                break;
            case DEMAND:
                model.getDemand().setActivityId(model.getRowId());
                demandService.save(model.getDemand());
                break;
        }
        return success(model.getRowId());
    }

}

