package com.springinpractice.ch01.dao.jdbc;

import com.springinpractice.ch01.dao.AccountDao;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * 01. JdbcAccountDao 가 org.apache.commons.dbcp.BasicDataSource 와 긴밀하게 연결되어있음
 */
public class JdbcAccountDao implements AccountDao {

  private BasicDataSource dataSource;

  public JdbcAccountDao() {
    dataSource = new BasicDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/springbook" + "?autoReconnect=true");
    dataSource.setUsername("root");
    dataSource.setPassword("");
  }

}
