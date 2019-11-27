package com.example.green.model;

import com.example.green.base.ICommonModel;
import com.example.green.base.ICommonView;
import com.example.green.config.ApiConfig;
import com.example.green.net.NetManager;

public class MineModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.URL_HOMEDATA: // 首页数据
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getHomeListbean(), view, whichApi, 0);
                break;
        }
    }
}
