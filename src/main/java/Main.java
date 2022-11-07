import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.example.business.country.CountryClient;
import org.example.business.country.CountryInfo;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) throws Exception {
        new Main().testFeign();
    }


    public void testFeign() {

        CountryClient countryClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(CountryClient.class))
                .logLevel(Logger.Level.FULL)
                .target(CountryClient.class, "https://restcountries.com");

        List<CountryInfo> countries = countryClient.findByCountryCode("au");
        if (countries.size() > 0) {

            CountryInfo countryInfo = countries.get(0);
            System.out.println(countryInfo);
        }
//        log.debug("Size {}", countries.size());
    }
}
