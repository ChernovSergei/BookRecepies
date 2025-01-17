import java.util.ArrayList;
import java.util.List;

public class Recepie {
    private String name;
    private List<RecepieStep> steps;

    public Recepie(String name) {
        this.name = name;
        this.steps = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecepieStep> getSteps() {
        return steps;
    }

    public void setSteps(List<RecepieStep> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Recepie{" +
                "name='" + name + '\'' +
                ", steps=" + steps +
                '}';
    }
}
