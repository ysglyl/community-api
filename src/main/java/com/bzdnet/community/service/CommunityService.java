package com.bzdnet.community.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bzdnet.community.dao.CommunityMapper;
import com.bzdnet.community.model.CommunityModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 17:09
 **/
@Service
public class CommunityService extends ServiceImpl<CommunityMapper, CommunityModel> {

    public List<CommunityModel> userHadJoinAllList(Long userId) {
        return baseMapper.userHadJoinAllList(userId);
    }

}
