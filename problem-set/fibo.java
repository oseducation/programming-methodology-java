import acm.program.ConsoleProgram;
// მომხმარებელს შემოყავს n რიცხვი და ჩვენ უნდა დავუბრუნოთ მას ფიბონაჩის მიმდევრობის მეენე რიცხვი

public class Fibo extends ConsoleProgram {
    private int find_nth_fibonacci(int n){
        if(n < 1)return -1; //n აუცილებლად დადებით უნდა იყოს

        // ვთქვათ ფიბონაჩის მიმდევრობის პირველი წევრია 0 და მეორე 1
        // მაშინ მიმდევრობა გამოიყურება შემდეგნაირად
        // 0 1 1 2 3 5 8 13.... (ზოგადი წევრის ფორმულაა: Fn = F(n-1) + F(n-2))

        //ბეის ქეისები
        if(n == 1)return 0;
        if(n == 2)return 1;

        //დავთვალოთ იური ფიბონაჩის მიმდევრობის წევრები
        //დაგვჭირდება ცვლადები სადაც შევინახავთ F(n-1) და F(n-2)
        int fn_1 = 1;
        int fn_2 = 0;
        int f_i = -1; // ეს იყოს ცვლადი, რომელსაც დავაბრუნებთ საბოლოოდ

        for(int i = 3; i <= n; i++){
            f_i = fn_1 + fn_2;
            //მოვემზადოთ შემდეგი იტერაციისთვის, ანუ F(i-1) გავხადოთ F(i) და F(i-2) გავხადოთ F(i-1)
            //ვინაიდან, თუ F3-ისთვის წინა წევრები იყვნენ F1 და F2
            //F4-ისთვის უკვე წინა ორი წევრი არის F2 და F3
            fn_2 = fn_1;
            fn_1 = f_i;
        }
        return f_i;
    }
    
    private static int sentinel = -1;

    public void run() {
        int n = readInt("enter n: ");
        println("F" + n + " is: " + find_nth_fibonacci(n));
    }
}
