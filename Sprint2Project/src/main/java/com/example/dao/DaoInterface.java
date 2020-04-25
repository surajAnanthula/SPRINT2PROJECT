package com.example.dao;

import java.util.List;

import com.example.entiity.Product;

public interface DaoInterface {
	Product deleteById(int id);

	List<Product> getAllEmployee();

	Product ProductCreation(Product emp);

	Product UpdateEmployee(Product emp);

	Product getProductById(int id);

}
