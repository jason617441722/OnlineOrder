package com.begonia.firstproject.controller;

import com.begonia.firstproject.entity.MenuItem;
import com.begonia.firstproject.entity.Restaurant;
import com.begonia.firstproject.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import java.util.List;

@Controller
public class MenuInfoController {
    @Autowired
    private MenuInfoService menuInfoService;


    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody //return List<MenuItem> as Json格式的数据返回回去
    //Use the @ResponseBody annotation on a method to indicate that the return value should be
    // written straight to the HTTP response body, and it will be automatically convert to json format

    public List<MenuItem> getMenus(@PathVariable("restaurantId") int restaurantId) {//提取路径当中的restaurantid，然后找到这个restaurant的menu
        return menuInfoService.getAllMenuItem(restaurantId);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> getRestaurants() {
        return menuInfoService.getRestaurants();
    }
}

