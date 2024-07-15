/** 
 * 模块：报表系统-SysRoleApi
 */
package com.springreport.controller.sysroleapi;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.springreport.base.BaseController;
import com.springreport.base.BaseEntity;
import com.springreport.base.Response;
import com.springreport.constants.Constants;
import com.springreport.entity.sysroleapi.SysRoleApi;
import com.springreport.annotation.Check;
import com.springreport.annotation.MethodLog;
import com.springreport.api.sysroleapi.ISysRoleApiService;

 /**  
* @Description: SysRoleApicontroller类
* @author 
* @date 2021-06-15 07:11:53
* @version V1.0  
 */
@RestController
@RequestMapping("/springReport/api/sysRoleApi")
public class SysRoleApiController extends BaseController {

	/**
	 * iSysRoleApiService服务注入
	 */
	@Autowired
	private ISysRoleApiService iSysRoleApiService;

	/** 
	* @Description: 分页查询表格
	* @param SysRoleApi
	* @param @return  
	* @return Response
	* @throws 
	*/ 
	@RequestMapping(value = "/getTableList",method = RequestMethod.POST)
	@MethodLog(module="SysRoleApi",remark="获取页面表格数据",operateType=Constants.OPERATE_TYPE_SEARCH)
	public Response getTableList(@RequestBody SysRoleApi model)
	{
		
		BaseEntity result = new BaseEntity();
		result = iSysRoleApiService.tablePagingQuery(model);
		return Response.success(result);
	}

	/** 
	* @Description: 获取详细信息
	* @param id
	* @param @return  BaseEntity
	* @return  
	* @throws 
	*/ 
	@RequestMapping(value = "/getDetail",method = RequestMethod.GET)
	@MethodLog(module="SysRoleApi",remark="获取详细信息",operateType=Constants.OPERATE_TYPE_SEARCH)
	@Check({"id:required#主键ID"})
	public Response getDetail(@RequestParam Long id) throws Exception
	{
		BaseEntity result = iSysRoleApiService.getDetail(id);
		return Response.success(result);
	}

	/**
	* @throws Exception  
	* @Description: 新增
	* @param SysRoleApi
	* @return Response 
	* @throws 
	*/ 
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	@MethodLog(module="SysRoleApi",remark="新增",operateType=Constants.OPERATE_TYPE_ADD)
	@Check({"merchantNo:required#商户号;length#商户号#20",})
	public Response insert(@RequestBody SysRoleApi model) throws Exception
	{
		BaseEntity result = iSysRoleApiService.insert(model);
		return Response.success(result.getStatusMsg());
	}

	/**
	* @throws Exception  
	* @Description: 更新
	* @param SysRoleApi
	* @return  BaseEntity
	* @throws 
	*/ 
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@MethodLog(module="SysRoleApi",remark="更新",operateType=Constants.OPERATE_TYPE_UPDATE)
	@Check({"id:required#主键ID","merchantNo:required#商户号;length#商户号#20",})
	public Response update(@RequestBody SysRoleApi model) throws Exception
	{
		BaseEntity result = iSysRoleApiService.update(model);
		return Response.success(result.getStatusMsg());
	}

	/** 
	* @Description: 单条删除
	* @param id
	* @return  BaseEntity
	* @throws 
	*/ 
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	@MethodLog(module="SysRoleApi",remark="单条删除",operateType=Constants.OPERATE_TYPE_DELETE)
	@Check({"id:required#主键ID"})
	public Response delete(@RequestParam Long id)
	{
		BaseEntity result = iSysRoleApiService.delete(id);
		return Response.success(result.getStatusMsg());
	}

	/** 
	* @Description: 批量删除
	* @param SysRoleApi 
	* @return Response 
	* @throws 
	*/ 
	@RequestMapping(value = "/deletebatch",method = RequestMethod.POST)
	@MethodLog(module="SysRoleApi",remark="批量删除",operateType=Constants.OPERATE_TYPE_BATCHDELETE)
	public Response deletebatch(@RequestBody List<Long> ids)
	{
		BaseEntity result = iSysRoleApiService.deleteBatch(ids);
		return Response.success(result.getStatusMsg());
	}
}
