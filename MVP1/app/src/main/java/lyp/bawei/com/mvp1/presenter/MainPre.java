package lyp.bawei.com.mvp1.presenter;

import lyp.bawei.com.mvp1.model.GetdataModel;
import lyp.bawei.com.mvp1.model.MainModelBean;
import lyp.bawei.com.mvp1.view.Iview;

/**
 * Created by Administrator on 2017/5/8.
 */

public class MainPre implements IMainPre{
    private GetdataModel getdataModel;
    private Iview iview;

    public MainPre(Iview iview) {
        getdataModel=new GetdataModel(this);
        this.iview = iview;
    }
public void getData(){
    getdataModel.getData();
}
    @Override
    public void success(MainModelBean mainModelBean) {
        iview.showData(mainModelBean);
    }

    @Override
    public void failur() {

    }
}
