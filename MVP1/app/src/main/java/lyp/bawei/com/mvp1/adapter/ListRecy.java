package lyp.bawei.com.mvp1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import lyp.bawei.com.mvp1.R;
import lyp.bawei.com.mvp1.model.MainModelBean;

/**
 * Created by Administrator on 2017/5/8.
 */

public class ListRecy extends RecyclerView.Adapter<ListRecy.MyHolder>{
    private Context context;
    private List<MainModelBean.OthersBean> others;

    public ListRecy(Context context, List<MainModelBean.OthersBean> others) {
        this.context = context;
        this.others = others;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        final MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView.setText(others.get(position).description);
        Glide.with(context).load(others.get(position).thumbnail).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return others.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.item_ima);
            textView = (TextView) itemView.findViewById(R.id.item_text);
        }
    }
}
