package com.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mapper.DemoMapper;
import com.utils.MyLogger;
import com.utils.SqlSessionFactoryUtil;

public class DemoService {
	
	public List<Map<String,Object>> getDevUnitMap(){
		SqlSession session = null;
		List<Map<String,Object>> list = null;
		try{
			session = SqlSessionFactoryUtil.getSession();
			DemoMapper mapper = session.getMapper(DemoMapper.class);
			list = mapper.getLastItems(10);
		}catch (Exception e) {
			MyLogger.logger.warn(e);
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return list;
	}
	
	public int addItem() {
		SqlSession session = null;
		int res = 0;
		try{
			session = SqlSessionFactoryUtil.getSession();
			DemoMapper mapper = session.getMapper(DemoMapper.class);
			res = mapper.addItem(LocalDateTime.now().toString());
			session.commit();
		}catch (Exception e) {
			MyLogger.logger.warn(e);
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return res;
	}
	
}
