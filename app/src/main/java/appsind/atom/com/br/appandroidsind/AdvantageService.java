package appsind.atom.com.br.appandroidsind;

import java.util.List;


import appsind.atom.com.br.appandroidsind.dto.ListAdvantageSync;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vinicius.oliveira on 08/03/2017.
 */

public interface AdvantageService {

    public static final String BASE_URL = "162.243.245.197:8082/";

    @GET("api/advantages")
    Call<ListAdvantageSync> listAdvantages();
}
