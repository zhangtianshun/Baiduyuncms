package yun.open1111.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import yun.open1111.entity.PageBean;
import yun.open1111.entity.YunUser;
import yun.open1111.service.YunUserService;
import yun.open1111.util.ResponseUtil;

/**
 * 百度云用户后台管理Controller类
 * @author user
 *
 */
@Controller
@RequestMapping("/admin/yunUser")
public class YunUserAdminController {

	@Resource
	private YunUserService yunUserService;
	
	/**
	 * 分页查询百度云用户信息
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,YunUser yunUser,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("userUk", yunUser.getUserUk());
		List<YunUser> yunUserList=yunUserService.list(map);
		Long total=yunUserService.getTotal(map);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(yunUserList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 删除百度云用户信息
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids",required=false)String ids,HttpServletResponse response)throws Exception{
		String []idsStr=ids.split(",");
		JSONObject result=new JSONObject();
		for(int i=0;i<idsStr.length;i++){
			yunUserService.delete(Integer.parseInt(idsStr[i]));
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 添加或者修改百度云用户信息
	 * @param yunUser
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(YunUser yunUser,String flag,HttpServletResponse response)throws Exception{
		int resultTotal=0; // 操作的记录条数
		if("add".equals(flag)){
			resultTotal=yunUserService.add(yunUser);
		}else{
			resultTotal=yunUserService.update(yunUser);
		}
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
}
