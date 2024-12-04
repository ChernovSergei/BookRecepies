import java.util.LinkedList;
import java.util.List;

public class Recepie {
    private String name;
    private List<RecepieStep> steps;

    public Recepie(List<RecepieStep> steps, String name) {
        this.name = name;
        this.steps = steps;
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
}
