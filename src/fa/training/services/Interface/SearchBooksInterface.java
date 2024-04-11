package fa.training.services.Interface;

import fa.training.entities.Publication;

import java.util.List;

public interface SearchBooksInterface {
    void execute(List<Publication> publications);
}
