package ui;
import business.Book;
import business.Product;

public class ProductDemoApp {

	public static void main(String[] args) {
		System.out.println("hello");
//		Product product1 = new Product("java","Murach's Java Programming", 57.50);
//		Product product2 = new Product("mysql","Murach's MySQL",54.50);
//		Product.aStaticMethod();
//	
//		System.out.println(product1.getCode()+" "+product1.getDescription() + " "+ product1.getPrice());
//		System.out.println(product2);
		
		
		// Create a book
		Book seansBook = new Book("java","Murach's Java Programming", 57.50,
									"Joel Murach");
		System.out.println(seansBook);
		System.out.println("seansBook is a "+seansBook.getClass().getName());
		Product p = seansBook;
		//seansBook.getAuthor();
		System.out.println(p);
		System.out.println("bye");
	}

}
