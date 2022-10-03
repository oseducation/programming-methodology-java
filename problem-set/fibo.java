
import acm.program.ConsoleProgram;

public class fibo extends ConsoleProgram {
    private int find_nth_fibonacci(int n){
        if(n < 1)return -1; //n აუცილებლად დადებით უნდა იყოს

        // ვთქვათ ფიბონაჩის მიმდევრობის პირველი წევრია 0 და მეორე 1
        // მაშინ მიმდევრობა გამოიყურება შემდეგნაირად
        // 0 1 1 2 3 5 8 13.... (ზოგადი წევრის ფორმულაა: Fn = F(n-1) + F(n-2))
        int fibo1 = 0;
        int fibo2 = 1;

        //ბეის ქეისები
        if(n == 1)return fibo1;
        if(n == 2)return fibo2;

        //დავთვალოთ იური ფიბონაჩის მიმდევრობის წევრები
        //დაგვჭირდება ცვლადები სადაც შევინახავთ F(n-1) და F(n-2)
        int Fn_1 = fibo2;
        int Fn_2 = fibo1;
        int F_i = -1; // ეს იყოს ცვლადი, რომელსაც დავაბრუნებთ საბოლოოდ

        for(int i = 3; i <= n; i++){
            F_i = Fn_1 + Fn_2;
            //მოვემზადოთ შემდეგი იტერაციისთვის, ანუ F(i-1) გავხადოთ F(i) და F(i-2) გავხადოთ F(i-1)
            //ვინაიდან, თუ F3-ისთვის წინა წევრები იყვნენ F1 და F2
            //F4-ისთვის უკვე წინა ორი წევრი არის F2 და F3
            Fn_2 = Fn_1;
            Fn_1 = F_i;
        }
        return F_i;
    }
    
    private static int sentinel = -1;

    public void run() {
        while (true){
            int n = readInt("enter n ");
            if(n == sentinel)break;
            println("F" + n + " is: " + find_nth_fibonacci(n));
        }
    }
}
