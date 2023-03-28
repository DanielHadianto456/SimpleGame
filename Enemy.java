package gamedua;

public class Enemy {

    private String name;
    private int speed, hp, damage, armor, EnemyChoice;

    Enemy(String name, int speed, int hp, int damage, int armor) {
        this.name = name;
        this.speed = speed;
        this.damage = damage;
        this.hp = hp;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public int Attack() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }

    public void ReceiveDamage(int newHp) {
        hp = newHp;
    }

    public boolean isDead() {
        if (hp <= 0) {
            return true;
        }
        return false;
    }

    public int Defend() {
        return armor += 30;
    }

    public int Choice() {
        return EnemyChoice = 1 + (int) (Math.random() * ((2 - 1) + 1));
    }
}
