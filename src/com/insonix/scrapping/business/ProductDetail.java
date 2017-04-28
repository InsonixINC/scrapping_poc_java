package com.insonix.scrapping.business;

class ProductDetail {
	private final String imageUrl;
	private final String price;
	private final String title;
	private final String description;

	public ProductDetail(ProdBuilder builder) {
		// TODO Auto-generated constructor stub
		this.imageUrl = builder.imageUrl;
		this.price = builder.price;
		this.title = builder.title;
		this.description = builder.description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return "Product Detail[Title:"+title+",price:"+price+"]";
	}
	static class ProdBuilder {
		private String imageUrl;
		private String price;
		private String title;
		private String description;

		public ProdBuilder imageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
			return this;
		}

		public ProdBuilder price(String price) {
			this.price = price;
			return this;
		}

		public ProdBuilder title(String title) {
			this.title = title;
			return this;
		}

		public ProdBuilder description(String description) {
			this.description = description;
			return this;
		}

		public ProductDetail build() {
			return new ProductDetail(this);
		}

	}

}
