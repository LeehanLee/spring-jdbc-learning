package com.infinite.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.infinite.entity.Account;

@Service
public class AccountService implements IAccountService{

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		return (Account) jdbcTemplate.queryForObject("select * from account where id=? limit 0 , 1", new Object[]{id}, new BeanPropertyRowMapper(Account.class));
	}

	@Override
	public List<Map<String, Object>> getAccountsMapByName(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForList("select * from account where locate(?, name)>0 ", new Object[]{name});
	}

	@Override
	public List<Account> getAccountsByName(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from account where locate(?, name)>0 ", new Object[]{name}, new BeanPropertyRowMapper(Account.class));
	}
}
