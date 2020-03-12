package com.bzdnet.community.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bzdnet.community.form.CommunityForm;
import com.bzdnet.community.holder.SessionContextHolder;
import com.bzdnet.community.model.CommunityMemberModel;
import com.bzdnet.community.model.CommunityModel;
import com.bzdnet.community.service.CommunityMemberService;
import com.bzdnet.community.service.CommunityService;
import com.bzdnet.community.vo.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 社区 API
 *
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 17:24
 **/
@RestController
@RequestMapping("/community")
public class CommunityController extends BaseController {

    @Resource
    private CommunityService communityService;

    @Resource
    private CommunityMemberService communityMemberService;

    @PostMapping("/loadingList")
    public ResultVO pageList(@RequestBody CommunityForm form) {
        QueryWrapper<CommunityModel> query = new QueryWrapper<>();
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
        IPage<CommunityModel> pageList = communityService.page(new Page<>(1, form.getPageSize()), query);
        return success(pageList);
    }

    @PostMapping("/insert")
    public ResultVO insert(@RequestBody CommunityModel model) {
        model.setMemberCount(1);
        model.setCertMemberCount(1);
        model.setCertRate(100);
        communityService.save(model);
        CommunityMemberModel member = new CommunityMemberModel();
        member.setCommunityId(model.getRowId());
        member.setUserId(SessionContextHolder.get().getRowId());
        member.setFlagCert(1);
        member.setCertUserId(0L);
        member.setCertTime(new Date());
        communityMemberService.save(member);
        return success(model.getRowId());
    }
}

