package com.springinpractice.ch01.service;

import com.springinpractice.ch01.dao.AccountDao;
import com.springinpractice.ch01.dao.jdbc.JdbcAccountDao;
import com.springinpractice.ch01.model.Account;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * 02. 생성자에서 dataSource 를 직접 생성하고 있음. BasicDataSource 와 긴밀한 연결.
 * 03. AccountDao -> setter 메소드를 이용한 DI
 * 04. findDeliquentAccounts(), daysAgo() 메소드 추가
 */
public class AccountService {

//  private JdbcAccountDao accountDao;
//
//  public AccountService() {
//    try {
//      Properties props = new Properties();
//      InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("dataSource.properties");
//      props.load(inputStream);
//      BasicDataSource dataSource = new BasicDataSource();
//      dataSource.setDriverClassName(props.getProperty("driverClassName"));
//      dataSource.setUrl(props.getProperty("url"));
//      dataSource.setUsername(props.getProperty("username"));
//      dataSource.setPassword(props.getProperty("password"));
//      accountDao = new JdbcAccountDao();
//      accountDao.setDataSource(dataSource);
//    } catch (Exception e) {
//      throw new RuntimeException(e);
//    }
//
//  }

  @Autowired
  @Qualifier("csvAccountDao")
  private AccountDao accountDao;

  public AccountService() {
  }

  public void setAccountDao(AccountDao accountDao) {
    this.accountDao = accountDao;
  }

  public List<Account> findDeliquentAccounts() throws Exception {
    List<Account> delinquentAccounts = new ArrayList<Account>();
    List<Account> accounts = accountDao.findAll();
    Date thirtyDaysAgo = daysAgo(30);


    for (Account account : accounts) {
      boolean owesMoney = account.getBalance()
        .compareTo(BigDecimal.ZERO) > 0;
      boolean thirtyDaysLate = account.getLastPaidOn()
        .compareTo(thirtyDaysAgo) <= 0;
      if (owesMoney && thirtyDaysLate) {
        delinquentAccounts.add(account);
      }
    }
    return delinquentAccounts;
  }

  private static Date daysAgo(int days) {
    GregorianCalendar gc = new GregorianCalendar();
    gc.add(Calendar.DATE, -days);
    return gc.getTime();
  }


}
