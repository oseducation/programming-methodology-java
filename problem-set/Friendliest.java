
/**
 კონსოლიდან შეგვყავს წყვილ-წყვილად მეგობრების სახელები, მანამ სანამ არ შევიყვანთ
 ცარიელ სტრინგს. დაბეჭდეთ იმ ადამიანის სახელი ვისაც ჰყავს ყველაზე მეტი მეგობარი.
 მეგობრობა შეიძლება იყოს ცალმხრივი. თუკი შევიყვანთ A-ს და B-ს, ეს ნიშნავს, რომ A არის
 B-ს მეგობარი, მაგრამ B შეიძლება არ იყოს A-ს მეგობარი.
 */

import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Friendliest extends ConsoleProgram {

    public void run() {
        Map<String, ArrayList<String>> friends = new HashMap<>();
        getInput(friends);
        int friendsMaxNum = getMaxFriendNum(friends);
        printPeopleWithNFriends(friends, friendsMaxNum);
    }

    void printPeopleWithNFriends(Map<String, ArrayList<String>> friends, int N){
        for (String name : friends.keySet()) {
            if (friends.get(name).size() == N){
                println(name);
            }
        }
    }

    int getMaxFriendNum(Map<String, ArrayList<String>> friends){
        int res = -1;
        for (String name : friends.keySet()){
            res = Math.max(res, friends.get(name).size());
        }
        return res;
    }

    void getInput(Map<String, ArrayList<String>> friends){
        while (true) {
            String read = readLine("Enter names: ");
            if(read.equals("")) break;
            StringTokenizer st = new StringTokenizer(read);
            String A = st.nextToken();
            String B = st.nextToken();

            if (friends.containsKey(B)){
                friends.get(B).add(A);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(A);
                friends.put(B, newList);
            }
        }
    }
}
