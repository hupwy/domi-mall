package com.domi.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.domi.mall.goods.mapper.BrandMapper;
import com.domi.mall.goods.model.Brand;
import com.domi.mall.goods.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: <a href="mailto:hupeng@neuedu.com">hupeng</a>
 * @Date: 2022-03-09 16:34
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {


    @Autowired
    private BrandMapper brandMapper;

    /****
     * 条件查询
     * return List<Brand>
     */
    @Override
    public List<Brand> queryList(Brand brand) {
        //条件包装对象
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        //根据name查询品牌
        queryWrapper.like("name", brand.getName());

        //根据initial查询
        queryWrapper.eq("initial", brand.getInitial());
        return brandMapper.selectList(queryWrapper);
    }

    /****
     * 条件分页查询
     * return Page<Brand>
     */
    @Override
    public Page<Brand> queryPageList(Brand brand, Long page, Long size) {
        //条件包装对象
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        //根据name查询品牌
        queryWrapper.like("name", brand.getName());
        return brandMapper.selectPage(new Page<>(page, size), queryWrapper);
    }

    /****
     * 根据分类ID查询品牌集合
     * @param id:分类ID
     */
    @Override
    public List<Brand> queryByCategoryId(Integer id) {
        // 根据分类ID查询品牌ID集合
        List<Integer> brandIds = brandMapper.queryBrandIds(id);
        // 根据品牌ID集合查询品牌集合
        if (brandIds != null && brandIds.size() > 0) {
            return brandMapper.selectList(new QueryWrapper<Brand>().in("id", brandIds));
        }
        return null;
    }
}
