
/*
 * File: HarmonicMean.java
 * -----------------------
 * Read three integers from the console and print their harmonic mean.
 */

public class HarmonicMean extends ConsoleProgram {
    public void run(){
	int x = readInt("Enter a number: ");
	int y = readInt("Enter a number: ");
	int z = readInt("Enter a number: ");
	println(harMean(x, y , z));
    }
	
/*
* precondition: gets three integer
* --------------------------------
* postcondition: returns their HarmonicMean
*/

private double harMean(int x, int y, int z) {
    double numerator = (double) x * y * z;
    double denominator = (double) y * z + x * z + x * y;
    return numerator/denominator;
    }
}