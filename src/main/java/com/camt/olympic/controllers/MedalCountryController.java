package com.camt.olympic.controllers;

import com.camt.olympic.entity.Comments;
import com.camt.olympic.entity.OlympicYear;
import com.camt.olympic.services.MedalCountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/medal")
@RequiredArgsConstructor
@CrossOrigin
public class MedalCountryController {

    final MedalCountryService medalCountryService;

    @GetMapping({"","/"})
    public List<Map<String,Object>> getAllCommentsByCountry(
            @RequestParam(value = "noc") String noc,
            @RequestParam(value = "year") int year
    ){
        return medalCountryService.getMedalByCountryByYear(noc,year);
    }

}
