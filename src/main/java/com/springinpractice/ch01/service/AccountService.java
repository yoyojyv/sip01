package com.springinpractice.ch01.service;

import com.springinpractice.ch01.dao.jdbc.JdbcAccountDao;
import org.apache.commons.dbcp.BasicDataSource;

import java.io.InputStream;
import java.util.Properties;

/**
 * 02. 생성자에서 dataSource 를 직접 생성하고 있음. BasicDataSource 와 긴밀한 연결.
 */
public class AccountService {

  private JdbcAccountDao accountDao;

  public AccountService() {
    try {
      Properties props = new Properties();
      InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("dataSource.properties");
      props.load(inputStream);
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(props.getProperty("driverClassName"));
      dataSource.setUrl(props.getProperty("url"));
      dataSource.setUsername(props.getProperty("username"));
      dataSource.setPassword(props.getProperty("password"));
      accountDao = new JdbcAccountDao();
      accountDao.setDataSource(dataSource);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

}
