package com.sphinx.korigin.shopping.product.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.shopping.product.dao.SupplierDao;
import com.sphinx.korigin.shopping.product.domain.Supplier;

@Repository("supplierDao")
public class SupplierJdbcDaoImpl implements SupplierDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addSupplier(Supplier supplier) {
		String sql = "insert into Supplier(supplierId, supplierName, phone)"
				+ " values(? ,?, ?)";
		jdbcTemplate.update(sql, new Object[] { supplier.getSupplierId(),
				supplier.getSupplierName(), supplier.getPhone() });
	}

	@Override
	public Supplier findSupplierById(String supplierId) {
		String sql = "select Supplier(supplierId, supplierName, phone) "
				+ "from Supplier where supplierId = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Supplier>() {
			@Override
			public Supplier mapRow(ResultSet rs, int rowNum) throws SQLException {
				Supplier supplier = new Supplier();
				supplier.setSupplierId(rs.getString("supplierId"));
				supplier.setSupplierName(rs.getString("supplierName"));
				supplier.setPhone(rs.getString("phone"));
				return supplier;
			}
		}, supplierId);
	}
/*
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/
}
