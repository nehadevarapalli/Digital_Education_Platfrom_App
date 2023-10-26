/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author arnav
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Degree {

    HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
    private int codeCounter = 0;

    public Degree() {
        addDegree("Information Systems");
        addDegree("Computer Science");
        addDegree("Mathematics");
        addDegree("Physics");
        addDegree("Biology");
    }

    private void addDegree(String degreeName) {
        ArrayList<Integer> codes = new ArrayList<>();
        for (int i = codeCounter; i < codeCounter + 8; i++) {
            codes.add(i);
        }
        codeCounter += 8;
        hashMap.put(degreeName, codes);
    }
}
