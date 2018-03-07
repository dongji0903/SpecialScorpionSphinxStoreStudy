package com.sphinx.korigin.study.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.dug.dao.jdbc.AbstractDaoJdbcImpl;
import com.dug.dao.shop.StockManagementDao;

public class StockManagementDaoImpl extends AbstractDaoJdbcImpl
		implements StockManagementDao {

	private static StockManagementDaoImpl instance = new StockManagementDaoImpl();

	private StockManagementDaoImpl() {

	}

	public static StockManagementDao getInstance() {
		return instance;
	}

	private String generateID() { // close()가 포함되므로 불려지는 메소드 첫줄에 실행할 것
		String sql = "select max(StockManagement_id) from StockManagement";
		String s = "STOCK";
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
	public void updateStock(String num, int stock) {
		String sql = "update StockManagement set stock = stock - ? , Date = ?, "
				+ "change_stock = ? where num = ?";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
			ps.setInt(3, stock);
			ps.setString(4, num);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	@Override
	public String insertStock(String num, int stock) {
		String sql = "insert into StockManagement"
				+ " (StockManagement_id, stock, num, Date) values(?, ?, ?, ?)";
		String StockManagementId = generateID();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, StockManagementId);
			pstmt.setInt(2, stock);
			pstmt.setString(3, num);
			pstmt.setTimestamp(4, new Timestamp(new Date().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return StockManagementId;

	}

	@Override
	public int selectStock(String num) {
		String sql = "select stock from stockmanagement where num = ?";
		int stock = 0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				stock = rs.getInt("stock");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return stock;
	}

	@Override
	public void resetStock(String num, int stock) {
		String sql = "update StockManagement set stock = ?, Date = ?"
				+ " where num = ?";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
			ps.setString(3, num);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}

}
