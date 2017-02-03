package houzhongzhou.rxjavademo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import houzhongzhou.rxjavademo.R;
import houzhongzhou.rxjavademo.bean.CarBean;

/**
 * Created by Mr.hou on 2017/2/3.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context mContext;
    private final LayoutInflater layoutInflater;
    private CarBean carBean;

    public MyAdapter( Context context,CarBean carBean) {
        this.carBean = carBean;
        this.mContext = context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.listview_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.image.setImageURI(Uri.parse(carBean.getData().get(position).getImage()));
        holder.describe.setText(carBean.getData().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return carBean.getData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView image;
        TextView describe;
        public MyViewHolder(View itemView) {
            super(itemView);
            image= (SimpleDraweeView) itemView.findViewById(R.id.image);
            describe= (TextView) itemView.findViewById(R.id.describe);
        }
    }
}
