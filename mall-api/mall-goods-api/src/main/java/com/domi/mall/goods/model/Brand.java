package com.domi.mall.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: <a href="mailto:hupeng@neuedu.com">hupeng</a>
 * @Date: 2022-03-09 16:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "brand")
public class Brand {
    // 品牌id
    private Integer id;
    // 品牌名称
    private String name;
    // 品牌图片地址
    private String image;
    // 品牌的首字母
    private String initial;
    // 排序
    private Integer sort;
}
