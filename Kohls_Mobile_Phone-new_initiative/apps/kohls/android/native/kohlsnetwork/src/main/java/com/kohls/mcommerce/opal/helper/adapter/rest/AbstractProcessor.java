package com.kohls.mcommerce.opal.helper.adapter.rest;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.http.message.BasicHeader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kohls.mcommerce.opal.common.app.KohlsPhoneApplication;
import com.worklight.wlclient.api.WLResourceRequest;

/**
 * @author neeraj.kumar@kohls.com
 *
 */
abstract class AbstractProcessor {



	protected WLResourceRequest createWLResourceRequest(String stringUrl, String method){

		URI url;
		try {
			url = new URI(stringUrl);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}

		WLResourceRequest req = new WLResourceRequest(url, method);

		req.setHeader(new BasicHeader("Accept", "application/json"));

        req.setTimeout(Integer.parseInt(KohlsPhoneApplication.getInstance()
                 .getConfigurationUtils()
                 .getConfig()
                 .getNetworktimeout()));
        
		return req;
	}

	

	protected HashMap<String, String> jsonToMap(String reqJson) {
		JsonParser p = new JsonParser();
        JsonElement parsedReq = p.parse(reqJson);
        JsonObject reqJSON = parsedReq.getAsJsonObject();
		Iterator<Entry<String, JsonElement>> iter = reqJSON.entrySet().iterator();
		HashMap<String, String> map = new HashMap<>();
		while (iter.hasNext()){
			Entry<String, JsonElement> ent = iter.next();
			map.put(ent.getKey(), ent.getValue().getAsString());
		}
		return map;
	}

	/**
	 * This is to set query parameters, be used for String type members.
	 * @param wlReq
	 * @param po
	 */
	protected void setQueryParamaters(WLResourceRequest wlReq, Object po){
		if(po != null){
			for (Field f : po.getClass().getDeclaredFields()) {	    
			    try {
			    	f.setAccessible(true);
			    	if (String.class.isAssignableFrom(f.getType())) {
						String value = (String)f.get(po);
						if (null != value) {
							String name = f.getName();
							wlReq.setQueryParameter(name, value);
						}
					}

				} catch (IllegalAccessException | IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
		}

	}


	/**
	 * Returns queryString of pojo class.
	 * @param po
	 * @return
	 */
	protected String getQueryStrings(Object po){

		String queryString = null;

		if (po != null) {
			int length = po.getClass().getDeclaredFields().length;
			for (Field f : po.getClass().getDeclaredFields()) {	    
			    try {
			    	f.setAccessible(true);
			    	if (String.class.isAssignableFrom(f.getType())) {
						String value = (String)f.get(po);
						if (null != value) {
							String name = f.getName();
							  try {
								  queryString += URLEncoder.encode(name, "UTF-8");
								  queryString += "=";
								  queryString += URLEncoder.encode(value, "UTF-8");
								  length--;
								  if (length != 0) {
									  queryString += "&";
								  }
							    } catch (UnsupportedEncodingException ex) {
							      throw new RuntimeException("UTF-8 is not supported");
							 }
						}
					}

				} catch (IllegalAccessException | IllegalArgumentException e) {
					e.printStackTrace();
				}
			}	

		}

		return queryString;
	}

	/**
	 * Converts pojo object to Map.
	 * @param pojo
	 * @return
	 */
	protected HashMap<String, String> pojoToMap(Object pojo){
		HashMap<String, String> map = new HashMap<String, String>();
		for (Field f : pojo.getClass().getDeclaredFields()) {	    
		    try {
		    	f.setAccessible(true);
		    	if (String.class.isAssignableFrom(f.getType())) {
					String value = (String)f.get(pojo);
					if (null != value) {
						String name = f.getName();
						map.put(name, value);
					}
				}

			} catch (IllegalAccessException | IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return map;	
	}



}