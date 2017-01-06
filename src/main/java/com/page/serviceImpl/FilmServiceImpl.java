package com.page.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.page.dao.FilmMapper;
import com.page.pojo.Customer;
import com.page.pojo.FilmSupper;
import com.page.service.FilmService;

@Component
public class FilmServiceImpl implements FilmService{

	@Resource
	private FilmMapper filmMapper;
	
	public List<FilmSupper> selectCusList() {
		// TODO Auto-generated method stub
		return filmMapper.selectCusList();
	}

	@Override
	public int deleteFilm(int id) {
		// TODO Auto-generated method stub
		return filmMapper.deleteFilm(id);
	}

	@Override
	public int updateFilm(FilmSupper filmSupper) {
		// TODO Auto-generated method stub
		return filmMapper.updateFilm(filmSupper);
	}

	@Override
	public Customer selectFist_Name(String username) {
		// TODO Auto-generated method stub
		return filmMapper.selectFist_Name(username);
	}

	@Override
	public int addFilm(FilmSupper filmSupper) {
		// TODO Auto-generated method stub
		return filmMapper.addFilm(filmSupper);
	}

	@Override
	public List<FilmSupper> selectFilmData(int filmId) {
		// TODO Auto-generated method stub
		return filmMapper.selectFilmData(filmId);
	}


	
	
}
