package service;


import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dao.WeatherDAO;
import dto.Weather;

public class WeatherService {
	private WeatherDAO wDAO = new WeatherDAO();
	
    public void weatherlist(String location) {
    	try {
    		
    		String servicekey = "pE7DnZF8gkLfw8SzJY8g8W%2BiXnIpvnCLwCOpYH%2FuHqU6khdabBhMkXTkPkPGnnx6rLeeyut1NaYdULXoeKtxbQ%3D%3D";
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstMsgService/getWthrSituation"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + servicekey); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
            urlBuilder.append("&" + URLEncoder.encode("stnId","UTF-8") + "=" + URLEncoder.encode(location, "UTF-8")); /*108 기상청, 109 수도권(서울)..등 별첨 엑셀자료 참조(‘개황’ 구분 값 참고)*/
            
            
            
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString());
            NodeList nlist = doc.getElementsByTagName("item");
        	NodeList clist =  nlist.item(0).getChildNodes(); 
        	
        	Map<String, String> wmap = new HashMap<>();
        	for(int j=0; j<clist.getLength(); j++) {
        		Node node = clist.item(j);
        		wmap.put(node.getNodeName(),node.getTextContent() );
        	}
        	System.out.println(wmap);
        	wDAO.insert(wmap);
            
            
		} catch (Exception e) {
			
		}
    	
    }
	public List<Weather> selectList(String stnId, String tmFc) {
		Map<String, String> map = new HashMap<>();
		map.put("tmFc",tmFc);
		map.put("stnId",stnId);		
		
		return wDAO.selectList(map);	

	}
	
	public List<Weather> List(String stnId){
		return wDAO.List(stnId);
	}
	public List<Weather> all(){
		return wDAO.all();
	}

}
