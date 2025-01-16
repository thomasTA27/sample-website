package thai.main;

import java.util.ArrayList;

import thai.main.dao.ProductDAO;
import thai.main.entity.Food;

public class DBConnectionMain {
	public static void main(String[] args) {
		ProductDAO productDao = new ProductDAO();
		Food f1 = productDao.getProductById(1);

		System.out.println(f1.toString());

		System.out.println("All products: ");

		ArrayList<Food> foodList = productDao.getAllProduct();

		for (Food f : foodList) {
			System.out.println(f.toString());
		}

	}
}
