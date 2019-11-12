package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department = departmentDao.findById(3);
		System.out.println("Teste ==== FindById ");
		System.out.println(department);
		
		
		System.out.println("Test == Department insert");
		Department newDepartment = new Department(null, "Sales");
		//departmentDao.insert(newDepartment);
		System.out.println("Inserted! new id = " + newDepartment.getId());
		
		
		System.out.println("Test == Department update");
		department = departmentDao.findById(8);
		department.setName("Tecnology Information");
		//departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("=====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		//departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		
		System.out.println("=====");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		sc.close();
	}

}
