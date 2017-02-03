package houzhongzhou.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import houzhongzhou.rxjavademo.adapter.MyAdapter;
import houzhongzhou.rxjavademo.api.ApiService;
import houzhongzhou.rxjavademo.bean.CarBean;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private CarBean carBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initLoad();
    }

    private void initView() {
        recyclerView= (RecyclerView) findViewById(R.id.listview);
    }
    private void initLoad() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://mrobot.pcauto.com.cn")
                .client(new OkHttpClient().newBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService=retrofit.create(ApiService.class);
        apiService.getCarBean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CarBean>() {
                    @Override
                    public void onCompleted() {
                        adapter=new MyAdapter(MainActivity.this,carBean);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CarBean carBean) {
                    MainActivity.this.carBean=carBean;
                    }
                });
    }
}
