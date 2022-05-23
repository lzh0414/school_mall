package com.gxks.mall_admin.controller;

import com.gxks.commons.entity.Dictionary;
import com.gxks.commons.entity.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Controller
public class DictionaryController {

    private static final String DICTIONARY_URL = "http://localhost:8001/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/admin/dictionary/delete/{id}")
    public String delete(@PathVariable Long id , Model model){
        ResponseData result = new ResponseData();
        System.out.println(1111);
        try {
            restTemplate.delete(DICTIONARY_URL + "dic/dictionary/" + id);
            result.setCode(200);
            result.setMessage("ok !");
        }catch (RuntimeException e){
            result.setCode(500);
            result.setMessage("delete error !");
        }
        model.addAttribute("deleteResult",result);
        return "redirect:/admin/dictionary";
    }

    @GetMapping("/admin/dictionary/add")
    public String add(Model model){
        ResponseData<Dictionary> result =
                restTemplate.getForObject(DICTIONARY_URL + "dic/dictionary", ResponseData.class);
        model.addAttribute("result" , result);
        return "dictionary/dictionaryAdd";
    }

    @PostMapping("/admin/dictionary")
    public String addDictionary(Dictionary dictionary, Model model){

        ResponseData<Dictionary> result = restTemplate.postForObject(DICTIONARY_URL + "dic/dictionary",
                dictionary , ResponseData.class );

        model.addAttribute("addResult",result);
        return "redirect:/admin/dictionary/add";
    }

    @GetMapping("/admin/dictionary")
    public String getDictionarys(Model model){
        ResponseData<Dictionary> result =
                restTemplate.getForObject(DICTIONARY_URL + "dic/dictionary", ResponseData.class);
        model.addAttribute("result" , result);
        return "dictionary/dictionaryList";
    }

}
