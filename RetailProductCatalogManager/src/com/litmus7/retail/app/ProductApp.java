package com.litmus7.retail.app;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import com.litmus7.retail.dao.ProductDAO;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.dto.Response;

public class ProductApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		ProductDAO product=new ProductDAO();
		boolean flag=true;
		
		while(flag) {
			System.out.println("---MENU---\n 1 : Add Product \n 2 : View Product by Id \n 3 : View all product\n 4 : Update Product \n 5 : Delete Product \n 6 : Exit ");
			System.out.println("Enter the choice");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Product Id");
				int productId=scanner.nextInt();
				System.out.println("Enter Product Name");
				String productName=scanner.next();
				System.out.println("Enter the category");
				String category=scanner.next();
				System.out.println("Enter the price");
				double price=scanner.nextDouble();
				System.out.println("Enter the stock quantity");
				int stockQuantity=scanner.nextInt();
				Product newProduct=new Product(productId,productName,category,price,stockQuantity);
				System.out.println(product.addProduct(newProduct));
				break;
			case 2:
				System.out.println("Enter the productId");
				productId=scanner.nextInt();
				Response<Product> response=product.getProductById(productId);
				if(response.getStatusCode()==200) {
					newProduct=response.getData();
					System.out.println(newProduct.displayDetails());
				}else {
					System.out.println(response.getErrorMessage());
				}
				break;
			case 3:
				System.out.println("All products in catalog");
				List<Product> products=new ArrayList<>();
				Response<List<Product>> allProducts=product.getAllProduct();
				products=allProducts.getData();
				if(allProducts.getStatusCode()==200) {
					for(Product p:products)
						System.out.println(p.displayDetails());
				}else {
					System.out.println(allProducts.getErrorMessage());
				}
				break;
			case 4:
				System.out.println("Enter Product Id that is to be updated");
				productId=scanner.nextInt();
				System.out.println("Enter the new Product Name");
				productName=scanner.next();
				System.out.println("Enter the new category");
				category=scanner.next();
				System.out.println("Enter the new  price");
				price=scanner.nextDouble();
				System.out.println("Enter the new stock quantity");
				stockQuantity=scanner.nextInt();
				newProduct=new Product(productId,productName,category,price,stockQuantity);
				System.out.println(product.updateProduct(newProduct));
				break;
			case 5:
				System.out.println("Enter Product Id that is to be deleted");
				productId=scanner.nextInt();
				System.out.println(product.deleteProduct(productId));
				break;
			case 6:
				System.out.println("Thank you for using RetailMart Product Catalog Manager");
				flag=false;
				break;
			default:
				System.out.println("Invalid choice");
				
				
				
				
			}
		}
	}

}
