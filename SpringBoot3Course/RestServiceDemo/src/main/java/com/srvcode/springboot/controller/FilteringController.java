package com.srvcode.springboot.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.srvcode.springboot.model.DynamicBean;
import com.srvcode.springboot.model.StaticBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/static/filtering")
    public StaticBean staticFiltering() {
        return new StaticBean("value1", "value2", "value3");
    }

    @GetMapping("/static/filtering-list")
    public List<StaticBean> staticFilteringList() {
        return Arrays.asList(new StaticBean("value1", "value2", "value3"),
                new StaticBean("value4", "value5", "value6"));
    }

    @GetMapping("/dynamic/filtering")
    public MappingJacksonValue dynamicFiltering() {
        DynamicBean dynamicBean = new DynamicBean("value1", "value2", "value3");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/dynamic/filtering-list")
    public MappingJacksonValue dynamicFilteringList() {
        List<DynamicBean> beanList = Arrays.asList(new DynamicBean("value1", "value2", "value3"),
                new DynamicBean("value4", "value5", "value6"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(beanList);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

}
