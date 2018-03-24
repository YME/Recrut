import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class CSV {
    private HashMap<String, ArrayList<String>> questions;
    private ArrayList<String> keys;
    private final int nquestions;

    public  CSV(String csvFile){
        this.keys = new ArrayList<String>();
        this.questions = new HashMap<String, ArrayList<String>>();

        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

        boolean isHeader = true;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] formatado = line.split(cvsSplitBy);
                if (isHeader) {
                    for (String s : formatado) {
                        this.questions.put(s, new ArrayList<>());
                        this.keys.add(s);
                    }
                    isHeader = false;
                }else{
                    int questao=0;
                    for(String resposta : formatado)
                        this.questions.get(keys.get(questao++)).add(resposta);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.nquestions = this.keys.size();
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // getters
    // no need for setters yet

    public HashMap<String, ArrayList<String>> getQuestions(){
        HashMap<String, ArrayList<String>> _questions;
        _questions = new HashMap<String, ArrayList<String>>();

        this.questions.forEach((k,v) -> _questions.put(k, new ArrayList<String>(v)));

        return _questions;
    }

    public int getNquestions() { return nquestions; }

    public ArrayList<String> getKeys() {
        return new ArrayList<>(keys);
    }
}