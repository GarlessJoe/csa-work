package com.cong.dao;

import com.cong.domine.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AccountDao {
    //查询所有记录
    List<Account> findAll();
    //通过id删除记录
    int deleteById(@Param("id") String id);
    //插入记录
    int insert(Account record);
    //通过id查找对象
    Account selectById(@Param("id")String id);
    //更新account
    int updateByprimarykey(@Param("map") Map map);
    //实现转账
int updateTransfer(@Param("money")int money,@Param("id")String id);
}
