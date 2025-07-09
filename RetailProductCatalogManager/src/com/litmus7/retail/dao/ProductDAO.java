package com.litmus7.retail.dao;

import java.util.List;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.dto.Response;



public class ProductDAO {
	Response response;
	ProductDAOImpl implementation=new ProductDAOImpl();
	public String addProduct(Product product) {
		response=implementation.addProduct(product);
		if(response.getStatusCode()==200)
			return response.getResponseMessage();
		else
			return response.getErrorMessage();
	}
	public Response getProductById(int productId) {
		response=implementation.getProductById(productId);
		return response;
	}
	public Response getAllProduct(){
		return implementation.getAllProduct();
	}
	public String updateProduct(Product product) {
		response=implementation.updateProduct(product);
		if(response.getStatusCode()==200)
			return response.getResponseMessage();
		else
			return response.getErrorMessage();
	}
	public String deleteProduct(int productId) {
		response=implementation.deleteProduct(productId);
		if(response.getStatusCode()==200)
			return response.getResponseMessage();
		else
			return response.getErrorMessage();
	}
	
}
