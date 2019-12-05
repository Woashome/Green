package com.example.green.model;


import com.example.green.base.ICommonModel;
import com.example.green.base.ICommonView;
import com.example.green.config.ApiConfig;
import com.example.green.net.NetManager;

public class HomePageModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.SEARCH_GOODS:
                String keyword = (String) t[0];  // 关键词
                int page = (int) t[1]; // 页码
                String key = (String) t[2]; // 相当于token
                int loadMotion = (int) t[3]; // 加载类型
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getSearchList(keyword, page, 10, key), view, whichApi, loadMotion);
                break;
            case ApiConfig.URL_HOMEDATA: // 首页数据
                int loadMode = (int) t[0]; // 加载类型
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getHomeListbean(), view, whichApi, loadMode);
                break;
            case ApiConfig.URL_GOODSDATA: // 商品推荐
                int size = (int) t[0];  // 每页多少
                int index = (int) t[1]; // 页码
                int loadType = (int) t[2]; // 加载类型
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getGoodsList(size, index), view, whichApi, loadType);
                break;
            case ApiConfig.HOT_SEARCH_KEY:
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getHotSearchKeyList(), view, whichApi, 0);
                break;
        }
    }
}
