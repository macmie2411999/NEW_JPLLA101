package fa.training.services.Implematations;

import fa.training.Constants;
import fa.training.entities.Book;
import fa.training.entities.Publication;
import fa.training.services.Interface.AddBookInterface;
import fa.training.utils.Validations;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static fa.training.utils.Validations.scanner;

public class AddBook implements AddBookInterface {
    @Override
    public void execute(List<Publication> publications) {
        // Get input for Publication
        int publicationYear = Validations.inputInt(Constants.PROMPT_PUBLICATION_YEAR);
        String publisher = Validations.inputLine(Constants.PROMPT_PUBLISHER);
        Date publicationDate = Validations.inputValidDate(Constants.PROMPT_PUBLICATION_DATE);

        // Get input for Book
        String isbn = Validations.inputLine(Constants.PROMPT_ISBN);

        int numAuthors = Validations.inputInt(Constants.PROMPT_NUM_AUTHORS);
        Set<String> authors = new HashSet<>();
        addAuthorsForBookHelper(authors, numAuthors);

        String publicationPlace = Validations.inputLine(Constants.PROMPT_PUBLICATION_PLACE);

        // Create Book
        Book book = new Book(publicationYear, publisher, publicationDate, isbn, authors, publicationPlace);
        publications.add(book);
        System.out.println(Constants.BOOK_ADDED_SUCCESSFULLY);
    }

    // Add Authors for a Book Helper
    private static void addAuthorsForBookHelper(Set<String> authors, int numAuthors) {
        for (int i = 0; i < numAuthors; i++) {
            System.out.print(String.format(Constants.PROMPT_AUTHOR_ADJUST, (i + 1)));
            authors.add(scanner.nextLine());
        }
    }
}
