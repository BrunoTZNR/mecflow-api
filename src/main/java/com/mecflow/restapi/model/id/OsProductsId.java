package com.mecflow.restapi.model.id;

import java.util.Objects;

public class OsProductsId {
	private Long os;
	private Long product;
	
	public OsProductsId() {
	}
	
	public OsProductsId(Long os, Long product) {
		this.os = os;
		this.product = product;
	}

	public Long getOs() {
		return os;
	}

	public void setOs(Long os) {
		this.os = os;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(os, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OsProductsId other = (OsProductsId) obj;
		return Objects.equals(os, other.os) && Objects.equals(product, other.product);
	}

	@Override
	public String toString() {
		return "OsProductsId [os=" + os + ", product=" + product + "]";
	}
}
