package fi.haagahelia.bookstore.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String isbn;
	private String title, author;
	private int pubYear;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Book() {}
	
	
	public Book(String isbn, String title, String author, int pubYear, double price, Category category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.pubYear = pubYear;
		this.price = price;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	} 
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPubYear() {
		return pubYear;
	}
	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		if (this.category != null)
			return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", pubYear=" + pubYear
					+ ", price=" + price + ", gategory =" + this.getCategory() + "]";		
		else
			return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", pubYear=" + pubYear
					+ ", price=" + price + "]";
	}
	
}