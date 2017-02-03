package houzhongzhou.rxjavademo.api;

import houzhongzhou.rxjavademo.bean.CarBean;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Mr.hou on 2017/2/3.
 */

public interface ApiService {
    /**
     * url:
     * http://mrobot.pcauto.com.cn/v2/cms/channels/1?pageNo=1&pageSize=20&serialIds=2143,3404&v=4.0.0
     *
     * */
    //url
    @GET("/v2/cms/channels/1?pageNo=1&pageSize=20&serialIds=2143,3404&v=4.0.0")
    Observable<CarBean> getCarBean();
}
