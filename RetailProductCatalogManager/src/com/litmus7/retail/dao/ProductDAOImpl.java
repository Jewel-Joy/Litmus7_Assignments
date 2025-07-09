package com.litmus7.retail.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.dto.Response;
import com.litmus7.retail.util.DBUtil;

public class ProductDAOImpl {

	
	private static int SUCCESS_CODE = 200;
	private static int ERR_CODE = 400;

	public Response addProduct(Product product) {
		Response response = new Response();
		try {
			
			DBUtil dbconnection = new DBUtil();
			Connection connection = dbconnection.connect();
			PreparedStatement statement = connection.prepareStatement(
					"Insert into products(productId,name,category,price,stockQuantity) values (?,?,?,?,?)");
			statement.setInt(1, product.getId());
			statement.setString(2, product.getName());
			statement.setString(3, product.getCategory());
			statement.setDouble(4, product.getPrice());
			statement.setInt(5, product.getStockQuantity());
			int result = statement.executeUpdate();
			if (result == 1) {
				response.setStatusCode(SUCCESS_CODE);
				response.setResponseMessage("Product added succesfully");
			}

			else {
				response.setStatusCode(ERR_CODE);
				response.setErrorMessage("Insertion failed");
			}
		} catch (FileNotFoundException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("File not found" + e.getMessage());
		} catch (IOException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("Unable to load file" + e.getMessage());
		} catch (SQLException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("Wrong syntax" + e.getMessage());
		}
		return response;

	}

	public Response<Product> getProductById(int productId) {
		Response<Product> response = new Response<>();
		boolean flag=false;
		try {
			DBUtil dbconnection = new DBUtil();
			Connection connection = dbconnection.connect();
			PreparedStatement statement=connection.prepareStatement("select * from products where productId=?");
			statement.setInt(1, productId);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()) {
				if(resultset.getString("name")!=null) {
					response.setData(new Product(resultset.getInt("productId"),resultset.getString("name"),resultset.getString("category"),resultset.getDouble("price"),resultset.getInt("stockQuantity")));
					response.setResponseMessage("Product retrived from ID");
					response.setStatusCode(SUCCESS_CODE);
					flag=true;
				}
			}
			if(!flag) {
				response.setStatusCode(ERR_CODE);
				response.setErrorMessage("Product with Id"+productId+" not found");
			}
			
			
		} catch (FileNotFoundException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("File not found" + e.getMessage());
		} catch (IOException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("Unable to load file" + e.getMessage());
		} catch (SQLException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("Sql synatx is wrong");
		}
		return response;
			
		

	}

	public Response<List<Product>> getAllProduct() {
		Response<List<Product>> response = new Response<>();
		List<Product> products=new ArrayList<>();
		try {
			DBUtil dbconnection = new DBUtil();
			Connection connection = dbconnection.connect();
			PreparedStatement statement=connection.prepareStatement("select * from products");
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()) {
				if(resultset.getString("name")!=null)
				products.add(new Product(resultset.getInt("productId"),resultset.getString("name"),resultset.getString("category"),resultset.getDouble("price"),resultset.getInt("stockQuantity")));
			}
			if(!products.isEmpty()) {
				response.setData(products);
				response.setStatusCode(SUCCESS_CODE);
				response.setResponseMessage("Successfully retrived from database");
			}else {
				response.setStatusCode(ERR_CODE);
				response.setErrorMessage("Database is empty");
			}
			
		} catch (FileNotFoundException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("File not found" + e.getMessage());
		} catch (IOException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("Unable to load file" + e.getMessage());
		} catch (SQLException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("No product found" + e.getMessage());
		}
		return response;
			
		

		
		
	}

	public Response updateProduct(Product product) {
		Response response=new Response();
		try {
			DBUtil dbconnection = new DBUtil();
			Connection connection = dbconnection.connect();
			PreparedStatement statement=connection.prepareStatement("Update products set name=?,category=?,price=?,stockQuantity=? where productId=?");
			statement.setString(1,product.getName());
			statement.setString(2,product.getCategory());
			statement.setDouble(3,product.getPrice());
			statement.setInt(4,product.getStockQuantity());
			statement.setInt(5,product.getId());
			int result=statement.executeUpdate();
			if(result==1) {
				response.setStatusCode(SUCCESS_CODE);
				response.setResponseMessage("Product updated succesfully");
			}
			else {
				response.setStatusCode(ERR_CODE);
				response.setErrorMessage("Product with ID"+product.getId()+"is not found");
			}
				
			
		}catch (FileNotFoundException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("File not found" + e.getMessage());
		} catch (IOException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("Unable to load file" + e.getMessage());
		} catch (SQLException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("No product found" + e.getMessage());
		}
		return response;
		
		
		
	}

	public Response deleteProduct(int productId) {
		Response response=new Response();
		try {
			DBUtil dbconnection = new DBUtil();
			Connection connection = dbconnection.connect();
			PreparedStatement statement=connection.prepareStatement("Delete from products where productId=?");
			statement.setInt(1,productId);
			int result=statement.executeUpdate();
			if(result==1) {
				response.setStatusCode(SUCCESS_CODE);
				response.setResponseMessage("Product deleted succesfully");
			}
			else {
				response.setStatusCode(ERR_CODE);
				response.setErrorMessage("Product with ID"+productId+"is not found");
			}
				
			
		}catch (FileNotFoundException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("File not found" + e.getMessage());
		} catch (IOException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("Unable to load file" + e.getMessage());
		} catch (SQLException e) {
			response.setStatusCode(ERR_CODE);
			response.setErrorMessage("No product found" + e.getMessage());
		}
		return response;
	}

}
