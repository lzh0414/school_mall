package com.gxks.mall_dictionary.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxks.commons.entity.Dictionary;
import org.apache.ibatis.annotations.Mapper;

/**
 * 字典模块持久层接口
 */
@Mapper
public interface DictionaryDao extends BaseMapper<Dictionary> {

}
