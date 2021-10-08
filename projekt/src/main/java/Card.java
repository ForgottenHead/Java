public class Card {
    protected String name;
    protected String description;
    protected int value;
    protected String color;
    protected int weaponDamage;
    protected int digPower;

    public Card(String name, String description, String color){
        this.name=name;
        this.description = description;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public int getDigPower() {
        return digPower;
    }
}
