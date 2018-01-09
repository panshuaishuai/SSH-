package com.qingshixun.online.service.iml;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingshixun.online.dao.iml.UserDao;
import com.qingshixun.online.model.ChartData;
import com.qingshixun.online.model.Page;
import com.qingshixun.online.model.UserModel;
import com.qingshixun.online.service.IUserService;

@Service("userService")
@Transactional
public class UserService implements IUserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void add(UserModel user) {
		userDao.add(user);
	}

	@Override
	public UserModel update(Long userId) {
		return userDao.update(userId);
	}

	@Override
	public void delete(Long userId) {
		userDao.delete(userId);
	}

	/**
	 * 获取用户性别统计数据
	 */
	@Override
	public ChartData getUserGenderData() {
		List userGenderNumbers = userDao.getUserGenderNumbers();
		int genderNumberCount = userGenderNumbers.size();
	        String[] names = new String[genderNumberCount];
	        String[] values = new String[genderNumberCount];
	        //遍历统计数据，转换成 Chart.js 所需要的数据格式
	        for (int i = 0, n = genderNumberCount; i < n; i++) {
	            Object[] genderNumbers = (Object[]) userGenderNumbers.get(i);
	            //性别标签名称，如：male、female
	            names[i] = "\"" + String.valueOf(genderNumbers[1]) + "\"";
	            //性别对应的用户数据
	            values[i] = String.valueOf(genderNumbers[0]);
	        }
	        ChartData userGenderData = new ChartData();
	        userGenderData.setNames("[" + String.join(",", names) + "]");
	        userGenderData.setValues("[" + String.join(",", values) + "]");

		return userGenderData;
	}

	/**
	 * 获取用户创建日期统计数据
	 */
	@Override
	public ChartData getUserCreateData() {
		List userCreateDateNumbers = userDao.getUserCreateDateNumbers();
		int size = userCreateDateNumbers.size();
		String[] names = new String[size];
		String[] values = new String[size];
		for (int i = 0; i < size; i++) {
			Object[] obj = (Object[]) userCreateDateNumbers.get(i);
			names[i] = "\"" + String.valueOf(obj[1]) + "\"";
			values[i] = String.valueOf(obj[0]);
		}
		ChartData userCreateDateData = new ChartData();
		userCreateDateData.setNames("[" + String.join(",", names) + "]");
		userCreateDateData.setValues("[" + String.join(",", values) + "]");
		return userCreateDateData;
	}

	@Override
	public void saveOrUpdate(UserModel user) {
		userDao.saveOrUpdate(user);
	}

	@Override
	public Page<UserModel> getUsers(int pageNo, int pageSize, String username) {
		Page<UserModel> userPage = userDao.findUserPage(pageNo, pageSize, username);
		return userPage;
	}

	@Override
	public long getTotalPages(int totalCount, int pageSize) {
		return userDao.getTotalPages(totalCount, pageSize);
	}
}
