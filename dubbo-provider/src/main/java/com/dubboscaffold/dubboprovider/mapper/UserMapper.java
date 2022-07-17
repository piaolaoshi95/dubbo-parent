package com.dubboscaffold.dubboprovider.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dubboscaffold.dubboapi.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {

    //使用QueryWrapper构造相对灵活的条件，可以避免一些动态Sql的编写
    default User selectByUsername(@Param("username") String username) {
        return selectOne(new QueryWrapper<User>().eq("username", username));
    }

    List<User> selectByIds(@Param("ids") Collection<Integer> ids);

    //演示分页组件
    default IPage<User> selectPageByCreateTime(IPage<User> page, @Param("createTime") String createTime) {
        return selectPage(page,
                new QueryWrapper<User>().gt("create_time", createTime));
    }

}
