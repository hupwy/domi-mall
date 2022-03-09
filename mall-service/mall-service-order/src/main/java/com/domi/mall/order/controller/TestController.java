package com.domi.mall.order.controller;

import com.domi.mall.common.util.utility.RespResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: <a href="mailto:hupeng@neuedu.com">hupeng</a>
 * @Date: 2022-03-09 16:32
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public RespResult add() {
        return RespResult.ok();
    }
}
