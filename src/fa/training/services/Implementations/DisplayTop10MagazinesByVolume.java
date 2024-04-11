package fa.training.services.Implementations;

import fa.training.Constants;
import fa.training.entities.Magazine;
import fa.training.entities.Publication;
import fa.training.services.Interfaces.DisplayTop10MagazinesByVolumeInterface;

import java.util.ArrayList;
import java.util.List;

public class DisplayTop10MagazinesByVolume implements DisplayTop10MagazinesByVolumeInterface {
    @Override
    public void execute(List<Publication> publications) {
        List<Magazine> magazines = new ArrayList<>();
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                magazines.add((Magazine) publication);
            }
        }

        magazines.sort((m1, m2) -> Integer.compare(m2.getVolume(), m1.getVolume()));

        System.out.println("\n" + Constants.TOP_10_MAGAZINES);
        for (int i = 0; i < Math.min(10, magazines.size()); i++) {
            magazines.get(i).display();
        }
        System.out.println();
    }
}
