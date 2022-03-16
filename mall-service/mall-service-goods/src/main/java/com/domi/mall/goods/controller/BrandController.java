package com.domi.mall.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.domi.mall.common.util.utility.RespResult;
import com.domi.mall.goods.model.Brand;
import com.domi.mall.goods.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: <a href="mailto:hupeng@neuedu.com">hupeng</a>
 * @Date: 2022-03-09 16:32
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    /****
     * 测试接口
     */
    @GetMapping(value = "/test")
    public String test() {
        return "测试成功";
    }

    /****
     * 增加方法
     */
    @PostMapping
    public RespResult add(@RequestBody Brand brand) {
        brandService.save(brand);
        return RespResult.ok();
    }

    /****
     * 修改方法
     */
    @PutMapping
    public RespResult update(@RequestBody Brand brand) {
        brandService.updateById(brand);
        return RespResult.ok();
    }

    /****
     * 删除方法
     */
    @DeleteMapping("/{id}")
    public RespResult delete(@PathVariable(value = "id") String id) {
        brandService.removeById(id);
        return RespResult.ok();
    }

    /****
     * 条件查询
     */
    @PostMapping(value = "/search")
    public RespResult<List<Brand>> queryList(@RequestBody Brand brand) {
        List<Brand> brands = brandService.queryList(brand);
        return RespResult.ok(brands);
    }

    /****
     * 条件查询
     */
    @PostMapping(value = "/search/{page}/{size}")
    public RespResult<Page<Brand>> queryPageList(@PathVariable(value = "page") Long page, @PathVariable(value = "size") Long size, @RequestBody Brand brand) {
        Page<Brand> pageInfo = brandService.queryPageList(brand, page, size);
        return RespResult.ok(pageInfo);
    }

    /****
     * 根据分类ID查询品牌集合
     * http://localhost:9001/brand/category/11159
     * http://192.168.100.130/msitems/1.html
     */
    @GetMapping(value = "/category/{pid}")
    public RespResult<List<Brand>> categoryBrands(@PathVariable(value = "pid") Integer pid) throws InterruptedException {
        System.out.println("执行查询开始，，，，");
        List<Brand> brands = brandService.queryByCategoryId(pid);
        TimeUnit.SECONDS.sleep(10);
        System.out.println("执行查询完成，，，，");
        return RespResult.ok(brands);
    }
}
