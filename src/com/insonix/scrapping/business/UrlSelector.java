package com.insonix.scrapping.business;

import com.insonix.scrapping.business.AmazonDocBuilder;
import com.insonix.scrapping.business.DocumentBuilder;
import com.insonix.scrapping.business.ProductDetail;

public class UrlSelector {
	private String url = null;
	private DocumentBuilder docBuilder = null;
	private ProductDetail productDetail = null;
	
	public UrlSelector(String url) {
		// TODO Auto-generated constructor stub
		if(url == null) {
			throw new IllegalArgumentException("Url can not be null");
		}
		this.url = url;
		this.docBuilder = new AmazonDocBuilder(url);
		this.productDetail = new ProductDetail.ProdBuilder().title(docBuilder.getTitle())
				.price(docBuilder.getPrice()).description(docBuilder.getDescription())
				.imageUrl(docBuilder.getImageUrl()).build();
	}

	public DocumentBuilder getDocBuilder() {
		return docBuilder;
	}
	public ProductDetail getProductDetail() {
		return productDetail;
	}
	public String getProductImageUrl() {
		return productDetail.getImageUrl();
	}
	public String getProductPrice() {
		return productDetail.getPrice();
	}
	public String getProductTitle() {
		return productDetail.getTitle();
	}
	public String getProductDescription() {
		return productDetail.getDescription();
	}
	public String getUrl() {
		return this.url;
	}
}
