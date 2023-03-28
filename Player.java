package gamedua;


public class Player {
    
    private String name;
    private int speed, hp, damage, armor, run;
    
    Player(String name, int speed, int hp,int damage, int armor){
        this.name = name;
        this.speed = speed;
        this.hp = hp;
        this.damage = damage;
        this.armor = armor;
    }
    
    public String getName(){
        return name;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public int getHp(){
        return hp;
    }
    
    public int Attack(){
        return damage;
    }
    
    public int getArmor(){
        return armor;
    }
    
    public void ReceiveDamage(int newHp){
        hp = newHp;
    }
    
    public boolean isDead(){
        if(hp <= 0) return true;
        return false;
    }    
    
    public int Defend() {
        return armor += 30;
    }
    
    public int RunChance(){
        return run = 1 + (int) (Math.random() * ((10 - speed) + 1));
    }
    
    public boolean Run(){
        if(RunChance() == 10 - speed) return true;
        return false;
    }
    
}
