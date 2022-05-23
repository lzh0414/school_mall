package com.gxks.mall_dictionary.service.impl;

import com.gxks.commons.entity.Dictionary;
import com.gxks.mall_dictionary.dao.DictionaryDao;
import com.gxks.mall_dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 字典模块业务逻辑实现
 */
@Service
@Transactional
public class DictionaryServiceImpl implements DictionaryService {


    @Autowired
    private DictionaryDao dictionaryDao;

    /**
     * 根据主键查询字典数据
     * @param id
     * @return
     */
    @Override
    public Dictionary getDictionaryById(Long id) {
        return dictionaryDao.selectById(id);
    }

    @Override
    public List<Dictionary> getDictionaries(Map<String, Object> params) {
        return dictionaryDao.selectList(null);
    }

    @Override
    public int insert(Dictionary dictionary) {
        return dictionaryDao.insert(dictionary);
    }

    @Override
    public int update(Dictionary dictionary) {
        return dictionaryDao.updateById(dictionary);
    }

    @Override
    public int deleteById(Long id) {
        return dictionaryDao.deleteById(id);
    }

    @Override
    public int delete(List<Long> ids) {
        return dictionaryDao.deleteBatchIds(ids);
    }
}
