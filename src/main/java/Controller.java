public class Controller {
    private String recepieFormat = "%s the %s with a %s\n";

    public void saveRecepie(Recepie recepie) {
        System.out.println(recepie.getName());
        recepie.getSteps().forEach(e -> {
            String actionName = e.getAction().getName();
            String productName = e.getProduct().getName();
            String toolName = e.getTool().getName();
            System.out.printf (recepieFormat, actionName, productName, toolName);
        });
    }
}
