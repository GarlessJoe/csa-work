import com.cong.domine.Account;
import com.cong.service.AccountService;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AccountServicetest {
    @Test
    public void  TestfindAll(){
        AccountService accountService = new AccountService();
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
    @Test
    public void testInsert() throws Exception{
        AccountService accountService = new AccountService();
        accountService.insert();
        accountService.close();
    }
    @Test
    public void testDelete() throws Exception{
        AccountService accountService = new AccountService();
        System.out.println("======请输入你想要删除的id======");
        String id = new Scanner(System.in).next();
        if(accountService.selectById(id)!=null) {
            accountService.deleteById(id);
            accountService.close();
        }
        else{
            System.out.println("您想要查询的account不存在");
        }
    }
    @Test
    public void testUpdate()throws Exception{
        AccountService accountService = new AccountService();
        HashMap<String, Object> map = new HashMap<>();
        accountService.updateByprimarykey(map);
        accountService.close();
    }
        @Test
        public void  TestselectById(){
            AccountService accountService = new AccountService();
            System.out.print("输入你想要查找的account的id:");
            Account account = accountService.selectById(new Scanner(System.in).next());
            System.out.println(account);
        }
        @Test
    public void TestTransfer()throws Exception{
            AccountService accountService = new AccountService();
            System.out.print("输入转出账户id:");
            String chuId = new Scanner(System.in).next();
            System.out.print("输入转入账户id:");
            String jinId = new Scanner(System.in).next();
            System.out.println("输入转账金额:");
            int money = new Scanner(System.in).nextInt();
            accountService.transfer(chuId,jinId,money);
            accountService.close();
        }
}
