package fa.training.services.Implematations;

import fa.training.Constants;
import fa.training.entities.Book;
import fa.training.entities.Publication;
import fa.training.services.Interface.SearchBooksInterface;
import fa.training.utils.Validations;

import java.util.ArrayList;
import java.util.List;

public class SearchBooks implements SearchBooksInterface {
    @Override
    public void execute(List<Publication> publications) {
        System.out.println(Constants.BOOK_SEARCH_OPTIONS);
        System.out.println(Constants.SEARCH_BY_ISBN);
        System.out.println(Constants.SEARCH_BY_AUTHOR);
        System.out.println(Constants.SEARCH_BY_PUBLISHER);
        int choice = Validations.inputInt(Constants.ENTER_CHOICE_PROMPT);
        int countFlag = 0;

        List<Book> searchResults = new ArrayList<>();

        switch (choice) {
            case 1:
                String isbn = Validations.inputLine(Constants.PROMPT_ISBN);
                for (Publication publication : publications) {
                    if (publication instanceof Book && ((Book) publication).getIsbn().equals(isbn)) {
                        searchResults.add((Book) publication);
                    }
                }
                break;
            case 2:
                String author = Validations.inputLine(Constants.PROMPT_AUTHOR);
                for (Publication publication : publications) {
                    if (publication instanceof Book && ((Book) publication).getAuthors().contains(author)) {
                        searchResults.add((Book) publication);
                    }
                }
                break;
            case 3:
                String publisher = Validations.inputLine(Constants.PROMPT_PUBLISHER);
                for (Publication publication : publications) {
                    if (publication instanceof Book && publication.getPublisher().equals(publisher)) {
                        searchResults.add((Book) publication);
                    }
                }
                break;
            default:
                System.out.println(Constants.INVALID_CHOICE_MESSAGE);
                return;
        }

        if (searchResults.isEmpty()) {
            System.out.println(Constants.BOOK_NOT_FOUND);
        } else {
            System.out.println(Constants.SEARCH_RESULT);
            searchResults.sort((b1, b2) -> {
                int isbnComparison = b1.getIsbn().compareTo(b2.getIsbn());
                if (isbnComparison != 0) {
                    return isbnComparison;
                } else {
                    return b1.getPublicationDate().compareTo(b2.getPublicationDate());
                }
            });
            for (Book book : searchResults) {
                System.out.print(++countFlag + ". ");
                book.display();
            }
            System.out.println();
        }
    }
}
