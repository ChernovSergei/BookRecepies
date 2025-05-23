package service;

import java.util.List;
import java.util.Objects;

public class RecipeStep {
    private Product product;
    private Tool tool;
    private Action action;
    private List<RecipeStep> subSteps = null;

    public RecipeStep(Product product, Tool tool, Action action) {
        this.product = product;
        this.tool = tool;
        this.action = action;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "service.RecepieStep{" +
                "product=" + product +
                ", tool=" + tool +
                ", action=" + action +
                ", subSteps=" + subSteps +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeStep that = (RecipeStep) o;
        return Objects.equals(product, that.product) && Objects.equals(tool, that.tool)
                && Objects.equals(action, that.action) && Objects.equals(subSteps, that.subSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, tool, action, subSteps);
    }
}
