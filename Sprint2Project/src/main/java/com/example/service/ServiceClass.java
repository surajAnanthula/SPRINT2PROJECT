package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entiity.Product;
import com.example.dao.DaoClass;


@Service
@Transactional
public class ServiceClass {

@Autowired
DaoClass dao;

public Product ProductCreation(Product emp) {
	return dao.ProductCreation(emp);
}

public Product getProductById(int id) 
{
return dao.getProductById(id);
}

public List<Product> getAllEmployee() 
{
return dao.getAllEmployee();
}

public Product delete(int id) 
{
	return dao.deleteById(id);
}

public Product UpdateEmployee(Product emp) {
	return dao.UpdateEmployee(emp);	
}

}