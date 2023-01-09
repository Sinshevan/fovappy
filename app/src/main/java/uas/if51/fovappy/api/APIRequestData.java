package uas.if51.fovappy.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uas.if51.fovappy.models.ResponseModel;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ResponseModel> ardRetrieveData();

    @GET("searchRestaurant.php")
    Call<ResponseModel> search(@Query("key") String keyword);

    @GET("Makanan.php")
    Call<ResponseModel> makanan(@Query("key") int keyword);





}
