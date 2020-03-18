package com.bzdnet.community.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bzdnet.community.dao.ActivityMapper;
import com.bzdnet.community.dao.NoticeMapper;
import com.bzdnet.community.model.ActivityModel;
import com.bzdnet.community.model.NoticeModel;
import org.springframework.stereotype.Service;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 17:09
 **/
@Service
public class NoticeService extends ServiceImpl<NoticeMapper, NoticeModel> {
}
