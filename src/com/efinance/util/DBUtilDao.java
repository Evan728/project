package com.efinance.util;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

import com.efinance.util.impl.page.ResultType;



public interface DBUtilDao {
	
	public void save(Object o);
	
	public void update(Object o);
	
	public  void delete(Object o);
	
	public  void delete(Object[] os);
	
	public <T> T get(Class<T> o,Integer oId);
	
	//maxResult每次查找最大条数
	//LinkedHashMap排序的根据，第一个String(KEY)表示根据什么排序,第二个String表示升序还是降序
	public <T>  ResultType<T> fenye(Class<T> entityClass);
	
	public <T>  ResultType<T> fenye(Class<T> entityClass,int firstIndex,int maxResult);
	
	public <T>  ResultType<T> fenye(Class<T> entityClass,int firstIndex,int maxResult,
			LinkedHashMap<String,String> orderBy);
	
	public <T>  ResultType<T> fenye(Class<T> entityClass,int firstIndex,int maxResult,
			String wherespql,Object[] queryParams);
	
	public <T>  ResultType<T> fenye(Class<T> entityClass,int firstIndex,int maxResult,
			String wherespql,Object[] queryParams,LinkedHashMap<String,String> orderBy);
	
}
