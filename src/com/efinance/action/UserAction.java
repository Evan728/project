package com.efinance.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.efinance.model.User;
import com.efinance.service.UserService;
import com.efinance.vo.UserLoginInfo;
import com.efinance.vo.UserRegisterInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
	
	/**
	 * 
	 */
	//此处将表单数据封装到实体类中去
	private UserRegisterInfo info;
	private UserLoginInfo logininfo;
	@Resource
	private UserService userService;
	
	
	public UserRegisterInfo getInfo() {
		return info;
	}

	public void setInfo(UserRegisterInfo info) {
		this.info = info;
	}
	public UserLoginInfo getLogininfo() {
		return logininfo;
	}

	public void setLogininfo(UserLoginInfo logininfo) {
		this.logininfo = logininfo;
	}
	//注册用
	public String register() throws Exception {
		
		
		
		User user = new User();
		user.setUsername(info.getUserName());
		user.setPassword(info.getPassword());
		user.setEmail(info.getEmail());
		if(userService.exists(user)) {
			ActionContext.getContext().put("message", "用户名已存在");
			ActionContext.getContext().put("siteurl", "register/index.jsp");
			return "fail";
		}else{
			userService.add(user);
			ActionContext.getContext().put("message", "注册成功");
			ActionContext.getContext().put("siteurl", "index.jsp");
			return "success";
			}
	}	
	//登录时用
	public String login() throws Exception {
		
		User user = userService.verifyUser(logininfo.getUsername(), logininfo.getPassword());
		
		if(user!=null){
			ActionContext.getContext().getSession().put("user", user);
			ActionContext.getContext().put("message", "登录成功！");
			return "login_ok";
			
		}
       else{    
    	        System.out.println("************");
    	        ActionContext.getContext().put("message", "用户名或密码错误");
    			return "userLoginFail";
			}
			
	}	
	//账户设置时用
	public String perfect() throws Exception {
		User user=(User)ActionContext.getContext().getSession().get("user");
		user.setEmail("974265900@qq.com");
		userService.completeUserMessage(user);
		return "complete";
	}
	//系统管理员删除用户时用
	public String deleteUser() throws Exception {
		User user=(User)ActionContext.getContext().getSession().get("user");
		userService.delete(user);
		return "deleteSuccess";
	}
	//系统管理员删除用户时用,    -————————有待验证是否可行！！！！！
	public String deleteUserById() throws Exception {
		userService.deleteUserById(3);
		return "deleteSuccess";
	}
}
