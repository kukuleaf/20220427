package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Weather;
import service.WeatherService;

import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/weather/*")
public class WetherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WeatherService ws = new WeatherService();
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date nowDate = new Date();
		SimpleDateFormat hour = new SimpleDateFormat("HH");
		SimpleDateFormat sDate = new SimpleDateFormat("yyyyMMdd");
		String nowtime = hour.format(nowDate);
		int nt = Integer.parseInt(nowtime);
		String tmFc;
		if(nt>5&&nt<11) {
			tmFc = "0500";
		}else if(nt>11&&nt<17) {
			tmFc = "1100";
		}else {
			tmFc = "1700";
		}
		tmFc = sDate.format(nowDate)+tmFc;
		
		List<Weather> wlist;
		List<Weather> wInfo;
		String stnId;
		String uri = request.getRequestURI();
		
		if(uri.contains("view")) {
			stnId = request.getParameter("stnId");
			
			ws.weatherlist(stnId);
			
			wInfo = ws.selectList(stnId,tmFc);
			
			request.setAttribute("wInfo", wInfo);
			request.getRequestDispatcher("/view/weather.jsp")
				.forward(request, response);
		}else if(uri.contains("search")) {
			stnId = request.getParameter("stnId");
			if(stnId.equals("all")) {
				wlist = ws.all();
			}else {
				wlist = ws.List(stnId);
			}
			request.setAttribute("wlist", wlist);
			request.getRequestDispatcher("/view/past.jsp").forward(request, response);
		}else if(uri.contains("detail")) {
			stnId = request.getParameter("stnId");
			tmFc = request.getParameter("tmFc");
			
			wInfo = ws.selectList(stnId,tmFc);
			
			request.setAttribute("wInfo", wInfo);
			request.getRequestDispatcher("/view/detail.jsp")
				.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
