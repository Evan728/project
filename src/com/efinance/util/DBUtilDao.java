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
	
	//maxResultÿ�β����������
	//LinkedHashMap����ĸ��ݣ���һ��String(KEY)��ʾ����ʲô����,�ڶ���String��ʾ�����ǽ���
	public <T>  ResultType<T> fenye(Class<T> entityClass);
	
	public <T>  ResultType<T> fenye(Class<T> entityClass,int firstIndex,int maxResult);
	
	public <T>  ResultType<T> fenye(Class<T> entityClass,int firstIndex,int maxResult,
			LinkedHashMap<String,String> orderBy);
	
	public <T>  ResultType<T> fenye(Class<T> entityClass,int firstIndex,int maxResult,
			String wherespql,Object[] queryParams);
	
	public <T>  ResultType<T> fenye(Class<T> entityClass,int firstIndex,int maxResult,
			String wherespql,Object[] queryParams,LinkedHashMap<String,String> orderBy);
	
}
