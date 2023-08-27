# COS101-Java-Course-Feedback-System
//Name & Surname: Sibabalwe Nomvete
//Student No.: 4352145
//Course Feedback System

import java.util.Scanner;

public class CourseFeedbackSystem {
  public static void main(String[] args) {

  System.out.println("This is a program that receives feedback from tertiary students based on the course they take and displays the data received. It allows for registration as well.");

  Scanner keyboard = new Scanner(System.in);

  System.out.println("User ID");
  int userID = keyboard.nextInt();
  System.out.println("Password");
  String passWord = keyboard.next();
  //Login or registration page

  //Main feedback system that reads in feeback from the user about the course
  System.out.println("Name of Course");
  String courseName = keyboard.next();

  System.out.println("Course Rating (1-5)");
  int rateCourse = keyboard.nextInt();

  System.out.println("What did you enjoy about the course?");
  String goodInput = keyboard.next();

  System.out.println("What did you dislike about the course?");
  String badInput = keyboard.next();

  System.out.println("How would you improve the course?");
  String courseFix = keyboard.next();

  }
}  
