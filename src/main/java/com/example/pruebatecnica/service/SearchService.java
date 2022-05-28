package com.example.pruebatecnica.service;

import com.example.pruebatecnica.entity.SearchDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SearchService implements ISearchService{

    public HashMap findPermutation(SearchDto searchDto){
        int count = 0;
        ArrayList<String> permutation = new ArrayList<>();

        searchDto.setText(searchDto.getWord().replaceAll("[^A-Za-z0-9]",""));
        ArrayList<String> permutations = computeAllPossiblePermutations(searchDto.getWord());
        for (String word : searchDto.getText().split(" ")){
            for (String per: permutations){
                if(word.equalsIgnoreCase(per)){
                    count++;
                    permutation.add(word);
                }
            }
        }

        HashMap res = new HashMap();
        res.put("Amount of permutations found", count);
        res.put("Permutations found", permutation);
        return res;
    }

    private static ArrayList<String> computeAllPossiblePermutations(String str) {
        ArrayList<String> perms = new ArrayList<>();
        if (str.length() == 1) {
            perms.add(str);
        } else {
            String chr = str.substring(0,1);
            String rest = str.substring(1);
            ArrayList<String> subPerms = computeAllPossiblePermutations(rest);
            for (String s : subPerms) {
                for (int j = 0; j <= s.length(); j++) {
                    String newPerm = s.substring(0,j) + chr + s.substring(j);
                    perms.add(newPerm);
                }
            }
        }
        return perms;
    }
}
