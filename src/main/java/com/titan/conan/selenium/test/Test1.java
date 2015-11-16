package com.titan.conan.selenium.test;

import java.io.File;
import java.net.URISyntaxException;

public class Test1 {
	public static void main(String[] args) throws URISyntaxException {
		System.out.println( System.getProperty("java.class.path"));
		String currentPath = Test1.class.getResource("").toURI().getPath();
		System.out.println(currentPath);
		String LoadClassPath = Test1.class.getClassLoader().getResource("").toURI().getPath();
        System.out.println("LoadClassPath   :" + LoadClassPath);
        File f = new File("src/main/resources/chromedriver.exe");
        System.out.println(f.getPath());
        
	}
}
