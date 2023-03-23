import java.util.ArrayList;

public class Treatments {
    private final  ArrayList<Treatment> TREATMENTS;

    public Treatments(ArrayList<Treatment> treatments) throws IllegalArgumentException {
        if (treatments == null) {
            throw new IllegalArgumentException("Treatments cannot be null");
        }
        this.TREATMENTS = treatments;
    }

    public ArrayList<Treatment> getTreatments() {
        return TREATMENTS;
    }

    public Treatment getTreatment(int id) {
        for (Treatment treatment : TREATMENTS) {
            if (treatment.getId() == id) {
                return treatment;
            }
        }
        return null;
    }

}
