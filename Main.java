package pt.yme;


public class Main {

    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Proper Usage is: java program filename");
            System.exit(0);
        }


        CSV kek = new CSV("/");

    }
}
