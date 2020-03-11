package com.bzdnet.community.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bzdnet.community.form.CommunityForm;
import com.bzdnet.community.model.CommunityModel;
import com.bzdnet.community.service.CommunityService;
import com.bzdnet.community.vo.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
            if(form.getReferenceId() == 0) {
                query.orderByDesc("row_id_");
            }
        }
        IPage<CommunityModel> pageList = communityService.page(new Page<>(1, form.getPageSize()),query);
        return success(pageList);
    }
}

