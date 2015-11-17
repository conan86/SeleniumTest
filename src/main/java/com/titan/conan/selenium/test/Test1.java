package com.titan.conan.selenium.test;

import java.io.File;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;

public class Test1 {
	public static void main(String[] args) throws URISyntaxException {
		System.out.println( System.getProperty("java.class.path"));
		String currentPath = Test1.class.getResource("").toURI().getPath();
		System.out.println(currentPath);
		String LoadClassPath = Test1.class.getClassLoader().getResource("").toURI().getPath();
        System.out.println("LoadClassPath   :" + LoadClassPath);
        File f = new File("src/main/resources/chromedriver.exe");
        System.out.println(f.getPath());
        LinkedHashMap<Integer,String> map = new LinkedHashMap<Integer,String>();
        map.put(2, "2");
        map.put(1, "1");
        map.put(6, "6");
        map.put(3, "3");
        map.put(5, "5");
        map.put(4, "4");
        for(int i : map.keySet()) {
        	System.out.println(map.get(i));
        }
	}
}
