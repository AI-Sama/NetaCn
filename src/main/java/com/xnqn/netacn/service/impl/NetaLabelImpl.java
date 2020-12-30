package com.xnqn.netacn.service.impl;

import com.xnqn.netacn.mapper.NetaLabelMapper;
import com.xnqn.netacn.model.NetaLabel;
import com.xnqn.netacn.service.NetaLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public void addLabel(List<NetaLabel> netaLabels) {
        List<NetaLabel> selectLabels = Optional.ofNullable(netaLabelMapper.selectLabelsByLabelName(netaLabels)).orElse(new ArrayList<>());
        for (int x = 0; x < selectLabels.size(); x++) {
            //已有标签直接返回id
            NetaLabel var1 = selectLabels.get(x);
            for (int y = 0; y < netaLabels.size(); y++) {
                NetaLabel var2 = netaLabels.get(y);
                if (var1.getCnWord().equals(var2.getCnWord())) {
                    var2.setLabelId(var1.getLabelId());
                    break;
                }
            }
        }
        if(netaLabels.size()>selectLabels.size()){
            //批量插入
            netaLabelMapper.insert(netaLabels);
        }
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
        List<NetaLabel> labels = netaLabelMapper.selectLabels();
        return labels;
    }
}
