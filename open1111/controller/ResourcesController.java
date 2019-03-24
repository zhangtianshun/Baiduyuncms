package yun.open1111.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yun.open1111.entity.PageBean;
import yun.open1111.entity.Resources;
import yun.open1111.service.ResourcesService;
import yun.open1111.util.PageUtil;
import yun.open1111.util.StringUtil;

/**
 * �ٶ�����ԴController
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/resources")
public class ResourcesController {

	@Resource
	private ResourcesService resourcesService;
	
	/**
	 * ��ҳ��ѯ�ٶ�����Դ��Ϣ ������¼���ڽ�������
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
		List<Resources> resourcesList=resourcesService.list(map);
		Long total=resourcesService.getTotal(map);
		mav.addObject("resourcesList", resourcesList);
		mav.addObject("mainPage", "foreground/resources/list.jsp");
		mav.addObject("pageTitle", "�ٶ�����Դ�б�");
		mav.addObject("modeName", "�ٶ�����Դ�б�");
		mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/resources/list.html", total, Integer.parseInt(page), 100, ""));
		mav.setViewName("mainTemp");
		return mav;
	}
	
	/**
	 * ������Դ����ģʽ��ҳ��ѯ�ٶ�����Դ��Ϣ
	 * @param q
	 * @param page
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/q")
	public ModelAndView query(String q,@RequestParam(value="page",required=false)String page,HttpServletRequest request)throws Exception{
		ModelAndView mav=new ModelAndView();
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),10);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("name", StringUtil.formatLike(q));
		List<Resources> resourcesList=resourcesService.list(map);
		Long total=resourcesService.getTotal(map);
		mav.addObject("resourcesList", resourcesList);
		mav.addObject("mainPage", "foreground/resources/list.jsp");
		mav.addObject("pageTitle", "����-"+q);
		mav.addObject("modeName", "�ٶ�����Դ��������б�");
		mav.addObject("q", q);
		mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/resources/q.html", total, Integer.parseInt(page), 10, "q="+q));
		mav.setViewName("mainTemp");
		return mav;
	}
	
	/**
	 * ����������ϸ��Ϣ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/{id}")
	public ModelAndView details(@PathVariable("id")Integer id)throws Exception{
		ModelAndView mav=new ModelAndView();
		Resources resources=resourcesService.findById(id);
		resources.setHits(resources.getHits()+1);
		resourcesService.update(resources);
		mav.addObject("resources", resources);
		mav.addObject("pageTitle", resources.getName());
		mav.addObject("randResourceList", resourcesService.randomList(20));
		mav.addObject("mainPage", "foreground/resources/view.jsp");
		mav.addObject("modeName", "�ٶ�����Դ����");
		mav.setViewName("mainTemp");
		return mav;
	}
	
	/**
	 * ����ָ��Jar�� ��ת����Դҳ��
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/download/{id}")
	public String download(@PathVariable("id")Integer id,HttpServletResponse response)throws Exception{
		Resources resources=resourcesService.findById(id);
		resources.setDownloads(resources.getDownloads()+1);
		resourcesService.update(resources);
		response.sendRedirect(resources.getShareUrl());
		return null;
	}
}
