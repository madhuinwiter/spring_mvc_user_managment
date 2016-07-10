package com.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.user.bean.UserBean;
import com.user.model.User;
import com.user.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("command") UserBean userBean, 
			BindingResult result) {
		User user = prepareModel(userBean);
		userService.addUser(user);
		return new ModelAndView("redirect:/add");
	}

	@RequestMapping(value="/users", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users",  prepareListofBean(userService.listUsers()));
		return new ModelAndView("usersList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addUser(@ModelAttribute("command")  UserBean userBean,
			BindingResult result) {
		
		List<String> genderList = new ArrayList<String>();
		genderList.add("M");
		genderList.add("F");
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users",  prepareListofBean(userService.listUsers()));
		model.put("genderList", genderList);
		
		return new ModelAndView("addUser", model);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editUser(@ModelAttribute("command")  UserBean userBean,
			BindingResult result) {
		userService.deleteUser(prepareModel(userBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", null);
		model.put("users",  prepareListofBean(userService.listUsers()));
		return new ModelAndView("addUser", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam Integer id,
			@ModelAttribute("command")  UserBean userBean,
			BindingResult result) {
		List<String> genderList = new ArrayList<String>();
		genderList.add("M");
		genderList.add("F");
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("user", prepareUserBean(userService.getUser(id)));
		model.put("users",  prepareListofBean(userService.listUsers()));
		model.put("genderList", genderList);
		
		return new ModelAndView("addUser", model);
	}
	
	private User prepareModel(UserBean userBean){
		User user = new User();
		
		user.setUserId(userBean.getUserId());
		user.setFirstName(userBean.getFirstName());
		user.setMiddleName(userBean.getMiddleName());
		user.setLastName(userBean.getLastName());
		user.setAge(userBean.getAge());
		user.setGender(userBean.getGender());
		user.setPhone(userBean.getPhone());
		user.setZip(userBean.getZip());
		
		return user;
	}
	
	private List<UserBean> prepareListofBean(List<User> users){
		List<UserBean> beans = null;
		if(users != null && !users.isEmpty()){
			beans = new ArrayList<UserBean>();
			UserBean bean = null;
			for(User user : users){
				bean = new UserBean();
				
				bean.setUserId(user.getUserId());
				bean.setFirstName(user.getFirstName());
				bean.setMiddleName(user.getMiddleName());
				bean.setLastName(user.getLastName());
				bean.setAge(user.getAge());
				bean.setGender(user.getGender());
				bean.setPhone(user.getPhone());
				bean.setZip(user.getZip());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private UserBean prepareUserBean(User user){
		UserBean bean = new UserBean();
		
		bean.setUserId(user.getUserId());
		bean.setFirstName(user.getFirstName());
		bean.setMiddleName(user.getMiddleName());
		bean.setLastName(user.getLastName());
		bean.setAge(user.getAge());
		bean.setGender(user.getGender());
		bean.setPhone(user.getPhone());
		bean.setZip(user.getZip());
		
		return bean;
	}
}
