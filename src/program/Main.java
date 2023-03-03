package program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int number = sc.nextInt();
		
		for(int i = 1;i <= number;i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Comon, used or imported (c/u/i)? ");
			char letter = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Price: ");
			Double price = sc.nextDouble();
			
			if(letter == 'c') {
				list.add(new Product(name, price));
			} else if (letter == 'i') {
				System.out.print("Customs free: ");
				Double free = sc.nextDouble();
				list.add(new ImportedProduct(name, price, free));
			} else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct(name, price, date));
			}
			System.out.println();
			System.out.println("PRICE TAGS:");
			for(Product pd:list) {
				System.out.println(pd.priceTag());
			}
			
			sc.close();
		}
		
		
	}

}
