import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recepie recepie = (Recepie) o;
        return Objects.equals(name, recepie.name) && Objects.equals(steps, recepie.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, steps);
    }
}
