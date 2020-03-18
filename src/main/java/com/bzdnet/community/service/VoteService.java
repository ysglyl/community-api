package com.bzdnet.community.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bzdnet.community.dao.TopicMapper;
import com.bzdnet.community.dao.VoteMapper;
import com.bzdnet.community.model.TopicModel;
import com.bzdnet.community.model.VoteModel;
import org.springframework.stereotype.Service;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 17:09
 **/
@Service
public class VoteService extends ServiceImpl<VoteMapper, VoteModel> {
}
