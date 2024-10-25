package com.camt.olympic.controllers;


import com.camt.olympic.repositories.AthleteRepository;
import com.camt.olympic.services.MedalService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class AthleteController {

//    @Autowired
//    private AthleteRepository athleteRepository;
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

//    @GetMapping("/althletes/{year}")
//    public List<Map<String, Object>> getAthletes(@PathVariable int year) {
//
//        List<Map<String, Object>> results = athleteRepository.findMedalCountByNocAndSport(year);
//
//
//        // Create a map to group sports by NOC
//        Map<String, List<Map<String, Object>>> groupedResults = new HashMap<>();
//
//        for (Map<String, Object> result : results) {
//            String noc = (String) result.get("NOC");
//
//            groupedResults.computeIfAbsent(noc, k -> new ArrayList<>()).add(result);
//        }
//
//        // Create a list to hold the final output
//        List<Map<String, Object>> output = new ArrayList<>();
//
//        for (Map.Entry<String, List<Map<String, Object>>> entry : groupedResults.entrySet()) {
//            Map<String, Object> nocEntry = new HashMap<>();
//
//            int gold = entry.getValue().stream()
//                    .mapToInt(medal -> ((BigDecimal) medal.get("Gold")).intValue())
//                    .sum();
//
//            int silver = entry.getValue().stream()
//                    .mapToInt(medal -> ((BigDecimal) medal.get("Silver")).intValue())
//                    .sum();
//
//            int bronze = entry.getValue().stream()
//                    .mapToInt(medal -> ((BigDecimal) medal.get("Bronze")).intValue())
//                    .sum();
//
//            int totalMedal = gold + silver + bronze;
//
//
//            nocEntry.put("NOC", entry.getKey());
//            nocEntry.put("Gold", gold);
//            nocEntry.put("Silver", silver);
//            nocEntry.put("Bronze", bronze);
//            nocEntry.put("Total", totalMedal);
//            nocEntry.put("Sports", entry.getValue());
//            output.add(nocEntry);
//        }
//
//        // Convert output to JSON
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String jsonOutput = gson.toJson(output);
//
//        Type listType = new TypeToken<List<Map<String, Object>>>() {
//        }.getType();
//        List<Map<String, Object>> list = gson.fromJson(jsonOutput, listType);
//
//        return list;
//    }
//
//
//    @GetMapping("/althletes")
//    public List<Map<String, Object>> getAthletesByPagination(@RequestParam(defaultValue = "2016") int year,
//                                                             @RequestParam(defaultValue = "1") int page,
//                                                             @RequestParam(defaultValue = "10") int pageSize
//    ) {
//
//        List<Map<String, Object>> results = athleteRepository.findMedalCountByNocAndSport(year);
//
//
//
//
//        // Create a map to group sports by NOC
//        Map<String, List<Map<String, Object>>> groupedResults = new HashMap<>();
//
//        for (Map<String, Object> result : results) {
//            String noc = (String) result.get("NOC");
//
//            groupedResults.computeIfAbsent(noc, k -> new ArrayList<>()).add(result);
//        }
//
//        // Create a list to hold the final output
//        List<Map<String, Object>> output = new ArrayList<>();
//
//        for (Map.Entry<String, List<Map<String, Object>>> entry : groupedResults.entrySet()) {
//            Map<String, Object> nocEntry = new HashMap<>();
//
//            int gold = entry.getValue().stream()
//                    .mapToInt(medal -> ((BigDecimal) medal.get("Gold")).intValue())
//                    .sum();
//
//            int silver = entry.getValue().stream()
//                    .mapToInt(medal -> ((BigDecimal) medal.get("Silver")).intValue())
//                    .sum();
//
//            int bronze = entry.getValue().stream()
//                    .mapToInt(medal -> ((BigDecimal) medal.get("Bronze")).intValue())
//                    .sum();
//
//            int totalMedal = gold + silver + bronze;
//
//
//            nocEntry.put("NOC", entry.getKey());
//            nocEntry.put("Gold", gold);
//            nocEntry.put("Silver", silver);
//            nocEntry.put("Bronze", bronze);
//            nocEntry.put("Total", totalMedal);
//            nocEntry.put("Sports", entry.getValue());
//            output.add(nocEntry);
//        }
//
//        output.sort((m1, m2) -> {
//            // แปลงค่าของ price เป็น Integer แล้วเรียงลำดับจากมากไปน้อย
//            return ((Integer) m2.get("Total")).compareTo((Integer) m1.get("Total"));
//        });
//
//
//
//        // cal page
////        Pageable pageable = PageRequest.of(page, pageSize);
////        long totalItems = output.size();
////        int totalPages = (int) Math.ceil((double) totalItems / pageSize);
//
//
//        int start = (page - 1) * pageSize;
//        int end = start + pageSize;
//
//
//        List<Map<String, Object>> resultPage = output.subList(start, end);
//
//
//
//        // Convert output to JSON
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String jsonOutput = gson.toJson(resultPage);
//
//        Type listType = new TypeToken<List<Map<String, Object>>>() {
//        }.getType();
//        List<Map<String, Object>> list = gson.fromJson(jsonOutput, listType);
//
//        return list;
//
//    }


    final MedalService medalService;

    @GetMapping("/althletes")
    public List<Map<String,Object>> getAll(
            @RequestParam(value = "year" ) int year

    ){
        return medalService.getAllMedal(year);
    }



}
