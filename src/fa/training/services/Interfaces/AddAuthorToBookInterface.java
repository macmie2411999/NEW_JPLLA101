package fa.training.services.Interfaces;

import fa.training.entities.Publication;

import java.util.List;

public interface AddAuthorToBookInterface {
    void execute(List<Publication> publications);
}
