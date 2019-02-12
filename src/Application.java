import java.util.Random;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// system objects
		Scanner userInput = new Scanner(System.in);
		Random rand = new Random();

		// game variables
		String[] enemies = { "Skeleton", "Zombie", "Warrior", "Knight", "Wolf", "Bat", "Vampire", "Brute" };
		int enemyMaxHealth = 75;
		int enemyAttack = 35;

		// player
		int playerHealth = 100;
		int playerAttack = 50;
		int inventoryHealthPotions = 3;
		int HealthPotionHealingPoints = 30;
		int healthPotionDropRate = 20;

		boolean running = true;

		System.out.println("Welcome to the Dungeon");

		GAME: while (running) {
			System.out.println("---------------------------------");

			int enemyHealth = rand.nextInt(enemyMaxHealth);
			// this command grabs a random value out of array enemies
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " appeared! #\n");
			if (!userInput.equals("3")) {
				while (enemyHealth > 0) {
					System.out.println("\tYour HP " + playerHealth);
					System.out.println("\tEnemy HP " + enemyHealth);
					System.out.println("\n\tWhat would you like to do?");

					// this should be a switch statement
					System.out.println("\t1. Attack");
					System.out.println("\t2. Drink health potion");
					System.out.println("\t3. Run!");

					String input = userInput.nextLine();
					if (input.equals("1")) {
						int damageDealt = rand.nextInt(playerAttack);
						int damageTaken = rand.nextInt(enemyAttack);
						enemyHealth -= damageDealt;
						playerHealth -= damageTaken;

						System.out.println("\t> Your strike the " + enemy + " for " + damageDealt);
						System.out.println("\t> Your receive " + damageTaken);

						if (playerHealth < 1) {
							System.out.println("You have taken too much damage, you fall in battle");
							break;
						}
						if (enemyHealth < 1) {
							System.out.println("---------------------------------");
							System.out.println(" # " + enemy + " was defeated!");
							System.out.println(" # You have " + playerHealth + " HP");
							if (rand.nextInt(100) < healthPotionDropRate)
								;
							{
								inventoryHealthPotions++;
								System.out.println(" # You pick up a potion!");
								System.out.println(" # You have " + inventoryHealthPotions + " potions");
							}

						}
					} else if (input.equals("2")) {
						if (inventoryHealthPotions > 0) {
							playerHealth += HealthPotionHealingPoints;
							inventoryHealthPotions--;
							System.out.println("You feel rejuvinated");
						} else {
							System.out.println("You are out of potions");
						}

					} else if (input.contentEquals("3")) {
						System.out.println("You are a coward");
						break;

					} else {
						System.out.println("Please enter a valid command");
					}
				} // end while loop

			}
			if (playerHealth < 1) {
				System.out.println("Game Over");
				break;
			}

			// end of game
			System.out.println("What would you like to do?");
			System.out.println("1. Continue.");
			System.out.println("2. Exit Game");

			String input = userInput.nextLine();
			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid Command");
				input = userInput.nextLine();
			}
			if (input.equals("1")) {
				System.out.println("You Continue on the adventure");
			} else {
				System.out.println("You exit the dungeon.");
				break;
			}
		} // end game loop
		System.out.println("###################");
		System.out.println("Thanks for playing!");
		System.out.println("###################");
	}
}
