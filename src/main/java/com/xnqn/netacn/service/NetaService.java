package com.xnqn.netacn.service;

import com.xnqn.netacn.model.Neta;
import com.xnqn.netacn.model.PageInfo;

import java.util.List;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/28 16:47
 * @Description:
 */
public interface NetaService {
    void  addNeta(Neta neta);
    List<Neta> selectJudgeNetas();
    PageInfo selectNetas(PageInfo pageInfo);
    Neta selectFullNeta(Integer netaId);
    void changeNetaStatus(List<Neta> netas);
}
