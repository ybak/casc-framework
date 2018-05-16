package com.hoomsun.app.api.controller.flow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoomsun.core.model.SysRepaymentPlan;
import com.hoomsun.core.server.inter.SysRepaymentPlanServerI;
import com.hoomsun.csas.sales.api.model.UserApply;
import com.hoomsun.csas.sales.api.server.inter.UserApplyServerI;


/**
 * 
 * @author 作者：liudongliang <br>
 * @Date 创建时间：2017年12月22日 <br>
 * @Description 描述    还款计划 
 *           1.  还款计划 列表
 *           192.168.3.19:8080/app-admin/web/repaymentplan/paylist.do?ID=
 *           2.还款计划
 *           http://192.168.3.19:8080/app-admin/web/repaymentplan/repaymentplan.do?applyId=b66911931f834b2eb4490c9734700503
 * 
 *
 */

@Controller
@RequestMapping("web/repaymentplan")
public class RepaymentPlanController {

	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserApplyServerI userApplyServer;
	
	@Autowired
	private SysRepaymentPlanServerI sysRepaymentPlanServerI;
	
	/**
	 * 
	 * @author 刘栋梁
	 * @date 2017-12-22
	 * @resource 还款计划 列表
	 * @LoggerAnnotation(moduleName = "客户单子相关", option = "还款计划")
	 */
	
	@RequestMapping(value = "/paylist.do")
	@ResponseBody
	public Map<String, Object> selectPaylist(HttpServletRequest request) {
		long startTime = System.currentTimeMillis(); // 获取开始时间
		String ID = request.getParameter("ID");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<UserApply> list = userApplyServer.selectAppLoanData(ID);	
			map.put("data", list);
			map.put("errorInfo", "数据查询成功！！！");
			map.put("errorCode", 0);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorInfo", "数据查询失败！");
			map.put("errorCode", 1001);
		} finally {
			long endTime = System.currentTimeMillis(); // 获取结束时间
			logger.info("还款计划 使用时间：" + (endTime - startTime));
		}

		logger.info("还款计划 :" + map);
		return map;
	}

	
	/**
	 * 
	 * @author 刘栋梁
	 * @date 2017-12-22
	 * @resource 还款计划 列表
	 * @LoggerAnnotation(moduleName = "客户单子相关", option = "还款计划")
	 */
	
	@RequestMapping(value = "/repaymentplan.do")
	@ResponseBody
	public Map<String, Object> RepaymentPlan(HttpServletRequest request) {
		long startTime = System.currentTimeMillis(); // 获取开始时间
		String applyId = request.getParameter("applyId");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<SysRepaymentPlan> list = sysRepaymentPlanServerI.findPlanByApplyId(applyId);	
			map.put("data", list);
			map.put("errorInfo", "数据查询成功！！！");
			map.put("errorCode", 0);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorInfo", "数据查询失败！");
			map.put("errorCode", 1001);
		} finally {
			long endTime = System.currentTimeMillis(); // 获取结束时间
			logger.info("还款计划 使用时间：" + (endTime - startTime));
		}

		logger.info("还款计划 :" + map);
		return map;
	}

}
