package gui;

import java.util.ArrayList;

public class SatSolverRekursiv {
  public static int rek_counter = 0;

  public static boolean DPLL(ArrayList<ArrayList<Integer>> F) {

    for (int i = 0; i < F.size(); i++) {
      if (F.get(i).size() == 1) {
        int L = F.get(i).get(0);
        // System.out.println("Klauselmenge vor simplify: " + F);
        // System.out.println("Simplify mit Literal " + L);
        F = simplify(F, L);
        i = -1;
        // System.out.println("Klauselmenge nach simplify: " + F);
      }
    }

    // System.out.println("keine Unit-Klausel vorhanden");

    if (F.isEmpty()) {
      // System.out.println("Leere Klauselmenge");
      return true;
    }

    for (ArrayList<Integer> clause : F)
      if (clause.isEmpty()) {
        // System.out.println("Leere Klausel");
        return false;
      }

    int L = F.get(0).get(0);

    // System.out.println("Rekursionsschritt mit " + L);

    if (DPLL(simplify(F, L))) {
      rek_counter++;

      return true;
    } else {
      // System.out.println("Rekursionsschritt mit " + (-L));
      rek_counter++;

      return DPLL(simplify(F, -L));
    }
  }

  public static ArrayList<ArrayList<Integer>> simplify(ArrayList<ArrayList<Integer>> F, int L) {

    ArrayList<ArrayList<Integer>> FStrich = new ArrayList<>();
    for (ArrayList<Integer> clause : F)
      if (!clause.contains(L))
        FStrich.add(clause);
    // System.out.println("FStrich "+ FStrich);
    ArrayList<ArrayList<Integer>> FStrichStrich = new ArrayList<>();

    for (ArrayList<Integer> clause : FStrich) {
      ArrayList<Integer> clauseStrich = new ArrayList<>();
      for (int literal : clause) {
        if (literal != -L)
          clauseStrich.add(literal);
      }
      FStrichStrich.add(clauseStrich);
    }
    // System.out.println("FStrichStrich: " + FStrichStrich);
    return FStrichStrich;
  }

}
