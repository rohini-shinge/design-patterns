package com.prototype.impl;

import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;

class PurchaseOrder implements Serializable {

	String poNumber;

	public PurchaseOrder(String poNumber) {
		super();
		this.poNumber = poNumber;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [poNumber=" + poNumber + "]";
	}
}

public class CopySerializationDemo {

	public static void main(String[] args) {
		PurchaseOrder purchaseOrder = new PurchaseOrder("ZSN-123");
		PurchaseOrder order = SerializationUtils.roundtrip(purchaseOrder);
		order.poNumber = "ZSN-567";
		System.out.println(purchaseOrder);
		System.out.println(order);
	}

}
