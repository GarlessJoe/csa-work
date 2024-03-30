package com.cong.domine;

import java.time.Instant;
import java.util.Date;

public class Account {
    private String id;
    private String name;
    private int money;
    private Date createtime =  Date.from(Instant.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS));
    private Date updatetime;

    public Account() {
    }

    public Account(String id, String name, int money, Date createtime, Date updatetime) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime)  {this.updatetime = Date.from(Instant.ofEpochMilli(updatetime.getTime()).truncatedTo(java.time.temporal.ChronoUnit.SECONDS));
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}
