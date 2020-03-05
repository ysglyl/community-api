package com.bzdnet.community.controller;

import com.bzdnet.community.service.UserService;
import com.bzdnet.community.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 17:24
 **/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/wxLogin")
    public ResultVO wxLogin(@RequestParam("code") String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx627a5e2ee2f8e774&secret=dc1c8da4f7c396262c51aaf1e49d6fa0&js_code=" + code + "&grant_type=authorization_code";
        Object response = restTemplate.getForObject(url,String.class);
        return success(response);
    }

}
