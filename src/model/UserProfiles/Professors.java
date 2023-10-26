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
public class Professors {

  public ArrayList<Professor> professors;
  
  public Professors() {
      professors = new ArrayList<Professor>();
  }
  
  public ArrayList<Professor> getProfessors() {
    return professors;
  }

  public void add(Professor professor) {
    professors.add(professor);
  }
   public void delete(Professor professor) {
    professors.remove(professor);
  }
    public void update(int code,Professor professor) {
    professors.set(code, professor);
  }

}
