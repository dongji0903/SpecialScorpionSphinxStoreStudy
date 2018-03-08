package com.sphinx.korigin.study.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dug.dao.jdbc.AbstractDaoJdbcImpl;
import com.dug.dao.shop.OrderDao;
import com.dug.domain.member.Member;
import com.dug.domain.shop.Order;
import com.dug.util.Utill;

public class OrderDaoImpl extends AbstractDaoJdbcImpl implements OrderDao {

	private OrderDaoImpl() {
	}

	private static OrderDaoImpl instance = new OrderDaoImpl();

	public static OrderDaoImpl getInstance() {
		return instance;
	}
	
	private String generateID() { // close()가 포함되므로 불려지는 메소드 첫줄에 실행할 것
		String sql = "select max(Orders_id) from Orders";
		String s = "ORDER";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next() && rs.getString(1) != null) {
				int num = Integer.valueOf(rs.getString(1).substring(s.length()));
				s += String.format("%05d", num + 1);
			} else {
				s += String.format("%05d", 1);
			}
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			close();
		}
		return s;
	}

	@Override
	public List<Order> selectAllOrders() {
		String sql = "SELECT Order_id,itemIdList,itemNumList, name, phone, receiverName, "
				+ "receiverAddress,giverWant,payType,price,discount,totalPrice,orderDate FROM Orders";

		List<Order> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Utill utill = new Utill();
				
				Order ovo = new Order();
				ovo.setOrderId(rs.getString("Orders_id"));
				ovo.setItemIdList(utill.stringToList(rs.getString("itemIdList")));
				ovo.setItemNumList(utill.stringToList(rs.getString("itemNumList")));
				Member buyer = new Member();
				buyer.setName(rs.getString("name"));
				buyer.setPhonenumber(rs.getString("phone"));
				ovo.setBuyer(buyer);
				ovo.setReceiverName(rs.getString("receiverName"));
				ovo.setReceiverAddress(rs.getString("receiveraddress"));
				ovo.setGiverWant(rs.getString("giverWant"));
				ovo.setPayType(rs.getString("payType"));
				ovo.setPrice(rs.getFloat("price"));
				ovo.setDiscount(rs.getFloat("discount"));
				ovo.setTotalPrice(rs.getFloat("totalPrice"));
				ovo.setDate(rs.getTimestamp("orderDate"));
				list.add(ovo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	@Override
	public String insertOrder(Order ovo) {
		String sql = "INSERT INTO Orders(Order_id, itemIdList ,itemNumList, name, phone, receiverName, "
				+"receiverAddress,giverWant,payType,price,discount,totalPrice,orderDate )"
				+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		String id = generateID();
		
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			Utill utill = new Utill();
			
			ps.setString(1, id);
			ps.setString(2, utill.listToString(ovo.getItemIdList()));
			ps.setString(3, utill.listToString(ovo.getItemNumList()));		
			ps.setString(4, ovo.getBuyer().getName());
			ps.setString(5, ovo.getBuyer().getPhonenumber());
			ps.setString(6, ovo.getReceiverName());
			ps.setString(7, ovo.getReceiverAddress());
			ps.setString(8, ovo.getGiverWant());
			ps.setString(9, ovo.getPayType());
			ps.setDouble(10, ovo.getPrice());
			ps.setDouble(11, ovo.getDiscount());
			ps.setDouble(12, ovo.getTotalPrice());
			ps.setTimestamp(13, new Timestamp(ovo.getDate().getTime()));
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return id;
	}
	@Override
	public Order selectOrder(String num) {

		String sql = "SELECT Order_id,itemIdList,itemNumList, name, phone, receiverName, "
				+ "receiverAddress, giverWant, payType, price, discount, totalPrice, orderDate"
				+ " FROM Orders WHERE num = ?";

		Order ovo = new Order();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, num);
			rs = ps.executeQuery();

			if (rs.next()) {
				Utill utill = new Utill();
				
				ovo.setOrderId(rs.getString("Orders_id"));
				ovo.setItemIdList(utill.stringToList(rs.getString("itemIdList")));
				ovo.setItemNumList(utill.stringToList(rs.getString("itemNumList")));
				Member buyer = new Member();
				buyer.setName(rs.getString("name"));
				buyer.setPhonenumber(rs.getString("phone"));
				ovo.setBuyer(buyer);
				ovo.setReceiverName(rs.getString("receiverName"));
				ovo.setReceiverAddress(rs.getString("receiveraddress"));
				ovo.setGiverWant(rs.getString("giverWant"));
				ovo.setPayType(rs.getString("payType"));
				ovo.setPrice(rs.getFloat("price"));
				ovo.setDiscount(rs.getFloat("discount"));
				ovo.setTotalPrice(rs.getFloat("totalPrice"));
				ovo.setDate(rs.getTimestamp("orderDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return ovo;
	}


}
