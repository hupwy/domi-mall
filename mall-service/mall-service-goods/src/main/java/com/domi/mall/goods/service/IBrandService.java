package com.domi.mall.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.domi.mall.goods.model.Brand;

import java.util.List;

/**
 * @Author: <a href="mailto:hupeng@neuedu.com">hupeng</a>
 * @Date: 2022-03-09 16:33
 */
public interface IBrandService  extends IService<Brand> {

    /****
     * 条件查询
     * return List<Brand>
     */
    List<Brand> queryList(Brand brand);

    /****
     * 条件分页查询
     * return Page<Brand>
     */
    Page<Brand> queryPageList(Brand brand, Long currentPage, Long size);

    /***
     * 根据分类ID查询品牌集合
     */
    List<Brand> queryByCategoryId(Integer id);
}
