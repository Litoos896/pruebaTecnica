package com.example.pruebatecnica.service;


import com.example.pruebatecnica.entity.SearchDto;

import java.util.HashMap;

public interface ISearchService {

    HashMap findPermutation(SearchDto searchDto);
}
