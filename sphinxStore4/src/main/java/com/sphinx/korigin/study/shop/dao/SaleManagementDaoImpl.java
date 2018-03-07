package com.sphinx.korigin.study.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dug.dao.jdbc.AbstractDaoJdbcImpl;
import com.dug.dao.shop.SaleManageDao;

public class SaleManagementDaoImpl extends AbstractDaoJdbcImpl
		implements SaleManageDao {

	private static SaleManagementDaoImpl instance = new SaleManagementDaoImpl();

	private SaleManagementDaoImpl() {

	}

	public static SaleManageDao getInstance() {
		return instance;
	}

	private String generateID() { // close()가 포함되므로 불려지는 메소드 첫줄에 실행할 것
		String sql = "select max(SaleManagement_id) from SaleManagement";
		String s = "SALE";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next() && rs.getString(1) != null) {
				int num = Integer
						.valueOf(rs.getString(1).substring(s.length()));
				s += String.format("%05d", num + 1);
			} else {
				s += String.format("%05d", 1);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return s;
	}

	@Override
	public void updateNumOfSale(String num) {
		String sql = "update SaleManagement set numOfSale = numOfSale + 1"
				+ " where num = ?";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, num);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public List<String> selectTopSale() {
		String sql = "select num from SALEMANAGEMENT order by num desc";
		List<String> numList = new ArrayList<String>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String num = rs.getString("num");
				numList.add(num);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numList;
	}

	@Override
	public String insertNumOfSale(String num) {
		String SaleManagement_id = generateID();
		String sql = "insert into SALEMANAGEMENT(SaleManagement_id,"
				+ " num, numOfSale) values(?, ?, ?)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, SaleManagement_id);
			pstmt.setString(2, num);
			pstmt.setInt(3, 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return SaleManagement_id;
	}
}
