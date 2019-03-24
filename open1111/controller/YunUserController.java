package yun.open1111.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yun.open1111.entity.PageBean;
import yun.open1111.entity.Resources;
import yun.open1111.entity.YunUser;
import yun.open1111.service.ResourcesService;
import yun.open1111.service.YunUserService;
import yun.open1111.util.PageUtil;
import yun.open1111.util.StringUtil;

/**
 * 百度云资源Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/yunUser")
public class YunUserController {

	@Resource
	private YunUserService yunUserService;
	
	@Resource
	private ResourcesService resourcesService;
	
	/**
	 * 分页查询百度云用户信息
	 * @param q
	 * @param page
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/{userUk}")
	public ModelAndView homePage(@PathVariable("userUk")String userUk,@RequestParam(value="page",required=false)String page,HttpServletRequest request)throws Exception{
		ModelAndView mav=new ModelAndView();
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),20);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("userUk", userUk);
		YunUser yunUser=yunUserService.findById(userUk);
		List<Resources> resourceList=resourcesService.list(map);
		Long total=resourcesService.getTotal(map);
		mav.addObject("yunUser", yunUser);
		mav.addObject("resourceList", resourceList);
		mav.addObject("mainPage", "foreground/yunUser/homePage.jsp");
		mav.addObject("pageTitle", "百度云用户信息");
		mav.addObject("modeName", "百度云用户信息");
		mav.addObject("total", total);
		mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/yunUser/"+userUk+".html", total, Integer.parseInt(page), 20, ""));
		mav.setViewName("mainTemp");
		return mav;
	}
	
	/**
	 * 分页查询百度云用户信息
	 * @param q
	 * @param page
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page,HttpServletRequest request)throws Exception{
		ModelAndView mav=new ModelAndView();
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),100);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<YunUser> yunUserList=yunUserService.list(map);
		Long total=yunUserService.getTotal(map);
		mav.addObject("yunUserList", yunUserList);
		mav.addObject("mainPage", "foreground/yunUser/list.jsp");
		mav.addObject("pageTitle", "百度云用户列表");
		mav.addObject("modeName", "百度云用户列表");
		mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/yunUser/list.html", total, Integer.parseInt(page), 100, ""));
		mav.setViewName("mainTemp");
		return mav;
	}
	
	
}
