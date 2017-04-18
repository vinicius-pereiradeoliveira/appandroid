package appsind.atom.com.br.appandroidsind;

import appsind.atom.com.br.appandroidsind.dto.ListCampaignSync;
import appsind.atom.com.br.appandroidsind.dto.ListNewSync;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vinicius.oliveira on 30/03/2017.
 */

public interface CampaignService {
    public static final String BASE_URL = "http://162.243.245.197:8082/";

    @GET("api/campaign")
    Call<ListCampaignSync> listCampaign();
}
