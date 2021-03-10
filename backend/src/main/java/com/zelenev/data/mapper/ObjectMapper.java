package com.zelenev.data.mapper;

import java.util.List;

public interface ObjectMapper<IN, OUT> {

    OUT convert(IN object);

    List<OUT> convertList(List<IN> objectsList);

    Class<IN> getInClass();

    Class<OUT> getOutClass();

}
