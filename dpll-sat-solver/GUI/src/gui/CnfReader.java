package gui;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CnfReader {
	ArrayList<ArrayList<Integer>> knf;
	
	public CnfReader() {
		knf = new ArrayList<>();
	}
	


    //checks if first character is number or '-'
    public boolean isClause(String line) {

        char c = line.charAt(0);
        return (c <= 57 && c >= 48) || c == '-';
    }

    //converts a string with numbers to a clause(set)
    public ArrayList<Integer> makeLineToClause(String line) {
        ArrayList<Integer> s = new ArrayList<>();

        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(line);
        while (m.find()) {
            int i = Integer.parseInt(m.group());
            if (i != 0) {
                s.add(i);
            }
        }
        return s;
    }

    //adds a clause(set) to the member knf(set)
    public void addToKNF(ArrayList<Integer> s) {
        if (!s.isEmpty()) {
            knf.add(s);
        }
    }

    //returns the member set<HashSet>
    public ArrayList<ArrayList<Integer>> getKNF() {
        return knf;
    }
    
    public ArrayList<ArrayList<Integer>> buildKNF(BufferedReader reader)throws Exception{
        String line = reader.readLine();

            while (line != null) {
                //do sth with the line
                if (isClause(line)) {
                    addToKNF(makeLineToClause(line));
                }
                //read next line
                line = reader.readLine();
            }
            return knf;
    }
    

}

