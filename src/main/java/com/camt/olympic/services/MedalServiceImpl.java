package com.camt.olympic.services;

import com.camt.olympic.dao.MedalDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MedalServiceImpl implements MedalService {
    final MedalDao medalDao;



    @Override
    public List<Map<String, Object>> getMedalWithPage(int year, int page, int pageSize) {
        return medalDao.getMedalWithPage(year,page,pageSize);
    }

    @Override
    public List<Map<String, Object>> getAllMedal(int year) {
        return medalDao.getAllMedal(year);
    }
}
