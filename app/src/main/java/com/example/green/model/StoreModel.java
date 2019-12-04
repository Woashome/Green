package com.example.green.model;

import com.example.green.base.ICommonModel;
import com.example.green.base.ICommonView;
import com.example.green.config.ApiConfig;
import com.example.green.net.NetManager;

public class StoreModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.RECOMMEND_STORE: // 店铺列表(推荐) cate_id不传或为0
                int index = (int) t[0]; // 页码
                int loadMode = (int) t[1]; // 加载类型
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getStoreList(index), view, whichApi, loadMode);
                break;
            case ApiConfig.STORE_CLASSIFY:
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getStoreClassList(), view, whichApi, 0);
                break;
            case ApiConfig.STORE_INFO:
                String store_id = (String) t[0];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getStoreInfoList(store_id), view, whichApi, 0);
                break;
            case ApiConfig.STORE_RECOMMEND:
                String storeId = (String) t[0];
                int page = (int) t[1];
                int loadmode = (int) t[2];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getStoreRecommendList(storeId, page), view, whichApi, loadmode);
                break;
            case ApiConfig.ALL_STOREGOODS:
                String store_Id = (String) t[0];
                int page_index = (int) t[1];
                int load_mode = (int) t[2];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getAllStoreList(store_Id, page_index), view, whichApi, load_mode);
                break;
        }
    }
}
