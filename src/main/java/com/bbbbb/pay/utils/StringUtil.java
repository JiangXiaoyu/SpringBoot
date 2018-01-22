package com.bbbbb.pay.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringUtil {
	
	/**
     * 将Map<String,Object>转换成Map<String,String>
     * @param res   
     * @return
     */
    public static Map<String, String> parse(Map<String, Object> res){
    	Map<String,String> newMap =new HashMap<String,String>();
    	for (Map.Entry<String, Object> entry : res.entrySet()) {
    	   if(entry.getValue() instanceof String){
    		   newMap.put(entry.getKey(), (String) entry.getValue());
    	   }
    	 }
    	return newMap;    	
    }
    
    /**
     * 将Object转换成List<Map<String, String>
     * @param res
     * @return
     */
    @SuppressWarnings("unchecked")
	public static List<Map<String, String>> parseToList(Object res){
    	List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    	if(res instanceof List) {
    		for(Object obj : (List<Object>)res) {
    			if(obj instanceof Map) {				
    					list.add(parse((Map<String, Object>) obj));   				
    			}
    		}
    	}
    	
    	return list;
    }

}
