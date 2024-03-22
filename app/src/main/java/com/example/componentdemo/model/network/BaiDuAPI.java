package com.example.componentdemo.model.network;

import com.example.componentdemo.model.network.entities.baidu.MyAnswerResult;
import com.example.componentdemo.model.network.entities.baidu.TokenResult;
import com.example.componentdemo.model.network.entities.baidu.request.MessageRequest;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @Author winiymissl
 * @Date 2024-03-18 14:30
 * @Version 1.0
 */
public interface BaiDuAPI {
    String BAI_DU = "https://aip.baidubce.com/";
    String GRANT_TYPE = "client_credentials";
    String client_id = "KbbaxI3jP41oaFSebPpxzhLI";
    String client_secret = "5K60O4ioCQO4mH7xursTwytvKCWHsv2T";
//    https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=KbbaxI3jP41oaFSebPpxzhLI&client_secret=5K60O4ioCQO4mH7xursTwytvKCWHsv2T

    @POST("oauth/2.0/token")
    Observable<TokenResult> getToken(@Query("grant_type") String grant_type, @Query("client_id") String client_id, @Query("client_secret") String client_secretA);

    @Headers("Content-Type: application/json")
    @POST("rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions_pro")
    Observable<MyAnswerResult> getAnswer(@Query("access_token") String token, @Body MessageRequest messages);
//    @Headers("Content-Type: application/json")
//    @Streaming
//    @POST("rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions_pro")
//    Call<ResponseBody> getAnswer(@Query("access_token") String token, @Body MessageRequest messages);
}
