package com.bzdnet.community.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bzdnet.community.dao.OrderMapper;
import com.bzdnet.community.model.OrderModel;
import org.springframework.stereotype.Service;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 17:09
 **/
@Service
public class OrderService extends ServiceImpl<OrderMapper, OrderModel> {
}
