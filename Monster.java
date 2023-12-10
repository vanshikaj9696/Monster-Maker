import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Random;

public class Monster {
  private String eyeColor;
  private String featherColor;
  private String magicalAbility;
  private int size;
  private int strength;
  private int durability;
  private String weakness;
  private int aggressionLevel;
  public String getEyeColor() {
    return eyeColor;
  }
  public void setEyeColor(String eyeColor) {
    this.eyeColor = eyeColor;
  }
  public String getFeatherColor() {
    return featherColor;
  }
  public void setFeatherColor(String featherColor) {
    this.featherColor = featherColor;
  }
  public String getMagicalAbility() {
    return magicalAbility;
  }
  public void setMagicalAbility(String magicalAbility) {
    this.magicalAbility = magicalAbility;
  }
  public int getSize() {
    return size;
  }
  public void setSize(int size) {
    this.size = size;
  }
  public int getStrength() {
    return strength;
  }
  public void setStrength(int strength) {
    this.strength = strength;
  }
  public int getDurability() {
    return durability;
  }
  public void setDurability(int durability) {
    this.durability = durability;
  }
  public String getWeakness() {
    return weakness;
  }
  public void setWeakness(String weakness) {
    this.weakness = weakness;
  }
  public int getAggressionLevel() {
    return aggressionLevel;
  }
  public void setAggressionLevel(int aggressionLevel) {
    this.aggressionLevel = aggressionLevel;
  }
// Constructor
  public Monster(String eyeColor, String featherColor, String magicalAbility,
                 int size, int strength, int durability, String weakness,
                 int aggressionLevel) {
    this.eyeColor = eyeColor;
    this.featherColor = featherColor;
    this.magicalAbility = magicalAbility;
    this.size = size;
    this.strength = strength;
    this.durability = durability;
    this.weakness = weakness;
    this.aggressionLevel = aggressionLevel;
  }

  public static Monster createBabyMonster(Monster parent1, Monster parent2) {
    try {
      Constructor<Monster> constructor = Monster.class.getDeclaredConstructor(
              String.class, String.class, String.class,
              int.class, int.class, int.class, String.class,
              int.class);
      constructor.setAccessible(true); // Allow access to private constructor
      Random random = new Random();
      Object[] args = new Object[8];
      Field[] fields = Monster.class.getDeclaredFields();

      for (Field field : fields) {
        field.setAccessible(true);
        Object value;
        if (random.nextBoolean()) {
          value = field.get(parent1);
        } else {
          value = field.get(parent2);
        }
        args[fieldIndex(field)] = value;
      }

      return constructor.newInstance(args);
    } catch (ReflectiveOperationException e) {
      e.printStackTrace();
      return null;
    }
  }
// Helper method to get the index of the field for constructor arguments
  private static int fieldIndex(Field field) {
    switch (field.getName()) {
      case "eyeColor":
        return 0;
      case "featherColor":
        return 1;
      case "magicalAbility":
        return 2;
      case "size":
        return 3;
      case "strength":
        return 4;
      case "durability":
        return 5;
      case "weakness":
        return 6;
      case "aggressionLevel":
        return 7;
      default:
        return -1; // Invalid field
    }
  }
//  Method to display traits
  public void displayTraits() {
    System.out.println("Eye Color: " + this.eyeColor);
    System.out.println("Feather Color: " + this.featherColor);
    System.out.println("Magical Ability: " + this.magicalAbility);
    System.out.println("Size: " + this.size);
    System.out.println("Strength: " + this.strength);
    System.out.println("Durability: " + this.durability);
    System.out.println("Weakness: " + this.weakness);
    System.out.println("Aggression Level: " + this.aggressionLevel);
  }
}