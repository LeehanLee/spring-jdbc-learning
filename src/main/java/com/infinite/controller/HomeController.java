package com.infinite.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.entity.Account;
import com.infinite.service.IAccountService;

@RestController
public class HomeController {

	@Autowired
	IAccountService accountService;
	
	@RequestMapping("/")
	public Account index(int id){
		return accountService.getAccountById(id); 
	}
	
	@RequestMapping("/getAccountsMapByName")
	public List<Map<String, Object>> getAccountsMapByName(String name){
		return accountService.getAccountsMapByName(name);
	}
	
	@RequestMapping("/getAccountsByName")
	public List<Account> getAccountsByName(String name){
		return accountService.getAccountsByName(name);
	}
}
