/**
 * 63-ე ამოცანის გაგრძელება, დაბეჭდეთ თითოეული შეყვანილი სახელი და მის გასწვრივ
 * მძიმით გამოყოფილი მეგობრების სია.
 * */

import acm.program.ConsoleProgram;
import java.util.ArrayList;
import java.util.Map;

public class Friends extends ConsoleProgram {
    public void run() {

    }
    void printFriends(Map<String, ArrayList<String>> friends){
        for(String name : friends.keySet()){
            print("Friends of " + name + " are: ");
            ArrayList<String> friendsList = friends.get(name);
            for(int i = 0; i < friendsList.size()-1; i++){
                print(friendsList.get(i) + ", ");
            }
            print(friendsList.get(friendsList.size()-1));
            println();
        }
    }
}
