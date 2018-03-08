package com.sphinx.beautea.product.dao;

import java.util.List;

import com.sphinx.beautea.product.domain.Supplier;

public interface SupplierDao {
	public void addSupplier(Supplier supplier);
	public Supplier findSupplierById(String id);
	public List<Supplier> findSupplierListByName(String name);
}
