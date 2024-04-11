package fa.training.services.Interfaces;

import fa.training.entities.Publication;

import java.util.List;

public interface SearchBooksInterface {
    void execute(List<Publication> publications);
}
