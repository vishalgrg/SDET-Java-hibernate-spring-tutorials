package question2;

import java.util.Scanner;

public class BinaryToDecimalCon {

	private int convert(int n) {
		int num = n;
		int dec_value = 0;

		int base = 1;

		int temp = num;
		while (temp > 0) {
			int last_digit = temp % 10;
			temp = temp / 10;
			dec_value += last_digit * base;

			base = base * 2;
		}

		return dec_value;
	}

	public boolean isBinaryNumber(int binary) {

		boolean status = true;
		while (true) {
			if (binary == 0) {
				break;
			} else {
				int tmp = binary % 10;
				if (tmp > 1) {
					status = false;
					break;
				}
				binary = binary / 10;
			}
		}
		return status;
	}

	public static void main(String[] args) {
		BinaryToDecimalCon binaryToDecimalCon = new BinaryToDecimalCon();

		System.out.println("Binary to decimal convertion");
		System.out.print("binary no: ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if (binaryToDecimalCon.isBinaryNumber(input)) {
			System.out.println("decimal value : " + binaryToDecimalCon.convert(input));
		} else {
			System.out.println("Not valid binary number");
		}

	}

}
