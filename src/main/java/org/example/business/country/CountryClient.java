package org.example.business.country;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface CountryClient {

    @RequestLine("GET /v3.1/alpha/{countryCode}")
    @Headers("Content-Type: application/json")
    List<CountryInfo> findByCountryCode(@Param("countryCode") String countryCode);
}
