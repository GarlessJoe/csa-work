package com.cong.service;

import com.cong.dao.AccountDao;
import com.cong.domine.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class AccountService {
    private static SqlSessionFactory sql;
    SqlSession sqlSession = null;
    InputStream inputStream = null;
    AccountDao mapper = null   ;

    public AccountService(){

        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            sql =   new SqlSessionFactoryBuilder().build(inputStream);
        }
        sqlSession = sql.openSession();
        mapper = sqlSession.getMapper(AccountDao.class);
    }
    public  void close() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
    public List<Account> findAll(){
        return mapper.findAll();
    }
    public int deleteById(@Param("id") String id) {

        return  mapper.deleteById(id);
    }

    public int insert(){
        Account account = new Account();
        System.out.println("======请输入你想要添加的信息======");
        System.out.print("id:");
        account.setId(new Scanner(System.in).next());
        System.out.print("name:");
        account.setName(new Scanner(System.in).next());
        System.out.print("money:");
        account.setMoney(new Scanner(System.in).nextInt());
        account.setUpdatetime(new Date());
        return mapper.insert(account);
    }
    public Account selectById(@Param("id")String id){
        return mapper.selectById(id);
    }
    public int updateByprimarykey( @Param("map")Map map){
        System.out.println("======请输入你想要修改的信息的id======");
        String id = new Scanner(System.in).next();
        map = new HashMap<String ,Object>();
        map.put("name" ,null);
        map.put("reid" ,null);
        map.put("money" ,null);
        map.put("id",id);
        int j = 1;
        while(j!=0) {
            System.out.print("输入想要修改的字段:");
            String filed = new Scanner(System.in).next();
            System.out.print("修改后的值为:");
            String values =new Scanner(System.in).next();
            if(filed != "money"){
                map.put(filed , values);
            }
            else{
                map.put(filed , Integer.parseInt(values));
            }
            System.out.println("是否继续：1，0");
            j = new Scanner(System.in).nextInt();
        }
        return mapper.updateByprimarykey(map);
    }
    //实现转账
    public void transfer(String remitterId ,String remittedId ,int money){

            if(selectById(remitterId).getMoney()<money){
                System.out.println("余额不足，转出失败");
            }else{
                mapper.updateTransfer(selectById(remitterId).getMoney()-money,remitterId);
                mapper.updateTransfer(selectById(remittedId).getMoney()+money,remittedId);

            }
    }

}
