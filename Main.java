/*
----------------------------------------------------
Author: Beau Oster
Contact: beau.oster@my.uwrf.edu

Created: 6/13/23
Modified: 6/23/23

Description: 

This is a program for understanding the basics of a "class". The program
is sort of like a wiki that's based off of a character's information
from the movie "The Fellowship of the Ring". There are 9 characters
in total in which you can view or edit their information. This is done
by using basic getters and setters.

--------------------------------------------------------
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    /*
    | @Age,Race,Name - Used for the getter methods in the "Characer" class.
    | @new(Age,Race,Name) - Used for the setter methods in the "Character" class.
    | @doesCharacterExist - used to see if an object exists and has been created.
    */
    Scanner scanner = new Scanner(System.in);
    String userInput;
    String Name;
    String Race;
    String newName;
    String newRace;
    boolean userContinues = true;
    boolean doesCharacterExist = false;
    int selection;
    int Age;
    int newAge;

    // Below initializes all 9 characters using the parameterized "Character"
    // constructor in the "Character" class. Arguments are: Name, Race, Age.
    Character Frodo = new Character("Frodo", "Hobit" , 50);
    Character Samwise = new Character("Samwise", "Hobit", 38);
    Character Merry = new Character("Merry", "Hobit", 36);
    Character Pippin = new Character("Pippin", "Hobit", 28);
    Character Aragorn = new Character("Aragorn", "Man", 87);
    Character Boromir = new Character("Boromir", "Man", 40);
    Character Legolas = new Character("Legolas", "Elf", 2000);
    Character Gimli = new Character("Gimli", "Dwarf", 139);
    Character Gandalf = new Character("Gandalf", "Wizard", 2000);

    /* Creates a blank object with no reference. Does not refer to any
    character object. I don't know if this is better than a default
    constructor, but it works for what I'm about to do. */
    Character selectedCharacter = null;

    // An array of objects that holds references to "Character" objects.
    Character[] characters = {Frodo, Samwise, Merry, Pippin, Aragorn, Boromir, Legolas, Gimli, Gandalf};

  //-----------------------BEGIN USER SELECTION LOOP--------------------

    
    while (userContinues) {

      // Introduces my wiki. Tells the user how many current characters there are
      // using the getter method "getNumMembers"
      System.out.println("\nWelcome to the LOTR fellowship wiki!" +
                         " Here you can look up any character that is a part of the Fellowship.");
      System.out.println("\nThere are a total of " + Character.getNumMembers() + " characters!");
      System.out.println("Enter a characters name to get started.");
      userInput = scanner.nextLine();

      /* This is a "for each loop", but with objects instead.
      It itterates over every element in the "characters" array.
      The current element in the array is referenced to the "currentArrayElement"
      object for each iteration.
      i.e currentArrayElement(Name,Race,Age) = current element in the array.*/
      for (Character currentArrayElement : characters) {

        // Checks to see if the "name" of the current object in the loop equals
        // the name the user inputed. This is done using the getter "getName".
        if (currentArrayElement !=null && currentArrayElement.getName().equalsIgnoreCase(userInput)) {

          // If true, the "selectedCharacter" object is assigned a reference
          // of the "currentArrayElement". It then breaks the for loop.
          selectedCharacter = currentArrayElement;
          doesCharacterExist = true;
          break;
          
        } else {
          doesCharacterExist = false;
        }
        
      } // End for loop

      // Starts the while loop over again if a character does not exist.
      if (!doesCharacterExist) {
        System.out.println("\nCharacter does not exist. Please try again.");
        continue;
      }

      // Below displays a menu to the user and what they can do with a character.
      System.out.println("\nYou have entered the character " + selectedCharacter.getName());
      System.out.println("\nPlease select an option below to display character information\n");
      System.out.println("1. View character details\n" + 
                         "2. Get character's name\n" + 
                         "3. Get character's age\n" +
                         "4. Get character's race\n" + 
                         "5. Set character's name\n" + 
                         "6. Set characer's age\n" + 
                         "7. Set character's race\n" +
                         "8. Quit");

      /* THIS HAS TO BE .parseInt AND NOT .nextInt.
      Doing .nextInt will break the entire program. I don't know why,
      but just note this is why I'm parsing. */
      selection = Integer.parseInt(scanner.nextLine());

      switch (selection) {

          // Prints character details of current selected object.
          case 1: 
            selectedCharacter.printCharacterDetails();
            break;

          // Gets the name of the current character and displays.
          case 2:
            Name = selectedCharacter.getName();
            System.out.println("Character Name: " + Name);
            break;
          
          // Gets the age of the current character and displays.
          case 3:
            Age = selectedCharacter.getAge();
            System.out.println("Character Age: " + Age);
            break;

          // Gets the race of the current character and displays.
          case 4:
            Race = selectedCharacter.getRace();
            System.out.println("Character Race: " + Race);
            break;

          /* Below is the setter for setting a new name.
          I don't know if this is how I am suppose to use the setters, but hopefully
          this is suffice for you. */
          case 5:
            boolean doesNameExist = false;

            /* This "do-while" loop is needed because each name of the characters
            needs to be unique. For example, you can't have 2 characters
            with the name "Frodo". If the name alraedy exists, the user will
            be prompted again. Having 2 of the same name is like dividing by 0.
            I have no idea how to fix this. */
            do {
              
               System.out.println("Enter a new name:");
               newName = scanner.nextLine();

               // This is another identical "for-each" loop much like the one earlier.
               for (Character currentArrayElement: characters) {
              
                 if (currentArrayElement !=null && currentArrayElement.getName().equalsIgnoreCase(newName)) {
                 doesNameExist = true;
                 System.out.println("Name already exists. Enter a different name.");
                 break;

                 // Sets the name of the current selected character if the
                 // new name doesn't already exist.
                 } else {
                 selectedCharacter.setNameOfCharacter(newName);
                 doesNameExist = false;
                 }
                
               }
              
            } while (doesNameExist);
          
            break;

          // Sets a new age of a character.
          case 6:
            System.out.println("Enter a new age:");
            newAge = Integer.parseInt(scanner.nextLine());
            selectedCharacter.setAgeOfCharacter(newAge);
            break;

          // Sets the new race of a character.
          case 7:
            System.out.println("Enter a new race:");
            newRace = scanner.nextLine();
            selectedCharacter.setRaceOfCharacter(newRace);
            break;

          // Exits the while loop.
          case 8:
            System.out.println("Thanks for using Beau's wiki!");
            userContinues = false;
            break;
          
          default:
            System.out.println("Error: Please enter a correct option.");
          
      }
      
    } // End while loop

    
  }
}