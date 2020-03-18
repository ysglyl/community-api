package com.bzdnet.community.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bzdnet.community.dao.ProductMapper;
import com.bzdnet.community.dao.StatisticsMapper;
import com.bzdnet.community.model.ProductModel;
import com.bzdnet.community.model.StatisticsModel;
import org.springframework.stereotype.Service;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 17:09
 **/
@Service
public class StatisticsService extends ServiceImpl<StatisticsMapper, StatisticsModel> {
}
