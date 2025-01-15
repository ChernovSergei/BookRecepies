public class Runner {
    //TODO Delete callback methods between UI and controller. UI and controller must be separated as it was in commit dated by 25 December 2024
    //TODO Identify if workspace.xml have to be deleted from GIT monitor
    //TODO refactor Controller methods trySaveRecepie() and getAllRecepies()
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createReceipe();
        controller.addRecepieStep(controller.createRecepieStep());
    }
}
