package com.page.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.VoiceStatus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.page.pojo.EasyUIResult;
import com.page.pojo.FilmSupper;
import com.page.service.FilmService;

@Controller
public class FilmController {
	
	@Resource
	private FilmService filmService;
	
	//方法一
	@RequestMapping(value="/filmpage.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getFilmLists(HttpServletRequest request) throws IOException{
		
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		String searchFilmId = request.getParameter("searchFilmId");
		if (searchFilmId!=null) {
			int FilmId = Integer.parseInt(searchFilmId);
			PageHelper.startPage(page,rows);
			List<FilmSupper> filmLists = filmService.selectFilmData(FilmId);
			PageInfo<FilmSupper> pages = new PageInfo<FilmSupper>(filmLists);
			int count=(int) pages.getTotal();
		    Map<String,Object> maps = new HashMap<String, Object>();
			maps.put("total",count);
			maps.put("rows", filmLists);
			return maps;
		}else {
			//处理分页数据
			PageHelper.startPage(page,rows);
			List<FilmSupper> lists = filmService.selectCusList();
			PageInfo<FilmSupper> pages = new PageInfo<FilmSupper>(lists);
			int count=(int) pages.getTotal();
		    Map<String,Object> maps = new HashMap<String, Object>();
			maps.put("total",count);
			maps.put("rows", lists);
			//Gson gson = new Gson();
			//String gsonString = gson.toJson(maps);
			//提供json<=>Map
				//	System.out.println(gsonString);
			return maps;
		}
	}
	
	//方法二
	/*@RequestMapping(value="/filmpage.action",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIResult getFilmLists(int page, int  rows) throws IOException{
		
		EasyUIResult easyUIResult = new EasyUIResult();
		//处理分页数据
		PageHelper.startPage(page,rows);
		List<FilmSupper> lists = filmService.selectCusList();
		easyUIResult.setRows(lists);
		PageInfo<FilmSupper> pages = new PageInfo<FilmSupper>(lists);
		int count=(int) pages.getTotal();
		easyUIResult.setTotal(count);
		return easyUIResult;
	}  */
	
	@RequestMapping(value="/delete.action",method=RequestMethod.POST)
	public void deleteFilm(HttpServletRequest request,HttpServletResponse response){
		String filmId = request.getParameter("film_id");
		int fid = Integer.parseInt(filmId);
		PrintWriter printWriter = null;
		int count = 0;
		    try {
		      count = filmService.deleteFilm(fid);
		      printWriter = response.getWriter();
		      printWriter.print(count);
		      printWriter.flush();
		      printWriter.close();
		    } catch (Exception e) {
		    	count = -1;
		    } 
		  }
	
	@RequestMapping(value="/updateFilm.action")
	public void updateFilm(FilmSupper filmSupper,HttpServletResponse response){
		 PrintWriter printWriter = null;
		 int count = 0;
		    try {
		      count = filmService.updateFilm(filmSupper);
		      printWriter = response.getWriter();
		      printWriter.print(count);
		      printWriter.flush();
		      printWriter.close();
		    } catch (Exception ex) {
		    	ex.printStackTrace();
		    } 
	}
	
	@RequestMapping("/addFilm.action")
	public void addFilm(FilmSupper filmSupper,HttpServletResponse response){
		PrintWriter printWriter = null;
		 int count = 0;
		    try {
		    	count = filmService.addFilm(filmSupper);
		      printWriter = response.getWriter();
		      printWriter.print(count);
		      printWriter.flush();
		        printWriter.close();
		    } catch (Exception ex) {
		    	ex.printStackTrace();
		    } 
	}
	
	

}
