package com.sphinx.beautea.product.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.beautea.product.dao.SupplierDao;
import com.sphinx.beautea.product.domain.Supplier;

@Repository("supplierDao")
public class SupplierDaoJdbcImpl implements SupplierDao {
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addSupplier(Supplier supplier) {
		String sql = "insert in to Supplier(supplierId, supplierName, phone) "
				+ "values (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { supplier.getSupplierId(),
				supplier.getSupplierName(), supplier.getPhone() });
	}

	@Override
	public Supplier findSupplierById(String id) {
		String sql = "select supplierId, supplierName, phone from supplier where supplierid = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Supplier>() {
			@Override
			public Supplier mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				Supplier supplier = new Supplier();
				supplier.setSupplierId(rs.getString("supplierId"));
				supplier.setSupplierName(rs.getString("supplierName"));
				supplier.setPhone(rs.getString("phone"));
				return supplier;
			}
			
		}, id);
	}
	
	@Override
	public List<Supplier> findSupplierListByName(String name) {
		String sql = "select supplierId, supplierName, phone from supplier where supplierName = ?";
		
		return jdbcTemplate.query(sql, new RowMapper<Supplier>() {
			@Override
			public Supplier mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				Supplier supplier = new Supplier();
				supplier.setSupplierId(rs.getString("supplierId"));
				supplier.setSupplierName(rs.getString("supplierName"));
				supplier.setPhone(rs.getString("phone"));
				return supplier;
			}
			
		}, name);
	}

	public void setJdbcTemplate(JdbcTemplate jdcTemplate) {
		this.jdbcTemplate = jdcTemplate;
	}

}
