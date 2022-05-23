package com.gxks.mall_dictionary.service;


import com.gxks.commons.entity.Dictionary;

import java.util.List;
import java.util.Map;

/**
 * 字典模块业务逻辑接口
 */
public interface DictionaryService {

    Dictionary getDictionaryById(Long id);

    List<Dictionary> getDictionaries(Map<String,Object> params);

    int insert(Dictionary dictionary);

    int update(Dictionary dictionary);

    int deleteById(Long id);

    int delete(List<Long> ids);
}
