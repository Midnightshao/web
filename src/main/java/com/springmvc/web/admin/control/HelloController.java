package com.springmvc.web.admin.control;

import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.admin.server.Server;
import com.springmvc.web.cookie.CookieTool;
import com.springmvc.web.cookie.MD5Util;
import com.springmvc.web.cookie.MD5cookie;
import com.springmvc.web.houtai_picture.entity.HoutaiPictureEntity;
import com.springmvc.web.houtai_picture.server.ServerPicture;
import com.springmvc.web.person.entity.Person;
import com.springmvc.web.person.server.PersonServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {
	public String net=null;

	@Autowired
	public Server server;

	@Autowired
	public PersonServer PersonServer;

	@Autowired
	public ServerPicture serverPicture;


	@RequestMapping("/")
	public String shouye(ModelMap map,HttpServletRequest request,HttpServletResponse response){

		Cookie[] cookie=request.getCookies();

		if(cookie!=null) {

			for (Cookie cookie1:cookie){
				System.out.println("  "+"    22"+cookie1.getName()+"  11"+cookie1.getValue());
			}

			if(cookie.length>1 ) {

				int i=0;

				if(String.valueOf(cookie[i].getName()).equals("JSESSIONID")){
					i=1;
				}
					if (cookie[i].getValue().equals(CookieTool.getCookieByName(request, cookie[i].getName()).getValue())) {

						System.out.println("token 匹配");

						map.put("name","欢迎"+cookie[i].getName());

						Admin admin=server.queryId(cookie[i].getName());

						if(PersonServer.Person_query(Integer.valueOf(cookie[i].getName()))!=null){

							Person person= PersonServer.Person_query(Integer.valueOf(cookie[i].getName()));

							request.getSession().setAttribute("username", person.getName());

							map.put("name","欢迎"+person.getName());
						}else {

							map.put("name","欢迎"+admin.getName());

							request.getSession().setAttribute("username", admin.getName());

						};

						request.getSession().setAttribute("id",admin.getId());

					} else {
					if(request.getSession().getAttribute("username")!=null){

						CookieTool.addCookie(request,response,request.getSession().getAttribute("id").toString(),MD5cookie.md5_shao(),200000);

						map.put("name",request.getSession().getAttribute("username").toString());

						map.put("contact",server.lists());

						return "shouye";

					}
					System.out.println("不匹配1");
					map.put("name","");
				}
			}
		} else {
			System.out.print("不匹配2");
			map.put("name","");
		}

		map.put("contact",server.lists());


		if(serverPicture.query_picture().isEmpty()){
			map.put("contact_picture_first","11111.jpg");
		}else {
			List list=serverPicture.query_picture();
			HoutaiPictureEntity entity= (HoutaiPictureEntity) list.get(0);
			map.put("contact_picture_first",entity.getImg_picture());

			map.put("contact_picture_point",list);
			list.remove(0);
			map.put("contact_picture",list);
		}
		return "shouye";
	};

	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
//		model.addAttribute("message", "Hello world!");
		model.put("message", "");

		return "hello";
	}
	//这个是登录

	@RequestMapping(value = "/hello",method = RequestMethod.POST)
//	@ResponseBody
	public String loginWelcome(HttpServletResponse response,String cookie,HttpServletRequest request,Admin admin,ModelMap map){

		System.out.println(admin.getName()+" "+admin.getPassword());

		admin.setPassword(MD5Util.MD5(admin.getPassword()));

		String cake=cookie;
		//判断cookie
		if(server.listContact(admin,request)==true){
				System.out.println((Integer) request.getSession().getAttribute("id"));
				request.getSession().setAttribute("username", admin.getName());
			if(cake==null||cake==""){
				System.out.println("cookie++++++++++++++++++++++++++++++++");
			}else{
				//已经添加cookie
				System.out.println(cookie + "已经添加cookie+已经添加cookie");
//				CookieTool.addCookie(request,response,admin.getName(),MD5cookie.md5_shao(),10000);

				String name= String.valueOf(request.getSession().getAttribute("id"));

				String password=MD5cookie.md5_shao();

				Cookie cookies = new Cookie(name,password);

				cookies.setMaxAge(10000);

				cookies.setPath("/");

				response.addCookie(cookies);
			}
				System.out.println("登陆成功");

			return "redirect:/";
			} else {
				map.put("message", "用户名或者密码错误");
			return "hello";
		}
	}
	//这个是注册
	@RequestMapping(value = "/hello/register",method = RequestMethod.GET)
	public String register(ModelMap modelMap){
		return  "register";
	}
	@RequestMapping(value = "/hello/register_add",method = RequestMethod.POST)
	public String register_add(Admin admin,ModelMap modelMap,String nicheng,HttpServletRequest request){

		admin.setPassword(MD5Util.MD5(admin.getPassword()));

		if(server.registercontact(admin)){

			request.getSession().setAttribute("username",admin.getName());

			Person person=new Person();

			person.setName(nicheng);

			server.addContact(admin,person);

			return "redirect:/";
		}
		return  "register";
	}
	//验证用户名是否相同
	@RequestMapping(value = "/hello/panduan.do",method = RequestMethod.POST)

	public @ResponseBody ModelMap register_register(Admin admin){

		ModelMap modelMap=new ModelMap();

		if(server.registercontact(admin)){
			modelMap.put("String","");
		}else {
			modelMap.put("String","这个已经注册过了");
		}
		return modelMap;
	}
	//验证跳转到其他页面
	@RequestMapping(value="/luntan",method = RequestMethod.GET)

	public String forum(){
		return  "redirect:/ForumControl/1";
	}
}
