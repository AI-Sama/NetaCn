package com.xnqn.netacn.service.impl;

import com.xnqn.netacn.mapper.NetaLabelMapper;
import com.xnqn.netacn.mapper.NetaMapper;
import com.xnqn.netacn.model.Neta;
import com.xnqn.netacn.service.NetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/28 16:48
 * @Description:
 */
@Service
public class NetaImpl implements NetaService {

    @Autowired
    NetaMapper netaMapper;
    @Override
    public void addNeta(Neta neta) {
        if(neta.getNetaDate()<100000){
            neta.setNetaDate(null);
        }
        netaMapper.insertSelective(neta);
    }

    @Override
    public List<Neta> selectNeta(Integer statusCode) {
        return netaMapper.selectByStatusCode(statusCode);
    }
}
