package com.gxks.mall_admin.controller;

import com.gxks.commons.entity.Dictionary;
import com.gxks.commons.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class DictionaryController {

    private static final String DICTIONARY_URL = "http://localhost:8001/";

    @Autowired
    private RestTemplate restTemplate;

    @PutMapping("/admin/dictionary")
    public String editDictionary(Dictionary dictionary, Model model){

        restTemplate.put(DICTIONARY_URL + "dic/dictionary" , dictionary );

        return "redirect:/admin/dictionary";
    }

    /**
     * 根据 ID 查询单条数据方法
     */
    @GetMapping("/admin/dictionary/{id}")
    public String getDictionaryById(@PathVariable Long id , Model model){
        // 根据 ID 查当前字典数据
        ResponseData<Dictionary> result = restTemplate.getForObject(DICTIONARY_URL + "dic/dictionary/" + id
                , ResponseData.class);
        model.addAttribute("result" , result);
        // 查询所有字典数据信息用作父节点选择
        ResponseData<Dictionary> result2 =
                restTemplate.getForObject(DICTIONARY_URL + "dic/dictionary", ResponseData.class);
        model.addAttribute("result2" , result2);
        return "dictionary/dictionaryEdit";
    }

    /**
     * 批量删除方法
     */
    @ResponseBody
    @DeleteMapping("/admin/dictionary")
    public ResponseData deleteDictionarys(@RequestParam("ids[]") Long[] ids , Model model){
        ResponseData result = restTemplate.postForObject(DICTIONARY_URL + "dic/dictionary/deleteMany",
                ids, ResponseData.class);
        return result;
    }

    @GetMapping("/admin/dictionary/delete/{id}")
    public String delete(@PathVariable Long id , Model model){
        restTemplate.delete(DICTIONARY_URL + "dic/dictionary/" + id);
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
