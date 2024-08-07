package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

import java.util.List;

public interface DishService {

    public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);


    public void saveWithFlavor(DishDTO dishDTO);

    void deleteBatch(List<Long> ids);
}
