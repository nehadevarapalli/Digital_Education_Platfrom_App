/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;


/**
 *
 * @author arnav
 */


public class Persons {

  final private ArrayList<Person> persons;


  public Persons() {
    this.persons = new ArrayList<>();
  }

  public ArrayList<Person> getPersons() {
    return persons;
  }

  public void add(Person person) {
    persons.add(person);
  }
   public void delete(Person person) {
    persons.remove(person);
  }
    public void update(int nuId,Person person) {
    persons.set(nuId, person);
  }

}

