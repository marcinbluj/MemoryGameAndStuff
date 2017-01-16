package pl.memoryGame.Knight;

/**
 * Created by RENT on 2017-01-14.
 */
public class Knight {
    private Weapon weapon;

    public Knight() {
    }

    public Knight(Weapon weapon) {
        this.weapon = weapon;
    }

    public void fight(){
        System.out.println("Knight is fighting...");
        weapon.use();
    }

    public static void main(String[] args) {
        Weapon weapon = new Sword();
        Knight knight = new Knight(weapon);
        knight.fight();

        Knight knight2 = new Knight(new Axe());
        knight2.fight();

        Knight knight3 = new Knight(() -> System.out.println("Bashing using mace"));
        knight3.fight();
    }
}
