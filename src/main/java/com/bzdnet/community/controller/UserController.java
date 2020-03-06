package com.bzdnet.community.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bzdnet.community.model.UserModel;
import com.bzdnet.community.service.UserService;
import com.bzdnet.community.util.FuncTool;
import com.bzdnet.community.vo.ResultVO;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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
    public ResultVO wxLogin(
            @RequestParam("code") String code,
            @RequestParam("signature") String signature,
            @RequestParam("rawData") String rawData,
            @RequestParam("encryptedData") String encryptedData,
            @RequestParam("iv") String iv) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx627a5e2ee2f8e774&secret=dc1c8da4f7c396262c51aaf1e49d6fa0&js_code=" + code + "&grant_type=authorization_code";
        String response = restTemplate.getForObject(url, String.class);
        JSONObject json = JSON.parseObject(response);
        if (json.getIntValue("errcode") == 0) {
            String openId = json.getString("openid");
            String sessionKey = json.getString("session_key");
            String sign = DigestUtils.sha1Hex(rawData + sessionKey);
            if (!sign.equals(signature)) {
                return fail("非法授权");
            }
            String decodedCryptData = FuncTool.decodeEncryptedData(encryptedData, sessionKey, iv);
            UserModel user = userService.getOne(new QueryWrapper<UserModel>().eq("open_id_", openId));
            if (user == null) {
                user = new UserModel();
            }
            user.setOpenId(openId);
            JSONObject userJson = JSON.parseObject(decodedCryptData);
            String nickName = userJson.getString( "nickName" );
            String avatarUrl = userJson.getString( "avatarUrl" );
            int gender  = userJson.getIntValue( "gender" );
            String city = userJson.getString( "city" );
            String country = userJson.getString( "country" );
            String province = userJson.getString( "province" );

            user.setOpenId(openId);
            user.setNickName(nickName);
            user.setAvatarUrl(avatarUrl);
            user.setGender(gender);
            user.setCountry(country);
            user.setProvince(province);
            user.setCity(city);
            userService.saveOrUpdate(user);
            return success(user);
        }
        return fail();
    }


    @RequestMapping("/getByOpenid")
    public ResultVO getByOpenId(@RequestParam("openid") String openid) {
        UserModel user = userService.getOne(new QueryWrapper<UserModel>().eq("open_id_", openid));
        return success(user);
    }

}
