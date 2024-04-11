package fa.training.services.Implementations;

import fa.training.Constants;
import fa.training.entities.Magazine;
import fa.training.entities.Publication;
import fa.training.services.Interfaces.AddMagazineInterface;
import fa.training.utils.Validations;

import java.util.Date;
import java.util.List;

public class AddMagazine implements AddMagazineInterface {
    @Override
    public void execute(List<Publication> publications) {
        // Get input for Publication
        int publicationYear = Validations.inputInt(Constants.PROMPT_PUBLICATION_YEAR);
        String publisher = Validations.inputLine(Constants.PROMPT_PUBLISHER);
        Date publicationDate = Validations.inputValidDate(Constants.PROMPT_PUBLICATION_DATE);

        // Get input for Magazine
        String author = Validations.inputLine(Constants.PROMPT_AUTHOR);
        int volume = Validations.inputInt(Constants.PROMPT_VOLUME);
        int edition = Validations.inputInt(Constants.PROMPT_EDITION);

        // Create Magazine
        Magazine magazine = new Magazine(publicationYear, publisher, publicationDate, author, volume, edition);
        publications.add(magazine);
        System.out.println(Constants.MAGAZINE_ADDED_SUCCESSFULLY);
    }
}
