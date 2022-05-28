package com.example.demo.controller;

import com.example.demo.entity.SearchDto;
import com.example.demo.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {

    @Mock SearchService searchService;
    @InjectMocks SearchController searchController;

    @Test
    public void failTest(){
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, searchController.find(null).getStatusCode());
    }

    @Test
    public void okTest(){
        SearchDto searchDto = new SearchDto();
        searchDto.setText("text");
        searchDto.setWord("word");

        when(searchService.findPermutation(any())).thenReturn(new HashMap());
        assertEquals(HttpStatus.OK, searchController.find(searchDto).getStatusCode());
    }

}
