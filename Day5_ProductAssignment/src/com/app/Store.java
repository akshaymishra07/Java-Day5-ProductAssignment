package com.app;

import java.util.List;
import java.util.Scanner;

import com.dao.ProductDAOImpl;
import com.exceptions.ProductNotFoundException;
import com.io.ProductIOImpl;
import com.pojo.Product;

public class Store {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		ProductIOImpl pio = new ProductIOImpl();
		ProductDAOImpl pdao = new ProductDAOImpl();

		char ch;

		do {
			try {
				System.out.println(
						"----Menu-----\n1.Add Product\n2.Update Product's Price\n3.Update Product's Quantity\n4.Find Product\n5.Show All the products\n6.Show Products Category wise");
				System.out.println("Enter Your choice");
				int choice = kb.nextInt();

				switch (choice) {
				case 1:
					Product product = pio.getProduct();
					pdao.addProduct(product);
					pio.displayProduct(product);
					break;

				case 2:
					System.out.println("Enter the product id to update..");
					int id = kb.nextInt();
					System.out.println("Enter Updated Price");
					double price = kb.nextDouble();
					boolean res = pdao.updateProduct(id, price);

					if (res == false) {
						throw new ProductNotFoundException("Product not available in the store");
					}else 
						System.out.println("Product  "+id+"  Updated Sucessfully......");
					break;
				case 3:
					System.out.println("Enter the product id to update..");
					int id1 = kb.nextInt();
					System.out.println("Enter Updated quantity");
					int quantity = kb.nextInt();
					boolean res1 = pdao.updateProduct(id1, quantity);

					if (res1 == false) {
						throw new ProductNotFoundException("Product not available in the store");
					}else 
						System.out.println("Product  "+id1+"  Updated Sucessfully......");
					break;
				case 4:
					System.out.println("Enter the product id to find..");
					int id2 = kb.nextInt();

					Product product1 = pdao.findById(id2);

					if (product1 == null) {
						throw new ProductNotFoundException("Product not available in the store");
					} else {
						pio.displayProduct(product1);
					}
					break;
				case 5:
					List<Product> products = pdao.findAll();
                    System.out.println("***************PRODUCTS******************");
                    System.out.println("Id               Name               Price               Quantity               Category");
					if (products.size() == 0) {
						System.out.println("No Product in the Store.....");
					} else {
						products.forEach((p) -> {
							pio.displayProduct(p);
						});
					}
					break;
				case 6:
					System.out.println("Enter Category of Products");
					kb.nextLine();
					String cat = kb.nextLine();
					List<Product> products1 = pdao.findAllByCategory(cat);
					if (products1.size() == 0) {
						System.out.println("No Product for this category in the Store.....");
					} else {
						products1.forEach((p) -> {
							pio.displayProduct(p);
						});
					}
					break;

				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			System.out.println("Do You want to continue ...(Y/N)?");
			ch = kb.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');

	}

}
