public class Runner {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createReceipe();
        controller.addRecepieStep(controller.createRecepieStep());
        controller.saveRecepie();
    }
}
