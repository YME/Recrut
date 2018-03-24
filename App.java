import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private List<String> instaFailed;

    public static void setInstaFailed(CSV file){
        List<String> instaFailed = new ArrayList<>();
        List<String> questions = new ArrayList<>(file.getKeys());
        int i=0, choice=-99;
        Scanner input = new Scanner(System.in);

        System.out.println("Assinale as questões que levam a eliminação instantânea\n");
        for(String s : questions){
            System.out.println("["+i+"] "+s);
            i++;
        }

        while(choice != 0){
            System.out.println("(0 para sair)> ");
            choice = input.nextInt();
            if(choice != 0 && choice >= 1 && choice <= i)
             instaFailed.add(questions.get(choice));
        }

    }


}
