package com.CodingDojo.maestroDeObjetosII;

public class Samurai extends Human {
	private static int samuraiCount = 0;

	public Samurai() {
		this.health = 200;
		samuraiCount++;
	}

	// GET AND SET
	
	public static int getSamuraiCount() {
		return samuraiCount;
	}

	public static void setSamuraiCount(int samuraiCount) {
		Samurai.samuraiCount = samuraiCount;
	}

	// END GET AND SET

	public void deathBlow(Human target) {
		int targetHealthBefore = target.health;
		target.health = 0;
		this.health /= 2;
		System.out.println("Samurai used Death Blow! Target's health reduced to 0. Samurai's health decreased.");
		System.out.println("Target's health before: " + targetHealthBefore);
		System.out.println("Target's health after: " + target.health);
		System.out.println("Samurai's health after: " + this.health);
	}

	public void meditate() {
		int healingAmount = this.health / 2;
		this.health += healingAmount;
		System.out.println("Samurai meditated and healed. Healing amount: " + healingAmount);
	}

	public static int howMany() {
		return samuraiCount;
	}

}
