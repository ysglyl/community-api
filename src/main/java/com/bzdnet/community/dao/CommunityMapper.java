package com.bzdnet.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bzdnet.community.model.ActivityModel;
import com.bzdnet.community.model.CommunityModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 16:26
 **/
public interface CommunityMapper extends BaseMapper<CommunityModel> {

    /**
     * 查询用户已经加入的社区
     * @author yu.shigui@rongzer.com
     * @date 2020/3/18 14:36
     * @param userId
     * @return java.util.List<com.bzdnet.community.model.CommunityModel>
     **/
    List<CommunityModel> userHadJoinAllList(@Param("userId") Long userId);
    
}
