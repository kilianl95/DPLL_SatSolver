package gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Model {
    CnfReader cnf;

    public Model() {

    }

    public int getRekCounter() {
        return SatSolverRekursiv.rek_counter;
    }

    public ArrayList<ArrayList<Integer>> getKNF(String path) throws Exception {

        cnf = new CnfReader();

        FileReader fr = new FileReader(path);
        BufferedReader reader = new BufferedReader(fr);

        ArrayList<ArrayList<Integer>> knf = cnf.buildKNF(reader);

        reader.close();

        return knf;
    }

    public boolean knfSatisfiable(ArrayList<ArrayList<Integer>> knf) {

        if (SatSolverRekursiv.DPLL(knf)) {
            return true;

        } else {
            return false;

        }

    }

}
