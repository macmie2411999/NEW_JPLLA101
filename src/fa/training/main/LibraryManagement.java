package fa.training.main;

import fa.training.Constants;
import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.entities.Publication;
import fa.training.services.Implematations.*;
import fa.training.services.Interface.*;
import fa.training.utils.Validations;

import java.util.*;

public class LibraryManagement {
    private static List<Publication> publications = new ArrayList<>();

    public static void main(String[] args) {
        AddAuthorToBookInterface addAuthorToBook = (AddAuthorToBookInterface) new AddAuthorToBook();
        AddBookInterface addBook = (AddBookInterface) new AddBook();
        AddMagazineInterface addMagazine = (AddMagazineInterface) new AddMagazine();
        DisplayPublicationsByYearAndPublisherInterface displayPublicationsByYearAndPublisher = (DisplayPublicationsByYearAndPublisherInterface) new DisplayPublicationsByYearAndPublisher();
        DisplayTop10MagazinesByVolumeInterface displayTop10MagazinesByVolume = (DisplayTop10MagazinesByVolumeInterface) new DisplayTop10MagazinesByVolume();
        SearchBooksInterface searchBooks = (SearchBooksInterface) new SearchBooks();

        boolean running = true;

        // Add random Data to List of Publications
        addDummyPublications();

        // Show all Publications
        showAllPublications();

        while (running) {
            System.out.println(Constants.MAIN_MENU_TITLE);
            System.out.println(Constants.OPTION_ADD_BOOK);
            System.out.println(Constants.OPTION_ADD_MAGAZINE);
            System.out.println(Constants.OPTION_DISPLAY_PUBLICATIONS);
            System.out.println(Constants.OPTION_ADD_AUTHOR);
            System.out.println(Constants.OPTION_DISPLAY_TOP_MAGAZINES);
            System.out.println(Constants.OPTION_SEARCH_BOOKS);
            System.out.println(Constants.OPTION_EXIT);
            int choice = Validations.inputInt(Constants.ENTER_CHOICE_PROMPT);

            switch (choice) {
                case 1:
                    addBook.execute(publications);
                    break;
                case 2:
                    addMagazine.execute(publications);
                    break;
                case 3:
                    displayPublicationsByYearAndPublisher.execute(publications);
                    break;
                case 4:
                    addAuthorToBook.execute(publications);
                    break;
                case 5:
                    displayTop10MagazinesByVolume.execute(publications);
                    break;
                case 6:
                    searchBooks.execute(publications);
                    break;
                case 7:
                    running = false;
                    System.out.println(Constants.EXIT_MESSAGE);
                    break;
                default:
                    System.out.println(Constants.INVALID_CHOICE_MESSAGE);
                    break;
            }
        }
    }

    // (Additional) Add random Data to publications
    public static void addDummyPublications() {
        // Add 5 dummy books
        for (int i = 0; i < 5; i++) {
            int publicationYear = 2000 + i;
            String publisher = Constants.PUBLISHER_PREFIX + (i + 1);
            Date publicationDate = Validations.parseStringtoDate(Constants.DATE_PREFIX + (i) + Constants.DATE_MIDDLE + (i + 10));

            String isbn = Constants.ISBN_PREFIX + (i + 1);
            Set<String> authors = new HashSet<>();
            authors.add(Constants.AUTHOR_PREFIX + (i + 1));
            String publicationPlace = Constants.PLACE_PREFIX + (i + 1);

            Book book = new Book(publicationYear, publisher, publicationDate, isbn, authors, publicationPlace);
            publications.add(book);
        }

        // Add 5 dummy magazines
        for (int i = 0; i < 5; i++) {
            int publicationYear = 2000 + i + 1;
            String publisher = Constants.PUBLISHER_PREFIX + (i + 6);
            Date publicationDate = Validations.parseStringtoDate(Constants.DATE_PREFIX + (i + 1) + Constants.DATE_MIDDLE + (i + 10));

            String author = Constants.AUTHOR_PREFIX + (i + 6);
            int volume = i + 1;
            int edition = i + 1;

            Magazine magazine = new Magazine(publicationYear, publisher, publicationDate, author, volume, edition);
            publications.add(magazine);
        }
    }

    // (Additional) Add random Data to publications
    public static void showAllPublications() {
        System.out.println(Constants.ALL_PUBLICATIONS_TITLE);
        int countPublication = 0;
        for (Publication publication : publications) {
            System.out.print(++countPublication + ". ");
            publication.display();
        }
        System.out.println();
    }

//    // Add Authors for a Book
//    private static void addAuthorsForBookHelper(Set<String> authors, int numAuthors) {
//
//        for (int i = 0; i < numAuthors; i++) {
//            System.out.print(String.format(Constants.PROMPT_AUTHOR_ADJUST, (i + 1)));
//            authors.add(scanner.nextLine());
//        }
//    }
//
//    private static void addBook() {
//        // Get input for Publication
//        int publicationYear = Validations.inputInt(Constants.PROMPT_PUBLICATION_YEAR);
//        String publisher = Validations.inputLine(Constants.PROMPT_PUBLISHER);
//        Date publicationDate = Validations.inputValidDate(Constants.PROMPT_PUBLICATION_DATE);
//
//        // Get input for Book
//        String isbn = Validations.inputLine(Constants.PROMPT_ISBN);
//
//        int numAuthors = Validations.inputInt(Constants.PROMPT_NUM_AUTHORS);
//        Set<String> authors = new HashSet<>();
//        addAuthorsForBookHelper(authors, numAuthors);
//
//        String publicationPlace = Validations.inputLine(Constants.PROMPT_PUBLICATION_PLACE);
//
//        // Create Book
//        Book book = new Book(publicationYear, publisher, publicationDate, isbn, authors, publicationPlace);
//        publications.add(book);
//        System.out.println(Constants.BOOK_ADDED_SUCCESSFULLY);
//    }

//    private static void addMagazine() {
//        // Get input for Publication
//        int publicationYear = Validations.inputInt(Constants.PROMPT_PUBLICATION_YEAR);
//        String publisher = Validations.inputLine(Constants.PROMPT_PUBLISHER);
//        Date publicationDate = Validations.inputValidDate(Constants.PROMPT_PUBLICATION_DATE);
//
//        // Get input for Magazine
//        String author = Validations.inputLine(Constants.PROMPT_AUTHOR);
//        int volume = Validations.inputInt(Constants.PROMPT_VOLUME);
//        int edition = Validations.inputInt(Constants.PROMPT_EDITION);
//
//        // Create Magazine
//        Magazine magazine = new Magazine(publicationYear, publisher, publicationDate, author, volume, edition);
//        publications.add(magazine);
//        System.out.println(Constants.MAGAZINE_ADDED_SUCCESSFULLY);
//    }

//    private static void displayPublicationsByYearAndPublisher() {
//        int publicationYear = Validations.inputInt(Constants.PROMPT_PUBLICATION_YEAR);
//        String publisher = Validations.inputLine(Constants.PROMPT_PUBLISHER);
//        boolean emptyFlag = true;
//        int countPublication = 0;
//
//        System.out.println(String.format(Constants.PUBLICATIONS_BY_YEAR_PUBLISHER, publicationYear, publisher));
//        for (Publication publication : publications) {
//            if (publication.getPublicationYear() == publicationYear && publication.getPublisher().equals(publisher)) {
//                System.out.print(++countPublication + ". ");
//                publication.display();
//                emptyFlag = false;
//            }
//        }
//
//        // Notify when there is no specified Publication
//        if (emptyFlag == true) {
//            System.out.println(Constants.NO_PUBLICATIONS_FOUND);
//        }
//
//        System.out.println();
//    }

//    private static void addAuthorToBook() {
//        String isbn = Validations.inputLine(Constants.ENTER_ISBN);
//
//        Book book = null;
//        for (Publication publication : publications) {
//            if (publication instanceof Book && ((Book) publication).getIsbn().equals(isbn)) {
//                book = (Book) publication;
//                break;
//            }
//        }
//
//        if (book == null) {
//            System.out.println(Constants.BOOK_NOT_FOUND);
//            return;
//        }
//
//        System.out.print(Constants.ENTER_NEW_AUTHOR);
//        String newAuthor = scanner.nextLine();
//
//        if (book.getAuthors().contains(newAuthor)) {
//            System.out.println(Constants.AUTHOR_ALREADY_EXISTS);
//        } else {
//            book.getAuthors().add(newAuthor);
//            System.out.println(Constants.AUTHOR_ADDED_SUCCESSFULLY);
//        }
//    }

//    private static void displayTop10MagazinesByVolume() {
//        List<Magazine> magazines = new ArrayList<>();
//        for (Publication publication : publications) {
//            if (publication instanceof Magazine) {
//                magazines.add((Magazine) publication);
//            }
//        }
//
//        magazines.sort((m1, m2) -> Integer.compare(m2.getVolume(), m1.getVolume()));
//
//        System.out.println("\n" + Constants.TOP_10_MAGAZINES);
//        for (int i = 0; i < Math.min(10, magazines.size()); i++) {
//            magazines.get(i).display();
//        }
//        System.out.println();
//    }

//    private static void searchBooks() {
//        System.out.println(Constants.BOOK_SEARCH_OPTIONS);
//        System.out.println(Constants.SEARCH_BY_ISBN);
//        System.out.println(Constants.SEARCH_BY_AUTHOR);
//        System.out.println(Constants.SEARCH_BY_PUBLISHER);
//        int choice = Validations.inputInt(Constants.ENTER_CHOICE_PROMPT);
//        int countFlag = 0;
//
//        List<Book> searchResults = new ArrayList<>();
//
//        switch (choice) {
//            case 1:
//                String isbn = Validations.inputLine(Constants.PROMPT_ISBN);
//                for (Publication publication : publications) {
//                    if (publication instanceof Book && ((Book) publication).getIsbn().equals(isbn)) {
//                        searchResults.add((Book) publication);
//                    }
//                }
//                break;
//            case 2:
//                String author = Validations.inputLine(Constants.PROMPT_AUTHOR);
//                for (Publication publication : publications) {
//                    if (publication instanceof Book && ((Book) publication).getAuthors().contains(author)) {
//                        searchResults.add((Book) publication);
//                    }
//                }
//                break;
//            case 3:
//                String publisher = Validations.inputLine(Constants.PROMPT_PUBLISHER);
//                for (Publication publication : publications) {
//                    if (publication instanceof Book && publication.getPublisher().equals(publisher)) {
//                        searchResults.add((Book) publication);
//                    }
//                }
//                break;
//            default:
//                System.out.println(Constants.INVALID_CHOICE_MESSAGE);
//                return;
//        }
//
//        if (searchResults.isEmpty()) {
//            System.out.println(Constants.BOOK_NOT_FOUND);
//        } else {
//            System.out.println(Constants.SEARCH_RESULT);
//            searchResults.sort((b1, b2) -> {
//                int isbnComparison = b1.getIsbn().compareTo(b2.getIsbn());
//                if (isbnComparison != 0) {
//                    return isbnComparison;
//                } else {
//                    return b1.getPublicationDate().compareTo(b2.getPublicationDate());
//                }
//            });
//            for (Book book : searchResults) {
//                System.out.print(++countFlag + ". ");
//                book.display();
//            }
//            System.out.println();
//        }
//    }
}
