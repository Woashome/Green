package com.example.green.model;


import com.example.green.base.ICommonModel;
import com.example.green.base.ICommonView;
import com.example.green.config.ApiConfig;
import com.example.green.net.NetManager;

public class HomePageModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            /*搜索商品*/
            case ApiConfig.SEARCH_GOODS:
                String keyword = (String) t[0];  // 关键词
                int page = (int) t[1]; // 页码
                int key = (int) t[2]; //
                String gc_id = (String) t[3]; // 相当于token
                int loadMotion = (int) t[4]; // 加载类型
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getSearchList(keyword, page, key, gc_id), view, whichApi, loadMotion);
                break;
            /*首页数据*/
            case ApiConfig.URL_HOMEDATA:
                int loadMode = (int) t[0]; // 加载类型
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getHomeListbean(), view, whichApi, loadMode);
                break;
            /*商品推荐*/
            case ApiConfig.URL_GOODSDATA:
                int size = (int) t[0];  // 每页多少
                int index = (int) t[1]; // 页码
                int loadType = (int) t[2]; // 加载类型
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getGoodsList(size, index), view, whichApi, loadType);
                break;
            /*搜索热词*/
            case ApiConfig.HOT_SEARCH_KEY:
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getHotSearchKeyList(), view, whichApi, 0);
                break;
            /*商品详情*/
            case ApiConfig.GOODS_DETAILS:
                String goods_id = (String) t[0];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getGoodsDetailsList(goods_id), view, whichApi, 0);
                break;
        }
    }
}
