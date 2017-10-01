package tr.gov.teias.monday;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Pronious on 25/09/2017.
 */

public interface UserClient {

    @POST("login")
    Call<Result> login(@Body Login login);

    @GET("dashboard")
    Call<Dashboard> getDashboard(@Header("x-access-token") String token);

    // Below methods not tested yet !!!!

    @POST("dashboard")
    Call<Project> postDashboard(@Header("x-access-token")String token, @Body Project project);

    @GET("project/{id}")
    Call<Project> getProject(@Header("x-access-token")String token, @Path("id") String id);

    @PUT("project/{id}")
    Call<Project> updateProject(@Header("x-access-token")String token, @Path("id") String id, @Body Project project);

    //Non-implemented method in API!!!
    @DELETE("project/{id}")
    Call<Project> deleteProject(@Header("x-access-token")String token, @Path("id") String id);
}
