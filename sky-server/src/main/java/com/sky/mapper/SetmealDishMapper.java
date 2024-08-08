package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    //select setmeal id from setmeal_dish from where dish_id in
    List<Long> getSetmealDishIdsByDishIds(List<Long> dishIds);

    void update(SetmealDish dish);

    @Insert("insert into setmeal_dish (setmeal_id, dish_id, name, price, copies) VALUES " +
            "(#{setmealId},#{dishId},#{name},#{price},#{copies})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(SetmealDish dish);

    List<SetmealDish> getSetmealDishesBySetmealId(Long setmealId);

    @Select("select * from setmeal_dish where id = #{id}")
    SetmealDish getById(Long id);

    @Delete("delete from setmeal_dish where setmeal_id = #{setmealId}")
    void deleteById(Long setmealId);
}
