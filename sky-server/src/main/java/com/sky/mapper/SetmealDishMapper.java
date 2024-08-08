package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    //select setmeal id from setmeal_dish from where dish_id in
    List<Long> getSetmealDishIdsByDishIds(List<Long> dishIds);

    void update(SetmealDish dish);
}
