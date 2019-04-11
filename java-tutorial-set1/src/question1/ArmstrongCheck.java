package question1;

import java.util.Scanner;

public class ArmstrongCheck {

	private boolean isArmstrong(int x) {

		int n = order(x);
		int temp = x, sum = 0;
		while (temp != 0) {
			int r = temp % 10;
			sum = sum + power(r, n);
			temp = temp / 10;
		}
		return (sum == x);
	}

	private int order(int x) {
		int n = 0;
		while (x != 0) {
			n++;
			x = x / 10;
		}
		return n;
	}

	private int power(int x, long y) {
		if (y == 0)
			return 1;
		if (y % 2 == 0)
			return power(x, y / 2) * power(x, y / 2);
		return x * power(x, y / 2) * power(x, y / 2);
	}

	public static void main(String[] args) {

		System.out.println("---Armstrong no check---");
		System.out.println("Enter No.");

		Scanner sc = new Scanner(System.in);

		ArmstrongCheck armstrongCheck = new ArmstrongCheck();
		System.out.println("No is Armstrong :- " + armstrongCheck.isArmstrong(sc.nextInt()));

	}
}
