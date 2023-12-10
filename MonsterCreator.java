import java.util.Scanner;

public class MonsterCreator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

// User input for parent monsters
    System.out.println("Enter traits for Monster 1:");
    Monster monster1 = createMonster(scanner);

    System.out.println("\nEnter traits for Monster 2:");
    Monster monster2 = createMonster(scanner);
//  Creating Baby monster
    Monster babyMonster = Monster.createBabyMonster(monster1, monster2);
    if (babyMonster != null) {
      System.out.println("\nBaby Monster created with inherited traits:");
      babyMonster.displayTraits();
    }
  }

  // Method to create a monster by reading traits from user input
  public static Monster createMonster(Scanner scanner) {
    System.out.println("Enter eye color:");
    String eyeColor = scanner.nextLine();

    System.out.println("Enter feather color:");
    String featherColor = scanner.nextLine();

    System.out.println("Enter magical ability:");
    String magicalAbility = scanner.nextLine();

    System.out.println("Enter size:");
    int size = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Enter strength:");
    int strength = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Enter durability:");
    int durability = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Enter weakness:");
    String weakness = scanner.nextLine();

    System.out.println("Enter aggression level:");
    int aggressionLevel = scanner.nextInt();
    scanner.nextLine();

    // Create and return the monster
    return new Monster(eyeColor, featherColor, magicalAbility,
            size, strength, durability, weakness, aggressionLevel);
  }
}
