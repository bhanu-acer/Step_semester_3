public class LibraryCatalog {
    public static String findBook(String[] isbn, String[] titles, String target) {
        int low = 0;
        int high = isbn.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = isbn[mid].compareTo(target);

            if (result == 0) {
                return titles[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        String[] isbn = {
            "0001112223", "0002223334", "0003334445",
            "0004445556", "0005556667"
        };

        String[] titles = {
            "Introduction to Algebra", "Beginning Python",
            "Classic Mythology", "Data and Society",
            "European History"
        };

        System.out.println(findBook(isbn, titles, "0003334445"));
        System.out.println(findBook(isbn, titles, "0009998887"));
    }
}