package com.sphinx.korigin.study.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dug.dao.jdbc.AbstractDaoJdbcImpl;
import com.dug.dao.shop.ItemDao;
import com.dug.domain.shop.Item;
import com.dug.util.Utill;

public class ItemDaoImpl extends AbstractDaoJdbcImpl implements ItemDao {

	private static ItemDaoImpl instance = new ItemDaoImpl();

	private ItemDaoImpl() {

	}

	public static ItemDaoImpl getInstance() {
		return instance;
	}
	Utill util = new Utill();
	
	private String generateID() { // close()가 포함되므로 불려지는 메소드 첫줄에 실행할 것
		String sql = "select max(num) from item";
		String s = "ITEM";
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
	public int selectMaxItems() {
		String sql = "SELECT count(*) FROM item";
		int maxItems = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				maxItems = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return maxItems;
	}
	@Override
	public int selectMaxSearchItems(String name) {
		String sql = "SELECT count(*) FROM item where name like ?";
		int maxItems = 0;
		String search = "%" + name + "%";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, search);
			rs = ps.executeQuery();

			while (rs.next()) {
				maxItems = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return maxItems;
	}
	@Override
	public List<Item> selectAllItems() {
		String sql = "SELECT * FROM item Order by num desc";

		List<Item> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Item ivo = new Item();
				ivo.setNum(rs.getString("num"));
				ivo.setPrice(rs.getInt("price"));
				ivo.setName(rs.getString("name"));
				ivo.setUrl(rs.getString("url"));
				ivo.setContent(rs.getString("content"));
				ivo.setType1(rs.getString("itemtype"));
				ivo.setType2(rs.getString("itemtype2"));

				ivo.setCategory(rs.getString("category"));
				list.add(ivo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	@Override
	public String insertItem(Item ivo) {
		String itemId = generateID();
		String sql = "INSERT INTO Item(num, name, price, url, content, itemtype,"
				+ " itemtype2, category) values(?, ?, ?, ?, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, generateID());
			ps.setString(2, ivo.getName());
			ps.setFloat(3, ivo.getPrice());
			ps.setString(4, ivo.getUrl());
			ps.setString(5, ivo.getContent());
			ps.setString(6, ivo.getType1());
			ps.setString(7, ivo.getType2());
			ps.setString(8, ivo.getCategory());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return itemId;
	}
	
	@Override
	public List<Item> adaptedItemListForPage(int offset, int count, String name) {
		List<Item> itemList = new ArrayList<>();
		String sql = "select * from item where name like ? order by num desc offset "
				+ String.valueOf(offset) + " rows fetch next "
				+ String.valueOf(count) + " rows only";

		String search = "%" + name + "%";
		Item ivo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ivo = new Item();
				ivo.setNum(rs.getString("num"));
				ivo.setPrice(rs.getInt("price"));
				ivo.setName(rs.getString("name"));
				ivo.setUrl(rs.getString("url"));
				ivo.setContent(rs.getString("content"));
				
				ivo.setType1(rs.getString("itemtype"));
				ivo.setType2(rs.getString("itemtype2"));

				ivo.setCategory(rs.getString("category"));
				itemList.add(ivo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return itemList;
	}
	
	@Override
	public List<Item> adaptedItemListForPage(int offset, int count) {
		List<Item> itemList = new ArrayList<>();
		String sql = "select * from item order by num desc offset "
				+ String.valueOf(offset) + " rows fetch next "
				+ String.valueOf(count) + " rows only";
		Item ivo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ivo = new Item();
				ivo.setNum(rs.getString("num"));
				ivo.setPrice(rs.getInt("price"));
				ivo.setName(rs.getString("name"));
				ivo.setUrl(rs.getString("url"));
				ivo.setContent(rs.getString("content"));

				ivo.setType1(rs.getString("itemtype"));
				ivo.setType2(rs.getString("itemtype2"));
				
				ivo.setCategory(rs.getString("category"));
				itemList.add(ivo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return itemList;
	}
	
	@Override
	public Item selectItem(String num) {
		String sql = "SELECT * FROM Item WHERE num = ?";

		Item ivo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, num);
			rs = ps.executeQuery();

			if (rs.next()) {
				ivo = new Item();
				ivo.setNum(rs.getString("num"));
				ivo.setPrice(rs.getInt("price"));
				ivo.setName(rs.getString("name"));
				ivo.setUrl(rs.getString("url"));
				ivo.setContent(rs.getString("content"));
				ivo.setType1(rs.getString("itemtype"));
				ivo.setType2(rs.getString("itemtype2"));
				ivo.setCategory(rs.getString("category"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return ivo;
	}
	
	@Override
	public List<Item> selectItems(String name) {
		String sql = "SELECT * FROM Item WHERE name like ?";
		String search = "%" + name + "%";

		List<Item> selectItemList = new ArrayList<Item>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, search);
			rs = ps.executeQuery();

			while (rs.next()) {
				Item ivo = new Item();
				ivo.setNum(rs.getString("num"));
				ivo.setPrice(rs.getInt("price"));
				ivo.setName(rs.getString("name"));
				ivo.setUrl(rs.getString("url"));
				ivo.setContent(rs.getString("content"));

				ivo.setType1(rs.getString("itemtype"));
				ivo.setType2(rs.getString("itemtype2"));
				
				ivo.setCategory(rs.getString("category"));
				selectItemList.add(ivo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return selectItemList;

	}
	
	@Override
	public void updateItem(Item ivo) {
		String sql = "update item set name = ?, price = ?, url = ?, content = ?,"
				+ " itemtype = ?, itemtype2 = ?, category = ? where num = ?";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, ivo.getName());
			ps.setFloat(2, ivo.getPrice());
			ps.setString(3, ivo.getUrl());
			ps.setString(4, ivo.getContent());
			ps.setString(5, ivo.getType1());
			ps.setString(6, ivo.getType2());
			ps.setString(7, ivo.getCategory());
			ps.setString(8, ivo.getNum());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	@Override
	public List<Item> bestSellers(int num) {
		String sql = "select * from Item order by numOfSale desc offset"
				+ " 0 rows fetch next ? rows only";

		List<Item> selectItemList = new ArrayList<Item>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();

			while (rs.next()) {
				Item ivo = new Item();
				ivo.setNum(rs.getString("num"));
				ivo.setPrice(rs.getInt("price"));
				ivo.setName(rs.getString("name"));
				ivo.setUrl(rs.getString("url"));
				ivo.setContent(rs.getString("content"));

				ivo.setType1(rs.getString("itemtype"));
				ivo.setType2(rs.getString("itemtype2"));
				
				ivo.setCategory(rs.getString("category"));
				selectItemList.add(ivo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return selectItemList;
	}
}
