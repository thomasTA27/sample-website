
package thai.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import thai.main.entity.Food;
import thai.main.utility.DBUtils;

public class ProductDAO {

	public Food getProductById(int id) {
		Connection conn = null;
		try {
			conn = DBUtils.makeConnection();

			String SQLQuery = "SELECT * FROM food where id = " + id;

			PreparedStatement statement = conn.prepareStatement(SQLQuery);
			ResultSet rs = statement.executeQuery();
			boolean check = rs.next();

			if (check == false) {
				System.out.println("No product found");
			} else {
				int productID = rs.getInt("id");
				String productName = rs.getString("name");
				int productPrice = rs.getInt("price");
				return new Food(productID, productName, productPrice);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public ArrayList<Food> getAllProduct() {
		Connection conn = null;
		try {

			conn = DBUtils.makeConnection();

			String SQLQuery = "SELECT * FROM food  ";

			PreparedStatement statement = conn.prepareStatement(SQLQuery);
			ResultSet rs = statement.executeQuery();
//			boolean check = rs.next();
			ArrayList<Food> foodList = new ArrayList<>();

			while (rs.next()) {

				int productID = rs.getInt("id");
				String productName = rs.getString("name");
				int productPrice = rs.getInt("price");
				foodList.add(new Food(productID, productName, productPrice));
			}
			return foodList;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
