public class Runner {

    //TODO: Time estimation skill - estimate required hours for those modifications
    //TODO: Find good book about Refactoring from Ivan
    public static void main(String[] args) {
        ConsoleClient input = new ConsoleClient();
        input.createRecepie();
        input.addRecepieStep();
        input.addRecepieStep();
        input.saveRecepie();
        input.printAllRecepies();
    }
}
