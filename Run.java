package gamedua;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {

        Player player = new Player("Sucipto", 5, 300, 50, 0);
        Enemy enemy = new Enemy("Musuh", 5, 300, 50, 0);

        Scanner input = new Scanner(System.in);

        int pilihan, result, maxArmor1 = 0, maxArmor2 = 0;
        
        OUTER:
        while (true) {
            System.out.println("===============================");
            System.out.println("Enemy Name: " + enemy.getName());
            System.out.println("Enemy Health: " + enemy.getHp());
            System.out.println("Enemy Armor: " + enemy.getArmor());
            System.out.println("===============================");
            System.out.println("Your Name: " + player.getName());
            System.out.println("Your Health: " + player.getHp());
            System.out.println("Your Armor : " + player.getArmor());
            System.out.println("===============================");
            System.out.println("Type 1 to attack");
            System.out.println("Type 2 to increase your defense");
            System.out.println("Type 3 to increase run");
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    if (enemy.getArmor() <= player.Attack()) {
                        result = player.Attack();
                        enemy.ReceiveDamage(enemy.getHp() - player.Attack());
                        System.out.println("You attacked the enemy for " + result);
                    } else {
                        result = player.Attack() * player.Attack() / enemy.getArmor();
                        enemy.ReceiveDamage(enemy.getHp() - (player.Attack() * player.Attack() / enemy.getArmor()));
                        System.out.println("You attacked the enemy for " + result);
                    }
                    break;
                case 2:

                    if (maxArmor1 < 3) {
                        player.Defend();
                        System.out.println("You increased your defense to " + player.getArmor());
                        maxArmor1++;
                        break;
                    } else {
                        System.out.println("You can't increase your armor any further");
                        break;
                    }

                case 3:
                    player.Run();
                    if (player.Run() != true) {
                        System.out.println("You failed to run");
                    } else {
                        System.out.println("You successfully ran away");
                        break OUTER;
                    }
                    break;
                default:
                    break;
            }
            switch (enemy.Choice()) {
                case 1:
                    if (player.getArmor() <= enemy.Attack()) {
                        result = enemy.Attack();
                        player.ReceiveDamage(player.getHp() - enemy.Attack());
                        System.out.println("Enemy attacked you for " + result);
                    } else {
                        result = enemy.Attack() * enemy.Attack() / player.getArmor();
                        player.ReceiveDamage(player.getHp() - (enemy.Attack() * enemy.Attack() / player.getArmor()));
                        System.out.println("Enemy attacked you for " + result);
                    }
                    break;
                case 2:

                    if (maxArmor2 < 3) {
                        enemy.Defend();
                        System.out.println("Enemy increased their defense to " + enemy.getArmor());
                        maxArmor2++;
                        break;
                    } else {
                        System.out.println("Enemy failed increasing their armor");
                        break;
                    }

                default:
                    break;
            }
            if (enemy.isDead() == true) {
                System.out.println("You won!");
                break;
            }
            if (player.isDead() == true) {
                System.out.println("git gud");
                break;
            }

        }

    }

}
