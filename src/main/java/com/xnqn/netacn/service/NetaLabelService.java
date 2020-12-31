package com.xnqn.netacn.service;

import com.xnqn.netacn.model.NetaLabel;

import java.util.List;


/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/22 18:31
 * @Description:
 */
public interface NetaLabelService {
    void addLabel(List<NetaLabel> netaLabel);
    void deleteLabel(NetaLabel netaLabel);
    void updateLabel(NetaLabel netaLabel);
    NetaLabel selectLabel(String cn_word);
    List<NetaLabel> selectLabels();
    List<NetaLabel> fuzzySelectLabels(String labelName);
}
