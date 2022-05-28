package com.example.pruebatecnica.service;

import com.example.pruebatecnica.entity.SearchDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {

    @InjectMocks
    SearchService searchService;

    @Test
    public void test() {
        SearchDto searchDto = new SearchDto();
        searchDto.setText("The quick brown fox jumps over the lazy dog.");
        searchDto.setWord("God");

        assertEquals(1, searchService.findPermutation(searchDto).get("Amount of permutations found"));
    }
}
