package com.bzdnet.community.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bzdnet.community.form.ActivityForm;
import com.bzdnet.community.holder.SessionContextHolder;
import com.bzdnet.community.model.ActivityModel;
import com.bzdnet.community.model.CommunityMemberModel;
import com.bzdnet.community.model.CommunityModel;
import com.bzdnet.community.service.ActivityService;
import com.bzdnet.community.vo.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

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
            if(form.getReferenceId() == 0) {
                query.orderByDesc("row_id_");
            }
        }
        IPage<ActivityModel> pageList = activityService.page(new Page<>(1, form.getPageSize()),query);
        return success(pageList);
    }

    @PostMapping("/insert")
    public ResultVO insert(@RequestBody ActivityModel model) {
        activityService.save(model);
        switch (ActivityModel.Type.instance(model.getType())){
            case NOTICE:
            case TOPIC:
            case VOTE:
            case STATISTICS:
            case PURCHASE:
            case DEMAND:
                break;
        }
        return success(model.getRowId());
    }

}

