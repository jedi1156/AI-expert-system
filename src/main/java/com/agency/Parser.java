package com.agency;

import java.util.ArrayList;
import java.util.HashMap;

import org.yaml.snakeyaml.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class Parser {
	
	public static ArrayList<Place> parsePlaces(String filename) {
		ArrayList<Place> result = new ArrayList<Place>();
		Yaml yaml = new Yaml();
    	InputStream input;
    	Map<Object, Object> data;
		try {
			input = new FileInputStream(new File(filename));
	        data = (Map<Object, Object>) yaml.load(input);
	        
	        for (Map.Entry<Object, Object> entry : data.entrySet()) {
	        	Map<String, Object> place_map = (Map<String, Object>) entry.getValue();
	            result.add(new Place((String)(place_map).get("name")));
	            
	            System.out.println((Boolean)place_map.get("sea"));
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public static Map<String, String> parseMessages(String filename) {
		Yaml yaml = new Yaml();
    	InputStream input;
    	Map<String, String> data = new HashMap<String, String>();
		try {
			input = new FileInputStream(new File(filename));
	        data = (Map<String, String>) yaml.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        return data;
	}
}
