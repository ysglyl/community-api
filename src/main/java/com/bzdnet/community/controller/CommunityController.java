package com.bzdnet.community.controller;

import com.bzdnet.community.service.CommunityService;
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

}
