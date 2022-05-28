package com.example.pruebatecnica.controller;

import com.example.pruebatecnica.entity.SearchDto;
import com.example.pruebatecnica.service.ISearchService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class SearchController {

    @Autowired ISearchService iSearchService;

    @PostMapping("/")
    public ResponseEntity find(@RequestBody SearchDto searchDto) {
        try {
            if (Objects.isNull(searchDto) || Strings.isEmpty(searchDto.getWord()) || Strings.isEmpty(searchDto.getText()))
                throw new NullPointerException();
            else
                return new ResponseEntity<>(iSearchService.findPermutation(searchDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
