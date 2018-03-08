package com.sphinx.korigin.shopping.product.dao;

import com.sphinx.korigin.shopping.product.domain.Supplier;

public interface SupplierDao {
	public void addSupplier(Supplier supplier);
	
	public Supplier findSupplierById(String supplierId);
}
