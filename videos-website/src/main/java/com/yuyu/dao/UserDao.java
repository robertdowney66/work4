package com.yuyu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuyu.pojo.DO.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
/**
 * 用于user的crud操作
 */
public interface UserDao extends BaseMapper<User> {

    /**
     * 通过id查询user所对应的角色
     * @param userid
     * @return
     */
    Integer getRidByUserId(Long userid);
}
