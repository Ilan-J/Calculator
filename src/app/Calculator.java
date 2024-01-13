package app;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	
//	private StringProperty expression;
//	private StringProperty result;
	
	private String expression;
	private double result;
	
	
	public Calculator() {
//		this.expression = new SimpleStringProperty("");
//		this.result = new SimpleStringProperty("");
		
		this.expression = "";
		this.result = 0;
	}
	
	public void modifyExpression(String op) {
		
		switch (op) {
    	case "=", "Enter":
    		this.result = Calculator.evaluate(this.expression);
    		break;
    	case "C", "c":
//    		this.expression.set("");
    		this.expression = "";
    		break;
    	case "<-", "Back":
    		if (!this.expression.isEmpty()) {
    			this.expression = this.expression.substring(0, this.expression.length() -1);
    		}
    		break;
    	case "x":
//    		this.expression.set(this.expression.get() + "*");
    		this.expression += "*";
    		break;
    	case "÷":
//    		this.expression.set(this.expression.get() + "/");
    		this.expression += "/";
    		break;
    	case "+", "-", "*", "^", "/", /*"(", ")",*/ ".", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9":
//    		this.expression.set(this.expression.get() + op);
    		this.expression += op;
    		break;
    	default:
    		break;
		}
//		System.out.println(this.expression.get());
		System.out.println(this.expression);
	}

	public static double evaluate(String exp) {
		String num = "";
		List<Double> numPile = new ArrayList<> ();
		List<String> opPile = new ArrayList<> ();
		
		System.out.println("\nDecompose " + exp);
		
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			System.out.println(c);
			
			if (c == '(') {
				int j = exp.indexOf(')');
				evaluate(exp.substring(i + 1, j));
				
			} else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
				opPile.add(String.valueOf(c));
				numPile.add(Double.valueOf(num));
				num = "";
			} else {
				num += String.valueOf(c);
			}
			System.out.println(numPile);
			System.out.println(opPile);
		}
		numPile.add(Double.valueOf(num));
		
		
		System.out.println("\nCalculate");
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j < opPile.size(); j++) {
				String op = opPile.get(j);
				
				if (i == 0) {
					if (op.equals("^")) {
						System.out.println(opPile);
						System.out.println(numPile);
						System.out.println(numPile.get(j) + " ^ " + numPile.get(j + 1));
						System.out.println();
						
						double n = numPile.get(j);
						double expo = numPile.remove(j + 1);
						
						for (int k = 1; k < expo; k++) {
							numPile.set(j, numPile.get(j) * n);
						}
						opPile.remove(j);
						j--;
					}
				} else if (i == 1) {
					if (op.equals("*")) {
						System.out.println(opPile);
						System.out.println(numPile);
						System.out.println(numPile.get(j) + " * " + numPile.get(j + 1));
						System.out.println();
						
						numPile.set(j, numPile.get(j) * numPile.remove(j + 1));
						
						opPile.remove(j);
						j--;
					}
					if (op.equals("/")) {
						System.out.println(opPile);
						System.out.println(numPile);
						System.out.println(numPile.get(j) + " / " + numPile.get(j + 1));
						System.out.println();

						numPile.set(j, numPile.get(j) / numPile.remove(j + 1));
						
						opPile.remove(j);
						j--;
					}
				} else {
					if (op.equals("+")) {
						System.out.println(opPile);
						System.out.println(numPile);
						System.out.println(numPile.get(j) + " + " + numPile.get(j + 1));
						System.out.println();

						numPile.set(j, numPile.get(j) + numPile.remove(j + 1));
						
						opPile.remove(j);
						j--;
					}
					if (op.equals("-")) {
						System.out.println(opPile);
						System.out.println(numPile);
						System.out.println(numPile.get(j) + " - " + numPile.get(j + 1));
						System.out.println();

						numPile.set(j, numPile.get(j) - numPile.remove(j + 1));
						
						opPile.remove(j);
						j--;
					}
				}
			}
		}
		System.out.println(numPile);
		
		return numPile.get(0);
	}
	
	public String getExpression() {
		return this.expression;
	}
	public String getResult() {
		return String.valueOf(this.result);
	}
}
