package fa.training.services.Implematations;

import fa.training.Constants;
import fa.training.entities.Publication;
import fa.training.services.Interface.DisplayPublicationsByYearAndPublisherInterface;
import fa.training.utils.Validations;

import java.util.List;

public class DisplayPublicationsByYearAndPublisher implements DisplayPublicationsByYearAndPublisherInterface {
    @Override
    public void execute(List<Publication> publications) {
        int publicationYear = Validations.inputInt(Constants.PROMPT_PUBLICATION_YEAR);
        String publisher = Validations.inputLine(Constants.PROMPT_PUBLISHER);
        boolean emptyFlag = true;
        int countPublication = 0;

        System.out.println(String.format(Constants.PUBLICATIONS_BY_YEAR_PUBLISHER, publicationYear, publisher));
        for (Publication publication : publications) {
            if (publication.getPublicationYear() == publicationYear && publication.getPublisher().equals(publisher)) {
                System.out.print(++countPublication + ". ");
                publication.display();
                emptyFlag = false;
            }
        }

        // Notify when there is no specified Publication
        if (emptyFlag == true) {
            System.out.println(Constants.NO_PUBLICATIONS_FOUND);
        }

        System.out.println();
    }
}
