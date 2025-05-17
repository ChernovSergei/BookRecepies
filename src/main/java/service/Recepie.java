package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recepie {
    private int id;
    private String name;
    private List<RecepieStep> steps;

    public Recepie(String name) {
        this.id = -1;
        this.name = name;
        this.steps = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", steps=" + steps +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Recepie recepie = (Recepie) o;
        return id == recepie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
