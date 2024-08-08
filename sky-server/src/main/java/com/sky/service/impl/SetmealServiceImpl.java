package com.sky.service.impl;

import com.sky.mapper.SetmealMapper;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealMapper setmealMapper;
    @Override
    public SetmealVO getById(Long id) {
        return setmealMapper.getById(id);
    }
}
