package com.io;

import java.util.Scanner;

import com.pojo.Product;

public class ProductIOImpl implements ProductIO {

	Scanner kb = new Scanner(System.in);

	@Override
	public Product getProduct() {

		System.out.println("Enter id");
		int id = kb.nextInt();
		kb.nextLine();
		System.out.println("Enter Product Name");
		String name = kb.nextLine();
		System.out.println("Enter Price");
		double price = kb.nextDouble();
		System.out.println("Enter Quantity");
		int quantity = kb.nextInt();
		kb.nextLine();
		System.out.println("Enter Category");
		String category = kb.nextLine();

		Product product = new Product(id, name, price, quantity, category);

		return product;
	}

	@Override
	public void displayProduct(Product product) {

		System.out.println(product.getpId()+ "               " + product.getpName() + "               " + product.getPrice()+ "               " + product.getQuantity() + "               " + product.getCategory());

	}

}
