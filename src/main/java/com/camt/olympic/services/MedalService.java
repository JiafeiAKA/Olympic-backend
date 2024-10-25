package com.camt.olympic.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MedalService {
    List<Map<String,Object>> getMedalWithPage(int year ,int page ,int pageSize);
    List<Map<String,Object>> getAllMedal(int year);
}
