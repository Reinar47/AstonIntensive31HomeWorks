package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Converter<IN, OUT> {
    public abstract OUT to(IN in);

    public abstract IN from(OUT out);

    public List<OUT> toDtoList(List<IN> persons) {
        return persons.stream()
                .map(this::to)
                .collect(Collectors.toList());
    }
}
