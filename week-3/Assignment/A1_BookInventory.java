public class A1_BookInventory {
    String title;
    String author;
    int copiesAvailable;

    public A1_BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        A1_BookInventory[] inventory = {
            new A1_BookInventory("Clean Code", "Robert C. Martin", 3),
            new A1_BookInventory("Effective Java", "Joshua Bloch", 5),
            new A1_BookInventory("Refactoring", "Martin Fowler", 0),
            new A1_BookInventory("Design Patterns", "GoF", 2)
        };

        for (A1_BookInventory book : inventory) {
            book.printEntry();
        }
    }
}
