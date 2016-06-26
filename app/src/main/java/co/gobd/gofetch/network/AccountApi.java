package co.gobd.gofetch.network;

import co.gobd.gofetch.config.ApiEndpoint;
import co.gobd.gofetch.model.account.AccessToken;
import co.gobd.gofetch.model.account.UserModel;
import co.gobd.gofetch.model.user.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by tonmoy on 08-May-16.
 */
public interface AccountApi {

  @FormUrlEncoded @POST(ApiEndpoint.TaskCat.LOGIN) Call<AccessToken> login(
      @Field("userName") String userName, @Field("password") String password,
      @Field("grant_type") String grantType, @Field("client_Id") String clientId,
      @Field("client_secret") String clientSecret);

  @POST(ApiEndpoint.TaskCat.REGISTER) Call<Void> register(@Body UserModel userModel);

  @GET(ApiEndpoint.TaskCat.GET_PROFILE) Call<User> getUserProfile(
      @Header("Authorization") String token);
}
