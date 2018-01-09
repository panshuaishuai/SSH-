package com.qingshixun.online.service;

import java.util.List;
import java.util.Map;

import com.qingshixun.online.model.ChartData;
import com.qingshixun.online.model.Page;
import com.qingshixun.online.model.UserModel;

public interface IUserService {
	
	Page<UserModel> getUsers(int pageNo, int pageSize, String username);

	long getTotalPages(int totalCount, int pageSize);
	
    void add(UserModel user);
	
	UserModel update(Long userId);
	
	void delete(Long userId);
	
	void saveOrUpdate(UserModel user);
	
	ChartData getUserGenderData();
	
	ChartData getUserCreateData();
}
