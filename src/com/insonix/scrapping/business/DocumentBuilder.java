package com.insonix.scrapping.business;

public interface DocumentBuilder {
	public String getImageUrl();
	public String getDescription();
	public String getTitle();
	public String getPrice();
	public void buildDocument() ;
}
