package org.example.business.country;

import lombok.Data;

@Data
public class CountryInfo {

    private Name name;

    @Data
    private class Name {

        private String common;
        private String official;
    }
}
