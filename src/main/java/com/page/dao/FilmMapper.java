package com.page.dao;

import java.util.List;
import java.util.Map;

import com.page.pojo.Customer;
import com.page.pojo.Film;
import com.page.pojo.FilmSupper;

public interface FilmMapper {
	
	//查询用户名
	public Customer selectFist_Name(String username);
	
	//查询所有
	public List<FilmSupper> selectCusList();
	
	//通过film_id查询数据
	public List<FilmSupper> selectFilmData(int film_id);
	
	//添加
	public int addFilm(FilmSupper filmSupper);

	//更新
	public int updateFilm(FilmSupper filmSupper);
	
	//删除
	public int deleteFilm(int  id);

}
