package com.page.service;

import java.util.List;

import com.page.pojo.Customer;
import com.page.pojo.FilmSupper;

public interface FilmService {
	 
	public List<FilmSupper> selectCusList();
	
	public int deleteFilm(int id);
	
	public int updateFilm(FilmSupper filmSupper);
	
	public Customer selectFist_Name(String username);
	
	public int addFilm(FilmSupper filmSupper);
	
	public List<FilmSupper> selectFilmData(int filmId);
}
