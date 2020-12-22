package com.xnqn.netacn.service.impl;

import com.xnqn.netacn.mapper.NetaLabelMapper;
import com.xnqn.netacn.model.NetaLabel;
import com.xnqn.netacn.service.NetaLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/22 18:32
 * @Description:
 */

@Service
public class NetaLabelImpl implements NetaLabelService {
    @Autowired
    NetaLabelMapper netaLabelMapper;

    @Override
    public void addLabel(NetaLabel netaLabel) {
        netaLabelMapper.insert(netaLabel);
    }

    @Override
    public void deleteLabel(NetaLabel netaLabel) {

    }

    @Override
    public void updateLabel(NetaLabel netaLabel) {

    }

    @Override
    public NetaLabel selectLabel(String cn_word) {
        return null;
    }

    @Override
    public List<NetaLabel> selectLabels() {
        List<NetaLabel> labels=netaLabelMapper.selectLabels();
        return labels;
    }
}
