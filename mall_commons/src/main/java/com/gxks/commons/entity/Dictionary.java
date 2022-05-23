package com.gxks.commons.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 字典数据实体，与数据库 dictionary 表映射
 * @author Mr.gao
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("dictionary")
public class Dictionary implements Serializable {
    // ID 主键
    @TableId
    private Long dicId;
    // 字典类型
    private String dicType;
    // 字典内容
    private String dicContext;
    // 父节点 ID
    private Long parentId;

}
