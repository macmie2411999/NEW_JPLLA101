package fa.training;

public class Constants {

    // Menu
    public static final String MAIN_MENU_TITLE = "====== LIBRARY MANAGEMENT SYSTEM ======";

    public static final String ALL_PUBLICATIONS_TITLE = "====== ALL PUBLICATIONS ======";
    public static final String OPTION_ADD_BOOK = "1. Add a new book";
    public static final String OPTION_ADD_MAGAZINE = "2. Add a new magazine";
    public static final String OPTION_DISPLAY_PUBLICATIONS = "3. Display publications by year and publisher";
    public static final String OPTION_ADD_AUTHOR = "4. Add an author to a book";
    public static final String OPTION_DISPLAY_TOP_MAGAZINES = "5. Display top 10 magazines by volume";
    public static final String OPTION_SEARCH_BOOKS = "6. Search books";
    public static final String OPTION_EXIT = "7. Exit";
    public static final String ENTER_CHOICE_PROMPT = "Enter your choice: ";

    // Add Book
    public static final String PROMPT_PUBLICATION_YEAR = "Enter publication year: ";
    public static final String PROMPT_PUBLISHER = "Enter publisher: ";
    public static final String PROMPT_PUBLICATION_DATE = "Enter publication date (yyyy/MM/dd): ";
    public static final String PROMPT_ISBN = "Enter ISBN: ";
    public static final String PROMPT_NUM_AUTHORS = "Enter number of authors: ";
    public static final String PROMPT_PUBLICATION_PLACE = "Enter publication place: ";
    public static final String BOOK_ADDED_SUCCESSFULLY = "Book added successfully.";

    // Add Magazine
    public static final String PROMPT_AUTHOR = "Enter author: ";
    public static final String PROMPT_AUTHOR_ADJUST = "Enter author %d: ";
    public static final String PROMPT_VOLUME = "Enter volume: ";
    public static final String PROMPT_EDITION = "Enter edition: ";
    public static final String MAGAZINE_ADDED_SUCCESSFULLY = "Magazine added successfully.";

    // Display Publication and Publisher
    public static final String NO_PUBLICATIONS_FOUND = "No publications found for the given year and publisher.";
    public static final String PUBLICATIONS_BY_YEAR_PUBLISHER = "Publications for year %d and publisher %s:";

    // Create random publications
    public static final String PUBLISHER_PREFIX = "Publisher ";
    public static final String DATE_PREFIX = "200";
    public static final String DATE_MIDDLE = "-04-";
    public static final String ISBN_PREFIX = "ISBN";
    public static final String AUTHOR_PREFIX = "Author ";
    public static final String PLACE_PREFIX = "Place ";

    // Add other Authors
    public static final String ENTER_ISBN = "Enter ISBN of the book: ";
    public static final String BOOK_NOT_FOUND = "Book not found.";
    public static final String ENTER_NEW_AUTHOR = "Enter new author: ";
    public static final String AUTHOR_ALREADY_EXISTS = "Author existed.";
    public static final String AUTHOR_ADDED_SUCCESSFULLY = "Add successfully.\n";

    // Top Magazines
    public static final String TOP_10_MAGAZINES = "====== TOP 10 MAGAZINES BY VOLUME ======";

    // Search
    public static final String BOOK_SEARCH_OPTIONS = "Book Search Options:";
    public static final String SEARCH_BY_ISBN = "1. Search by ISBN";
    public static final String SEARCH_BY_AUTHOR = "2. Search by author";
    public static final String SEARCH_BY_PUBLISHER = "3. Search by publisher";


    // Others

    public static final String SEARCH_RESULT = "\n====== SEARCH RESULTS ======";
    public static final String EXIT_MESSAGE = "Exiting Library Management System.";
    public static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Please try again.";
    public static final String INVALID_INT_INPUT = "Invalid input. Please enter a valid int value.";

    public static final String INVALID_LINE_INPUT = "Invalid input. Please enter a valid string value.";

    public static final String INVALID_DATE_FORMAT_INPUT = "Invalid date format. Please enter date in yyyy/MM/dd format.";
    public static final String DATE_FORMAT = "yyyy/MM/dd";

    public static final String REGEX_VALID_DATE_DDMMYYYY = "^\\d{2}/\\d{2}/\\d{4}$";
    public static final String REGEX_VALID_DATE_YYYYMMDD = "^\\d{4}/\\d{2}/\\d{2}$";
}
