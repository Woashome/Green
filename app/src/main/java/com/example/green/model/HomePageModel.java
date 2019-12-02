package com.example.green.model;


import com.example.green.base.ICommonModel;
import com.example.green.base.ICommonView;
import com.example.green.config.ApiConfig;
import com.example.green.net.NetManager;

public class HomePageModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
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

                /*
            case ApiConfig.URL_MOVIEDETAILS: // 电影详情 get
                String movieId = (String) t[0];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getMovieDetails(movieId), view, whichApi, 0);
                break;
            case ApiConfig.URL_MOVIETRAILER: // 全部预告片
                String trailer_movieId = (String) t[0];
                int pageIndex_trailer = (int) t[1];
                int pageSize_trailer = (int) t[2];
                int loadType_trailer = (int) t[3]; // 加载类型
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getMovieTrailer(trailer_movieId, pageIndex_trailer, pageSize_trailer), view, whichApi, loadType_trailer);
                break;
            case ApiConfig.URL_MOVIEPOSTER: // 全部海报壁纸
                int poster_movieId = (Integer) t[0];
                int pageIndex_poster = (int) t[1];
                int pageSize_poster = (int) t[2];
                int loadType_poster = (int) t[3]; // 加载类型
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getMoviePoster(poster_movieId, pageIndex_poster, pageSize_poster), view, whichApi, loadType_poster);
                break;
            case ApiConfig.URL_CREATEPOSTER://生成海报，get
                String posterId = (String) t[0];
                String content = (String) t[1];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getSharePoster(posterId, content), view, whichApi, 0);
                break;
            case ApiConfig.URL_CREATE_POSTER_DOWN://生成海报，下载使用 get
                String posterIdDown = (String) t[0];
                String contentDown = (String) t[1];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getSharePoster(posterIdDown, contentDown), view, whichApi, 0);
                break;
            case ApiConfig.URL_MESSAGE_USER_DETAIL: // 获取主控的消息 get
                String mo = (String) t[0];
                String m2 = (String) t[1];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getMovieUserDetail(mo, m2), view, whichApi, 0);
                break;
            case ApiConfig.URL_USERINFO://获取用户信息 get
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getMineInfo(), view, whichApi, 0);
                break;

            case ApiConfig.URL_UPLOAD_WATCH_PROGRESS://付费用户播放进度 get
                String roomId = (String) t[0];
                String watchSeconds = (String) t[1];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .uploadWatchProgress(roomId, watchSeconds), view, whichApi, 0);
                break;

            case ApiConfig.NEWVERSION://首页获取版本信息 get
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getUpdateState(), view, whichApi, 0);
                break;*/
        }
    }
}
