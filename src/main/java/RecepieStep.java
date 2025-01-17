import java.util.List;

public class RecepieStep {
    private Product product;
    private Tool tool;
    private Action action;
    private List<RecepieStep> subSteps = null;

    public RecepieStep(Product product, Tool tool, Action action) {
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
        return "RecepieStep{" +
                "product=" + product +
                ", tool=" + tool +
                ", action=" + action +
                ", subSteps=" + subSteps +
                '}';
    }
}
