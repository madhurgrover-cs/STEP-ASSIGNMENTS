// P1_LibraryCatalogLookup.java
import java.util.*;

public class P1_LibraryCatalogLookup {
    static class BookRecord {
        String isbn;
        String title;

        public BookRecord(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    public static String findBook(List<BookRecord> catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = catalog.get(mid).isbn.compareTo(targetIsbn);
            if (cmp == 0) {
                return catalog.get(mid).title;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        List<BookRecord> catalog = Arrays.asList(
            new BookRecord("0001112223", "Introduction to Algebra"),
            new BookRecord("0002223334", "Beginning Python"),
            new BookRecord("0003334445", "Classic Mythology"),
            new BookRecord("0004445556", "Data and Society"),
            new BookRecord("0005556667", "European History")
        );

        System.out.println(findBook(catalog, "0003334445")); // "Classic Mythology"
        System.out.println(findBook(catalog, "0009998887")); // "Not Found"
    }
}
