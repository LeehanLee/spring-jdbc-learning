package com.infinite.service;

import java.util.List;
import java.util.Map;

import com.infinite.entity.Account;

public interface IAccountService {

	Account getAccountById(int id);
	
	List<Map<String, Object>> getAccountsMapByName(String name);

	List<Account> getAccountsByName(String name);
}
