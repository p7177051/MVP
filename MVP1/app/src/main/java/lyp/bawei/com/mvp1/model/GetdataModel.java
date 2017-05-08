package lyp.bawei.com.mvp1.model;

import com.google.gson.Gson;

import java.io.IOException;

import lyp.bawei.com.mvp1.presenter.IMainPre;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/5/8.
 */

public class GetdataModel {
private IMainPre iMainPre;

    public GetdataModel(IMainPre iMainPre) {
        this.iMainPre = iMainPre;
    }
    public void getData(){
        OkHttpClient mOkHttpClient = new OkHttpClient();
//创建一个Request
        final Request request = new Request.Builder()
                .url("http://news-at.zhihu.com/api/4/themes")
                .build();
//new call
        Call call = mOkHttpClient.newCall(request);
//请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iMainPre.failur();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson=new Gson();
                MainModelBean mainModelBean = gson.fromJson(string, MainModelBean.class);
                iMainPre.success(mainModelBean);
            }
        });
    }
}
