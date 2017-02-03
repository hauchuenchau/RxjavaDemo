package houzhongzhou.rxjavademo.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Mr.hou on 2017/2/3.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         *fresco初始化
         */
        Fresco.initialize(this);
    }
}
