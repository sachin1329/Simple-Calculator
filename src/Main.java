import java.util.Scanner;

public class Main {
	
	Scanner sc = new Scanner(System.in);
	Scanner op = new Scanner(System.in);
	
	public float answer;
	public int factorial;
	public boolean didWork = true;
	public int[] fibonacci = new int[10];
	public int j = 2;
	public int result;
	
	public Main() {
		System.out.println("Your First Number: ");
		float firstNumber = sc.nextInt();
		System.out.println("Your operator: ");		
		String operator = op.nextLine();
		System.out.println("Loading...");
		
		//special cases for one number operators
		if (operator.equals("!")) {
			answer = (int)getFactorial(firstNumber);
			didWork = false;
			System.out.println((int)firstNumber + "!" + " = " + (int)answer);
			return;
			
		}else if (operator.equals("sqrt")) {
			answer = (float)Math.sqrt(firstNumber);
			didWork = false;
			System.out.println(firstNumber + " sqrt" + " = " + answer);
			return;
			
		} else if (operator.equals("fib")) {
			answer = getFibonacci((int)firstNumber);
			didWork = false;
			System.out.println("The " + (int)firstNumber + " place in the fibonacci sequence is " + (int)answer);
			return;
		} else if(operator.equals("prime")) {
			answer = isPrime((int)firstNumber);
			didWork = false;
			if(result == 1) {
				System.out.println("not prime");
				return;
			}else {
				System.out.println("yes prime");
				return;
			}

		}
		//end of special cases
		
		
		System.out.println("Your Second Number: ");
		float secondNumber = sc.nextInt();
		
		switch(operator) {
		
		case "+" :
			answer = firstNumber + secondNumber;
			break;
		
		case "-":
			answer = firstNumber - secondNumber;
			break;
		
		case "*": 
			answer = (int)getMultiply(firstNumber, secondNumber);
			break;
			
		case "/":
			answer = firstNumber / secondNumber;
			break;
			
		case "^":
			answer = (int)getPower(firstNumber, secondNumber);
			break;

		default:
			System.out.println("That is not a valid operator");
			didWork = false;
			break;
		}
		
		if(didWork)
			System.out.println("Loaded");
			System.out.println(firstNumber + operator + secondNumber + " = " + answer);
	}
	
	//factorial
	public float getFactorial(float n) {
		if(n == 1) return 1;
		else if(n == 0) return 1;
		else 
			return  n * getFactorial(n-1);
	}
	
	//fast adding (multiplying)
	public float getMultiply(float number1, float number2) {
		if (number2 == 1) return number1;
		 else if (number2 == 0) return 0;
		 else {
			 return number1 + getMultiply(number1, number2 - 1);
		 }
		
	}
	
	//fast multiplying (power)
	public float getPower(float number1, float number2) {
		 if (number2 == 1) return number1;
		 else if (number2 == 0) return 0;
		 else {
			 return number1 * getPower(number1, number2 - 1);
		 }
	}

	// get the 'nth' place of fibonacci sequence
	public int getFibonacci(int n) {
		//if place of sequence is one or two then return 1
		//fib sequence: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, ...
		
		if (n == 1 || n == 2) return 1;
		else {
			//recursion
			return getFibonacci(n-1) + getFibonacci(n-2);
 		}

	}
	
	//
	public float isPrime(int n) {
		while (j < n && result != 1){
			if( n % j == 0) {
				result = 1; 
			}
				j++;
		}
		
		if(result == 1) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		new Main();
		
	}
	
}
