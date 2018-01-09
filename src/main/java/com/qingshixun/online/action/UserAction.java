package com.qingshixun.online.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.qingshixun.online.model.ChartData;
import com.qingshixun.online.model.Page;
import com.qingshixun.online.model.UserModel;
import com.qingshixun.online.service.IUserService;

@Controller("userAction")
@Namespace("/")
@ParentPackage("package")
@Scope("prototype")
public class UserAction {
	
	@Autowired
	private IUserService userService;
	
	//默认每页显示记录数
    private static final int DEFAULT_PAGE_SIZE = 5;
	
	private UserModel user = new UserModel();
	
	private ChartData userGenderData;
	
	private ChartData userCreateData;
	
	private Long userId;
	
	private Page<UserModel> userPage;
	
	private int pageNo = 1;
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Page<UserModel> getUserPage() {
		return userPage;
	}

	public void setUserPage(Page<UserModel> userPage) {
		this.userPage = userPage;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public ChartData getUserGenderData() {
		return userGenderData;
	}

	public void setUserGenderData(ChartData userGenderData) {
		this.userGenderData = userGenderData;
	}

	public ChartData getUserCreateData() {
		return userCreateData;
	}

	public void setUserCreateData(ChartData userCreateData) {
		this.userCreateData = userCreateData;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Action(value = "index" , results = { @Result(name = "success", location = "/WEB-INF/views/userList.jsp") })
	public String index() {
		return "success";
	}
	
	@Action(value = "list" , results = { @Result(name = "success", location = "/WEB-INF/views/list.jsp") })
	public String list() {
		userPage = userService.getUsers(pageNo, DEFAULT_PAGE_SIZE, user.getUsername());
		return "success";
	}
	
	@Action(value = "add" , results = { @Result(name = "success", location = "/WEB-INF/views/userAdd.jsp") })
	public String userAdd() {
		return "success";
	}
	 
	@Action(value = "userAdd" , results = { @Result(name = "success", type = "json")})
	public String add() {
		userService.add(user);
		return "success";
	}
	
	@Action(value = "analyze" , results = { @Result(name = "success", location = "/WEB-INF/views/analyze.jsp") })
	public String userAnalyze() {
		userGenderData = userService.getUserGenderData();
		userCreateData = userService.getUserCreateData();
		return "success";
	}
	
	@Action(value = "update" , results = { @Result(name = "success", location = "/WEB-INF/views/update.jsp")})
	public String update() {
		user = userService.update(userId);
		return "success";
	}
	
	@Action(value = "updateOrSave", results = { @Result(name = "success", type = "json")})
	public String saveOrUpdate() {
        userService.saveOrUpdate(user);
		return "success";
	}
	
	@Action(value = "delete" , results = { @Result(name = "success", type = "json") })
	public String delete() {
        userService.delete(userId);
		return "success";
	}
}
