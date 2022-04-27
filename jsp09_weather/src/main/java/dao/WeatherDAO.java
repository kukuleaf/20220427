package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Weather;

public class WeatherDAO {
	public void insert(Map<String, String> weather) {
		SqlSession session =  MBConn.getSession();
		try {
			session.insert("WeatherMapper.insert", weather);
		}catch(Exception e){
			
		}
		
	}
	
	public List<Weather> selectList(Map<String,String> map){
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("WeatherMapper.selectList", map);
		}
	}
	
	public List<Weather> List(String stnId){
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("WeatherMapper.List",stnId);
		}
	}
	
	public List<Weather> all(){
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("WeatherMapper.all");
		}
	}
}
