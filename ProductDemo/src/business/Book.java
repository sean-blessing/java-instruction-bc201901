package business;

public class Book extends Product {
	
	private String author;

	public Book() {
		super();
	}

	public Book(String inCode, String inDesc, double inPrice, String author) {
		super(inCode, inDesc, inPrice);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", " + super.toString() + "]";
	}
	
	

}
