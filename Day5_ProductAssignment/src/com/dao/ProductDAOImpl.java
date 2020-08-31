package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Product;

public class ProductDAOImpl implements ProductDAO {

	private Connection connection = getDbConnection();

	private Connection getDbConnection() {

		Connection connection = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

	@Override
	public int addProduct(Product product) {

		String addProduct = "insert into product values( ? , ? , ? , ? , ?)";
		int rows = 0;

		try {
			PreparedStatement ps = connection.prepareStatement(addProduct);

			ps.setInt(1, product.getpId());
			ps.setString(2, product.getpName());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getQuantity());
			ps.setString(5, product.getCategory());

			rows = ps.executeUpdate();

			if (rows > 0) {

				System.out.println("Product added successfully.....");
			} else {
				System.out.println("Can't add at this time...Try again.....");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public boolean updateProduct(int productId, double price) {

		Product product = findById(productId);
		int rows = 0;

		if (product == null) {
			return false;
		}

		String updatePrice = "update product set price = ? where pid = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(updatePrice);

			ps.setDouble(1, price);
			ps.setInt(2, productId);
			rows = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rows == 0) {
			return false;
		} else
			return true;

	}

	@Override
	public boolean updateProduct(int productId, int quantity) {
		Product product = findById(productId);
		int rows = 0;

		if (product == null) {
			return false;
		}

		String updateQuantity = "update product set quantity = ? where pid = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(updateQuantity);

			ps.setDouble(1, quantity);
			ps.setInt(2, productId);
			rows = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rows == 0) {
			return false;
		} else
			return true;

	}

	@Override
	public Product findById(int productId) {

		String findProductById = "Select * from product where pid = ? ";
		ResultSet resultSet = null;
		Product product = null;

		try {
			PreparedStatement ps = connection.prepareStatement(findProductById);

			ps.setInt(1, productId);

			resultSet = ps.executeQuery();

			while (resultSet.next()) {

				product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),
						resultSet.getInt(4), resultSet.getString(5));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public List<Product> findAll() {

		String findAll = "Select * from product";
		List<Product> products = new ArrayList<>();
		Product product = null;

		try {

			PreparedStatement ps = connection.prepareStatement(findAll);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				product = new Product(resultSet.getInt(1) , resultSet.getString(2) , resultSet.getDouble(3) , resultSet.getInt(4) , resultSet.getString(5) );
				products.add(product);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return products;
	}

	@Override
	public List<Product> findAllByCategory(String category) {
		String findAllByCategory = "Select * from product where category = ?";
		List<Product> products = new ArrayList<>();
		Product product = null;

		try {

			PreparedStatement ps = connection.prepareStatement(findAllByCategory);
			ps.setString(1, category);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				product = new Product(resultSet.getInt(1) , resultSet.getString(2) , resultSet.getDouble(3) , resultSet.getInt(4) , resultSet.getString(5) );
				products.add(product);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return products;
	}

}
