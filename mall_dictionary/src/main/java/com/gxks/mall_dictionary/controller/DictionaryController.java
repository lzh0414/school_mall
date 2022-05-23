package com.gxks.mall_dictionary.controller;

import com.gxks.commons.entity.Dictionary;
import com.gxks.commons.entity.ResponseData;
import com.gxks.mall_dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 字典模块控制器
 */
@RestController
@RequestMapping("/dic")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/dictionary/{id}")
    public ResponseData<Dictionary> getDictionaryById(@PathVariable Long id){
        Dictionary dictionary = dictionaryService.getDictionaryById(id);
        return new ResponseData<>(200,"ok !",dictionary);
    }

    @GetMapping("/dictionary")
    public ResponseData<List<Dictionary>> getDictionaries(){
        List<Dictionary> list = dictionaryService.getDictionaries(null);
        return new ResponseData<>(200,"ok !",list);
    }

    @PostMapping("/dictionary")
    public ResponseData<Dictionary> insertDictionary(@RequestBody Dictionary dictionary){
        int i = dictionaryService.insert(dictionary);
        if(i > 0){
            return new ResponseData<>(200,"ok !",dictionary);
        }
        return new ResponseData<>(500,"db table can not insert data!",null);
    }

    @PutMapping("/dictionary")
    public ResponseData<Dictionary> updateDictionary(@RequestBody  Dictionary dictionary){
        try {
            int i = dictionaryService.update(dictionary);
            return new ResponseData<>(200,"ok !",dictionary);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return new ResponseData<>(500,"can not update foreign key !!!",null);
    }

    @DeleteMapping("/dictionary/{id}")
    public ResponseData<Long> updateDictionary(@PathVariable Long id){
        try {
            int i = dictionaryService.deleteById(id);
            return new ResponseData<>(200,"ok !",id);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return new ResponseData<>(500,"can not delete data by !" + id,null);
    }

    @PostMapping("/dictionary/deleteMany")
    public ResponseData<List<Long>> updateDictionary(@RequestBody Long[] ids){
        try {
            int i = dictionaryService.delete(Arrays.asList(ids));
            return new ResponseData<>(200,"ok !",Arrays.asList(ids));
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return new ResponseData<>(500,"can not delete datas from dictionary",null);
    }

}
