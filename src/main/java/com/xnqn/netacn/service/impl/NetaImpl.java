package com.xnqn.netacn.service.impl;

import com.xnqn.netacn.mapper.NetaLabelMapper;
import com.xnqn.netacn.mapper.NetaMapper;
import com.xnqn.netacn.model.Neta;
import com.xnqn.netacn.model.NetaLabel;
import com.xnqn.netacn.service.NetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    NetaLabelMapper netaLabelMapper;

    @Override
    public void addNeta(Neta neta) {
        if (neta.getNetaDate() < 100000) {
            neta.setNetaDate(null);
        }
        netaMapper.insertSelective(neta);
    }

    @Override
    public List<Neta> selectNeta(Integer statusCode) {
        return netaMapper.selectByStatusCode(statusCode);
    }

    @Override
    public Neta selectFullNeta(Integer netaId) {
        Neta neta = netaMapper.selectByPrimaryKey(netaId);
        String netaIds = neta.getNetaLabel();
        String[] str = netaIds.split("\\|");
        List<Integer> list = new ArrayList<>();
        for (String s : str
        ) {
            list.add(Integer.parseInt(s));
        }
        List<NetaLabel> labels = netaLabelMapper.selectLabelsById(list);
        String[] strings=new String[labels.size()];
        for(int x=0;x<labels.size();x++){
            strings[x]=labels.get(x).getCnWord()+"|"+labels.get(x).getJpWord();
        }
        neta.setLabels(strings);
        return neta;
    }
}
