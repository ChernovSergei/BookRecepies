package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recipe {
    private int id;
    private String name;
    private List<RecipeStep> steps;

    public Recipe(String name) {
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

    public List<RecipeStep> getSteps() {
        return steps;
    }

    public void setSteps(List<RecipeStep> steps) {
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
        Recipe recepie = (Recipe) o;
        return id == recepie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
