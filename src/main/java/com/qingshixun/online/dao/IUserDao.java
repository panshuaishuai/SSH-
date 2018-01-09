package com.qingshixun.online.dao;

import java.util.List;

import com.qingshixun.online.model.Page;
import com.qingshixun.online.model.UserModel;

public interface IUserDao {
	
	Page<UserModel> findUserPage(int pageNo, int pageSize, String username);

	long getTotalPages(int totalCount, int pageSize);
	
	void add(UserModel user);
	
	UserModel update(Long userId);
	
	void delete(Long userId);
	
	void saveOrUpdate(UserModel user);
	
	List getUserGenderNumbers();
	
	List getUserCreateDateNumbers();
}
