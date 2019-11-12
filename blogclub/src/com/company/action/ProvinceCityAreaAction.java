package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JEditorPane;

import com.company.service.IAreaService;
import com.company.service.ICityService;
import com.company.service.IProvinceService;
import com.company.service.impl.AreaServiceImpl;
import com.company.service.impl.CityServiceImpl;
import com.company.service.impl.ProvinceServiceImpl;

import net.sf.json.JSONObject;

/**
 * 省市区级联查 type: 1 查省 2 查市 3 查区县
 */
@WebServlet("/pca.action")
public class ProvinceCityAreaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProvinceCityAreaAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		IProvinceService provinceService = new ProvinceServiceImpl();
		ICityService cityService = new CityServiceImpl();
		IAreaService areaService = new AreaServiceImpl();
		// 创建接收数据查询结果集合
		List list = null;
		// 接收type类型
		String type = request.getParameter("type");
		// 判断type类型
		if (type.equals("1")) {
			list = provinceService.findAll();
		} else if (type.equals("2")) {
			String provinceId = request.getParameter("provinceId");
			list = cityService.findCitiesByPid(provinceId);
		} else {
			String cityId = request.getParameter("cityId");
			list = areaService.findAreasByCid(cityId);
		}
		// 创建JSON对象
		JSONObject json = new JSONObject();
		// 将结果集放入JSON中
		json.put("list", list);
		// 将JSON放入写出流
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
