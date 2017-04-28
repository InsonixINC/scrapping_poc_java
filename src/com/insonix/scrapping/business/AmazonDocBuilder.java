package com.insonix.scrapping.business;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

class AmazonDocBuilder implements DocumentBuilder {
	private static final String REFERRER = "http://www.google.com";
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0";
	private Document document ;
	private String url;
	
	public AmazonDocBuilder(String url) {
		// TODO Auto-generated constructor stub
		this.url = url;
		buildDocument();
	}
	
	@Override
	public void buildDocument() {
		// TODO Auto-generated method stub
		try {
			document = Jsoup.connect(url).userAgent(USER_AGENT).referrer(REFERRER).get();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String getImageUrl() {
		// TODO Auto-generated method stub
		if(document != null) {
			List<Element> links = document.select("img");
			for (Element element : links) {
				String idName = element.attr("id");
				if (idName != null && idName.equals("landingImage")) {
					String img = element.attr("data-old-hires");
					if(img == null || img.equals("")) {
						img = element.attr("abs:src");
					}
					if(img != null && !img.equals("")) {
						return img;
					}
				} 
			}
			
			links = document.select("#a-autoid-8-announce img");
			for (Element element : links) {
				String src = element.attr("abs:src");
				if(src != null && src.equals("")) {
					return src;
				}
			}
		}
		
		return null;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		if(document != null) {
			List<Element> description = document.select("#feature-bullets ul"); 
			for(Element element : description) {
				return element.text().trim();			
			}
		}
		return null;
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		if(document != null) {
			List<Element> title = document.select("#productTitle"); 
			for(Element element : title) {
				return (element.text().trim());
			}
		}
		return null;
	}
	@Override
	public String getPrice() {
		// TODO Auto-generated method stub
		if(document != null) {
			List<Element> price = document.select("#priceblock_ourprice"); 
			if(price.size() > 0) {
				for(Element element : price) {
					return element.text().trim();
				}
			}	
			price = document.select("#priceblock_saleprice");
			for(Element element : price) {
				return element.text().trim();
			}
		}
		return null;
	}
	
}
