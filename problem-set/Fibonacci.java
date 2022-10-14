/*
 * File: Fibonacci.java
 * ---------------------------------
 * მოხმარებელს შეყავს მთელი რიცხვი n, პროგრამამ უნდა დაბეჭდოს ფიბონაჩის მიმდევრობის მე n წევრი.
 */

import acm.program.*;

public class ConsoleProgrammSample extends ConsoleProgram {

	public void run() {
        //Reading n from console.
        int n = readInt("Enter n: ");
        //n should be positive, because element indexes start from 1.
        if(n <= 0){
            println("There is no n-th element in fibonnaci sequence");
            return;
        }
	//Initializing variables, where firstNum is fibonacci[n-2] and secondNum is fibonacci[n-1]
	//in fibonacci[n] = fibonacci[n-2] + fibonacci[n-1] formula.
	//0 and 1 are fibonacci sequence starting elements.
	int firstNum = 0;
	int secondNum = 1;
	//If we want first element, there is no operations need to generate it.
	if(n == 1){
	    println(0);
            return;
	}
        //Starting generating numbers from third element to n.
        for(int i = 3; i <= n; i++){
            int newNumber = firstNum + secondNum;
            //Shifting numbers on left.
            firstNum = secondNum;
            secondNum = newNumber;
        }
        //Printing the most right generated element.
        println(secondNum);      
	}
    
}
