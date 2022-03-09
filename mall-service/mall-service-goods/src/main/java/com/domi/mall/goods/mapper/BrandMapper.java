package com.domi.mall.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.domi.mall.goods.model.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: <a href="mailto:hupeng@neuedu.com">hupeng</a>
 * @Date: 2022-03-09 16:32
 */
public interface BrandMapper extends BaseMapper<Brand> {

    /****
     * 1、根据分类ID查询品牌ID集合
     */
    @Select("SELECT brand_id FROM category_brand WHERE category_id=#{id}")
    List<Integer> queryBrandIds(Integer id);
}
