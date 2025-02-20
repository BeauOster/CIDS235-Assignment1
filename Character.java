public class Character {
  
  private String name;
  private String race;
  private int age;
  private static int numMembers = 0;

  /* Parameterized constructor that initializes the characters.
  @numMembers - A static int. Each time a character (new object) is created the total
  number of members is increased.
  */
  public Character (String name, String race, int age) {

    this.name = name;
    this.race = race;
    this.age = age;
    numMembers++;
    
  }

  // All of below are getters. I think they are all self explanatory.
  public static int getNumMembers() {
    return numMembers;
  }

  public String getName() {
    return name;
  }

  public String getRace() {
    return race;
  }

  public int getAge() {
    return age;
  }

  // All of below are setters. 
  public void setNameOfCharacter(String name) {
    this.name = name;
  }

  public void setRaceOfCharacter(String race) {
    this.race = race;
  }

  public void setAgeOfCharacter(int age) {
    this.age = age;
  }

  /*   Print's out a characters details.
  In main, the user selects a character to view their information.
  This method is then called if they wish to view their information. 
  i.e Frodo.printCharacterDetails
  */
  public void printCharacterDetails() {
    System.out.println("\nName: " + name + "\nRace: " + race + "\nAge: " + age);
  }
  
}