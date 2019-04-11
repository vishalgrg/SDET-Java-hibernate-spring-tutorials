package question3;

import java.util.Scanner;

public class BinaryNoCheck {

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
		System.out.println("Binary no check");
		System.out.print("Enter no: ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		BinaryNoCheck binaryNoCheck = new BinaryNoCheck();
		System.out.println("Number is Binary:-" + binaryNoCheck.isBinaryNumber(input));
	}

}
