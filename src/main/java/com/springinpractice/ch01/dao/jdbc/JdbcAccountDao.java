package com.springinpractice.ch01.dao.jdbc;

import com.springinpractice.ch01.dao.AccountDao;
import com.springinpractice.ch01.model.Account;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * 01. JdbcAccountDao 가 org.apache.commons.dbcp.BasicDataSource 와 긴밀하게 연결되어있음
 *
 * 02. dataSource -> setter method를 이용하여 설정 하도록 변경
 *
 */
// @Component
@Repository
public class JdbcAccountDao implements AccountDao {

//  private BasicDataSource dataSource;
//
//  public JdbcAccountDao() {
//    dataSource = new BasicDataSource();
//    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//    dataSource.setUrl("jdbc:mysql://localhost:3306/springbook" + "?autoReconnect=true");
//    dataSource.setUsername("root");
//    dataSource.setPassword("");
//  }

  private DataSource dataSource;

  public  JdbcAccountDao() {}

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public List<Account> findAll() throws Exception {
    throw new UnsupportedOperationException("This method has not been implemented");
  }

}
