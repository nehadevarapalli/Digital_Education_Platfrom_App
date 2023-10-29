/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.userProfiles;

import java.util.ArrayList;

/**
 *
 * @author arnav
 */
public class Employers {
    private ArrayList<Employer> employers;
    
    public Employers() {
        employers = new ArrayList<>();
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(ArrayList<Employer> employers) {
        this.employers = employers;
    }
    
    public void populate() {
        
    }
}
