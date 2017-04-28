package com.insonix.scrapping.service;

import java.util.Scanner;

import com.insonix.scrapping.business.UrlSelector;

public class Scrapper {
	
	public static void main(String[] args) {
		System.out.println("This Scrapper is for Amazon only");
		System.out.println("Please enter product url::");
		Scanner scanner = new Scanner(System.in);
		String url = scanner.nextLine();
		UrlSelector selector = new UrlSelector(url);
		System.out.println("Please check the following detail");
		System.out.println("Title:::"+selector.getProductTitle());
		System.out.println("Image Url:::"+selector.getProductImageUrl());
		System.out.println("Product Price:::"+selector.getProductPrice());
		System.out.println("Product description:::"+selector.getProductDescription());
		scanner.close();
		
	}
}
