package com.service.spring.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Mapper
public interface CalendarMapper {
    List<HashMap<String, Object>> getGroups(long userSeq);
}
