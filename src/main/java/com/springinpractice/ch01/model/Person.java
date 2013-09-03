package com.springinpractice.ch01.model;

public class Person {

  private String firstName;
  private String lastName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return super.toString() + "person object - [firstName: " + firstName + ", lastName: " + lastName + "]";
  }
}
