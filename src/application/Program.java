package application;

import java.util.Date;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	//	Department obj = new Department (1, "Books");
	//	Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		SellerDao sellerdao = DaoFactory.createSellerDao();
	//	System.out.println(obj);
	//	System.out.println(seller);
		
		Seller seller = sellerdao.findById(3);
		//System.out.println(seller);
		
		Department department = new Department(2, null);
		
		System.out.println("Test == Seller insert");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerdao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		System.out.println("Test == Seller update");
		seller = sellerdao.findById(1);
		seller.setName("Martha Waine");
		sellerdao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("=====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerdao.deleteById(id);
		System.out.println("Delete completed!");
		sc.close();
	}

}
