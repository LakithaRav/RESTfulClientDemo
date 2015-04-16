package ormlite.demo.olc.com.restfulclient.api;

import ormlite.demo.olc.com.restfulclient.model.Country;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Created by Lakitha on 4/10/15.
 */
public class RestCountriesAPI {

    private String service_url = "https://restcountries.eu/rest/v1";

    public interface GetAllAPI {
        @GET("/all")
        List<Country> getCountries();
    }

    public List<Country> GetAllCountries() {

        Gson gson = new GsonBuilder().create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(service_url)
                .setConverter(new GsonConverter(gson))
                .build();

        GetAllAPI service = restAdapter.create(GetAllAPI.class);

        List<Country> countrylist = service.getCountries();

        return countrylist;
    }

}
