package assignment06;

public class Thing {
    private int HP;
    private int damage;

    public Thing(int HP, int damage) {
        this.HP = HP;
        this.damage = damage;
    }

    public void takeDamage(int damage) {
        this.HP -= damage;
    }

    public void attack(Thing other) {
        other.takeDamage(this.damage);
    }

    public int getHP() {
        return this.HP;
    }
}
