package responsePayload;

public class Book {
    private int id,
            currentStock;
    private String name,
            author,
            isbn,
            type;
    private float price;
    private boolean available;

    public Book(int id, String name, String type, boolean available) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.available = available;
    }

    public Book(int id, int currentStock, String name, String author, String isbn, String type, float price, boolean available) {
        this.id = id;
        this.currentStock = currentStock;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.type = type;
        this.price = price;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }
}
