public class Player {
    String name;
    int health;
    int weaponDamage;
    int digPower;
    int cigarettes;
    Card[] cards;
    Board board;
    Room currentRoom;

    public Player(){
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getHealth(){
        return this.health;
    }
    public int getWeaponDamage() {
        return weaponDamage;
    }
    public int getDigPower() {
        return digPower;
    }
    public int getCigarettes() {
        return cigarettes;
    }
    public Board getBoard() {
        return board;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
    public void setDigPower(int digPower) {
        this.digPower = digPower;
    }
    public void setCigarettes(int cigarettes) {
        this.cigarettes = cigarettes;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void drawCards(){
        if (this.cards.length < 10){
            //draw cards;
        }else {
            //you cant draw cards
        }
    }
    public void attack(Player enemy){
        throw new UnsupportedOperationException("Not implemented yet!");
    }
    public void heal(int amount){
        if (this.health < 3){
            this.health += amount;
        }else {
            // u cant be healed;
        }
    }
    public void buy(int cigaretessAmount){
        throw new UnsupportedOperationException("Not implemented yet!");
    }
    public void sell(){
        throw new UnsupportedOperationException("Not implemented yet!");
    }
    public void craft(){
        throw new UnsupportedOperationException("Not implemented yet!");
    }


    public static void main(String[] args) {

    }

}



