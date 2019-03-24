package yun.open1111.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yun.open1111.service.ResourcesService;
import yun.open1111.service.YunUserService;

/**
 * Ö÷Ò³Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

	@Resource
	private YunUserService yunUserService;
	
	@Resource
	private ResourcesService resourcesService;
	
	@RequestMapping("/index")
	public ModelAndView list()throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.addObject("hotYunUserList", yunUserService.listHot(26));
		mav.addObject("newestResourcesList", resourcesService.listNewest(100));
		mav.setViewName("index");
		return mav;
	}
}
