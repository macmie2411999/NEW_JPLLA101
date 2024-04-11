package fa.training.services.Interface;

import fa.training.entities.Publication;

import java.util.List;

public interface AddBookInterface {
    void execute(List<Publication> publications);
}
