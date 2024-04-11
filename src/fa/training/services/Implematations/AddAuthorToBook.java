package fa.training.services.Implematations;

import fa.training.Constants;
import fa.training.entities.Book;
import fa.training.entities.Publication;
import fa.training.services.Interface.AddBookInterface;
import fa.training.utils.Validations;

import java.util.List;

import static fa.training.utils.Validations.scanner;

public class AddAuthorToBook implements AddBookInterface {
    @Override
    public void execute(List<Publication> publications) {
        String isbn = Validations.inputLine(Constants.ENTER_ISBN);

        Book book = null;
        for (Publication publication : publications) {
            if (publication instanceof Book && ((Book) publication).getIsbn().equals(isbn)) {
                book = (Book) publication;
                break;
            }
        }

        if (book == null) {
            System.out.println(Constants.BOOK_NOT_FOUND);
            return;
        }

        System.out.print(Constants.ENTER_NEW_AUTHOR);
        String newAuthor = scanner.nextLine();

        if (book.getAuthors().contains(newAuthor)) {
            System.out.println(Constants.AUTHOR_ALREADY_EXISTS);
        } else {
            book.getAuthors().add(newAuthor);
            System.out.println(Constants.AUTHOR_ADDED_SUCCESSFULLY);
        }
    }
}
