package com.qingshixun.online.dao.iml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qingshixun.online.dao.IUserDao;
import com.qingshixun.online.model.Page;
import com.qingshixun.online.model.UserModel;

@Repository("userDao")
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(UserModel user) {
		Session session = sessionFactory.getCurrentSession();
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		session.save(user);
	}

	@Override
	public UserModel update(Long userId) {
		return (UserModel)sessionFactory.getCurrentSession().get(UserModel.class, userId);
	}

	@Override
	public void delete(Long userId) {
		Session session = sessionFactory.getCurrentSession();
		UserModel obj = (UserModel)session.get(UserModel.class, userId);
		session.delete(obj);
	}

	/**
	 * 获取根据性别分组统计数据
	 */
	@Override
	public List getUserGenderNumbers() {
		return sessionFactory.getCurrentSession()
				.createQuery("select count(*) as number,sex from UserModel group by sex").list();
	}

	/**
	 * 获取根据创建日期分组统计数据
	 */
	@Override
	public List getUserCreateDateNumbers() {
		return sessionFactory.getCurrentSession()
				.createQuery("select count(*) as number,DATE_FORMAT(createTime, '%Y-%m-%d') from UserModel group by DATE_FORMAT(createTime, '%Y-%m-%d')")
				.list();
	}

	@Override
	public void saveOrUpdate(UserModel user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public Page<UserModel> findUserPage(int pageNo, int pageSize, String username) {
		List<UserModel> result = new ArrayList<UserModel>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserModel.class);
		final Page<UserModel> page = new Page<UserModel>();
		//如果用户名不为空，则进行模糊查询
		if (username != null) {
			criteria.add(Restrictions.like("username", "%" +username+ "%"));
		}
		//数据总数用于计算有多少分页
		int totalCount = criteria.list().size();
		//设置分页查询的结果
		criteria.setFirstResult((pageNo-1)*pageSize);
		criteria.setMaxResults(pageSize);
		
		//分页查询结果
		result = criteria.list();
		page.setResult(result);
		page.setTotalCount(totalCount);
		return page;
	}
	
	/**
	 * 根据pageSize与totalCount计算总页数，默认为-1
	 * @param totalCount
	 * @param pageSize
	 * @return
	 */
	@Override
	public long getTotalPages(int totalCount, int pageSize) {
        if (totalCount < 0) {
            return -1;
        }
        long count = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            count++;
        }
        return count;
    }
}