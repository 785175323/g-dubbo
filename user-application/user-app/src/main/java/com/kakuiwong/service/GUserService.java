package com.kakuiwong.service;

import com.kakuiwong.mapper.GUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: gaoyang
 * @Description:
 */
@Service
public class GUserService {

    @Autowired
    GUserMapper userMapper;

    public Object infoById(Long id) {
        return userMapper.selectById(id);
    }
}
