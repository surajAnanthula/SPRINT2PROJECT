package com.example.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.example.entiity.Product;
@Repository
public class DaoClass implements DaoInterface {

	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public Product ProductCreation(Product emp) {
		
		Product p=em.merge(emp);
		return p;
	}
	
	@Override
	public Product getProductById(int id) {
		
		return em.find(Product.class,id);
	}
	
	@Override
	public List<Product> getAllEmployee() {
		Query q=em.createQuery("select m from Product m");
		List<Product> emplist=q.getResultList();
		return emplist;
	}
	
	@Override
	public Product UpdateEmployee(Product emp) {
		Product e=em.find(Product.class,emp.getId());
		if(e!=null)
		{
			e.setName(emp.getName());
			e.setId(emp.getId());
			e.setPrice(emp.getPrice());
			e.setCategory(emp.getCategory());
		}
		return e;
			
	}
	@Override	
	public Product deleteById(int id) {
		Product e=em.find(Product.class,id);
		if(e!=null)
			{em.remove(e);
			}
        return e;
	}
}
