package com.springinpractice.ch01.dao;

import com.springinpractice.ch01.model.Account;

import java.util.List;

/**
 * 04. 인터페이스에 구현할 메소드 추가
 */
public interface AccountDao {

  List<Account> findAll() throws Exception;

}
