package lyp.bawei.com.mvp1.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import lyp.bawei.com.mvp1.R;
import lyp.bawei.com.mvp1.adapter.ListRecy;
import lyp.bawei.com.mvp1.model.MainModelBean;
import lyp.bawei.com.mvp1.presenter.MainPre;
import lyp.bawei.com.mvp1.view.Iview;

public class MainActivity extends AppCompatActivity implements Iview{


    private RecyclerView mrecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        mrecycler = (RecyclerView) findViewById(R.id.mrecycler);
        MainPre mainPre = new MainPre(this);
        mainPre.getData();
    }
//赵倩是猪 我喜欢猪
    @Override
    public void showData(MainModelBean mainModelBean) {
        List<MainModelBean.OthersBean> others = mainModelBean.others;
        mrecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mrecycler.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
        mrecycler.setAdapter(new ListRecy(MainActivity.this,others));
    }
}
