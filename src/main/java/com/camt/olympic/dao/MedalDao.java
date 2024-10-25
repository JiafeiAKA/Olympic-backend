package com.camt.olympic.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface MedalDao {
    List<Map<String,Object>> getMedalWithPage(int year,int page,int pageSize);
    List<Map<String,Object>> getAllMedal(int year);

}
