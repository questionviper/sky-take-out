package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    @Select("select * from setmeal where id = #{id}")
    Setmeal getById(Long id);

    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    @AutoFill(OperationType.UPDATE)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void update(Setmeal setmeal);

    @Insert("insert into setmeal (category_id, name, price, status, description, image, create_time, update_time, create_user, update_user) VALUES " +
            "(#{categoryId}, #{name}, #{price}, #{status}, #{description},#{image}, #{createTime}, #{updateTime},#{createUser},#{updateUser})")
    @AutoFill(OperationType.INSERT)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Setmeal setmeal);

    @Delete("delete from setmeal where id = #{id}")
    void deleteById(Long id);



    /**
     * 动态条件查询套餐
     * @param setmeal
     * @return
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据套餐id查询菜品选项
     * @param setmealId
     * @return
     */
    @Select("select sd.name, sd.copies, d.image, d.description " +
            "from setmeal_dish sd left join dish d on sd.dish_id = d.id " +
            "where sd.setmeal_id = #{setmealId}")
    List<DishItemVO> getDishItemBySetmealId(Long setmealId);

    /**
     * 根据条件统计套餐数量
     * @param map
     * @return
     */
    Integer countByMap(Map map);
}
