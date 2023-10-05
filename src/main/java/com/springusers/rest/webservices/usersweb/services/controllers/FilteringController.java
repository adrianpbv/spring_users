package com.springusers.rest.webservices.usersweb.services.controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.springusers.rest.webservices.usersweb.services.models.FilterUser;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering") //field2
    public MappingJacksonValue filtering() {
        FilterUser FilterUser = new FilterUser("value1","value2", "value3");

        return getMappingJacksonValue(Arrays.asList(FilterUser), new String[]{"field1","field3"});
    }

    @GetMapping("/filtering-list") //field2, field3
    public MappingJacksonValue filteringList() {
        List<FilterUser> list = Arrays.asList(new FilterUser("value1","value2", "value3"),
                new FilterUser("value4","value5", "value6"));

        return getMappingJacksonValue(list, new String[]{"field2","field3"});
    }
    private static MappingJacksonValue getMappingJacksonValue(List<FilterUser> list, String [] fieldNames) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept(fieldNames);

        FilterProvider filters =
                new SimpleFilterProvider().addFilter("FilterUserFilter", filter );

        mappingJacksonValue.setFilters(filters );
        return mappingJacksonValue;
    }

}
