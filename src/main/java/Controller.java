public class Controller {

    public void saveRecepie(Recepie recepie) {
        System.out.println(recepie.getName());
        recepie.getSteps().forEach(e -> System.out.println ( e.getAction().getName() + " the " + e.getProduct().getName() + " with a " + e.getTool().getName()));
    }
}
