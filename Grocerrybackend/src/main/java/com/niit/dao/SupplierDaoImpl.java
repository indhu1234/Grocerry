package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDaoImpl implements SupplierDao
{
	@Autowired
	SessionFactory sessionFactory; 
	
	public List<Supplier> listSuppliers() 
	{
		Session session=sessionFactory.openSession();
		List<Supplier> listSuppliers=(List<Supplier>)session.createQuery("from Supplier").list();
		session.close();
		return listSuppliers;
	}


	@Override
	public boolean addSupplier(Supplier supplier) 
	{
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
		
	
	}


	@Override
	public boolean deleteSupplier(Supplier supplier)
	{
		// TODO Auto-generated method stub
		
		try
		{
		sessionFactory.getCurrentSession().delete(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
		
		
	}


	@Override
	public boolean updateSupplier(Supplier supplier) 
	{
		// TODO Auto-generated method stub
		
		try
		{
		sessionFactory.getCurrentSession().update(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}

	
	}

	@Override
	public Supplier getSupplier(int supplierId) 
	{
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
		session.close();
		return supplier;

		
	}


	
}
