package com.bzdnet.community.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bzdnet.community.dao.PurchaseMapper;
import com.bzdnet.community.dao.PurchaseProductMapper;
import com.bzdnet.community.model.PurchaseModel;
import com.bzdnet.community.model.PurchaseProductModel;
import org.springframework.stereotype.Service;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 17:09
 **/
@Service
public class PurchaseProductService extends ServiceImpl<PurchaseProductMapper, PurchaseProductModel> {
}
