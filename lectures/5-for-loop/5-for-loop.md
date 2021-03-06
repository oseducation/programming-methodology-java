# FOR ციკლი
ხშირად არის სიტუაცია, როდესაც გინდა ბრძანებების რაღაც მიმდევრობა რამდენჯერმე გაიმეორო. იმის მაგივრად, რომ copy/paste გააკეთო შეგიძლია for ციკლი გამოიყენო.

როგორც აქამდე ვთქვი, კოდის გამეორება და copy/paste ძალიან ცუდი იდეაა პროგრამის წერის დროს. ამ დროს პროგრამაში ჩნდება ორ ან უფრო მეტ ადგილზე ერთიდაიგივე კოდი. კოდის გამეორება არ არის სასურველი, ერთი იმიტომ, რომ ზედმეტია და არ არის საჭირო, მეორე იმიტომ რომ შეცდომების წყაროა. როდესაც ერთიდაიგივე კოდი 10-ჯერ გაქვს გადაკოპირებული და აღმოჩნდა, რომ ეს კოდი შესაცვლელია. უნდა ჩამოუარო ათივე ადგილს და ყველგან შეცვალო. თუკი რომელიმე ადგილი დაგავიწყდა, პროგრამა აღარ იქნება გამართული. იმ შემთხვევაში კი, როდესაც კოდის გამეორება არ გაქვს ცვლილებებიც მარტივი შესატანია და შეცდომებსაც არ იწვევს. 

მივუბრუნდეთ for ციკლს. დავუშვათ, კარელი 100 სიგრძის სამყაროში ცხოვრობს, ახლა არის პირველი გამზირის პირველ ქუჩაზე, ანუ (1,1) კოორდინატებზე და უნდა აიღოს ბრილიანტი, რომელიც მდებარეობს მეასე გამზირის პირველ ქუჩაზე, ანუ (100,1) კოორდინატებზე.  რა უნდა ამის გაკეთებას `move();`-ს დაწერ 99-ჯერ მერე ერთ `pickBeeper();`-ს და ეგაა მთელი პროგრამა. მაგრამ 100-ჯერ `move();`-ის კოპირება კაი შრომატევადი საქმეა. 10000 სიგრძის სამყარო რომ იყოს? ან რომ გამოგრჩეს ერთი `move();` ან ზედმეტი დავწერო? მოკლედ საწვალებელია. თუმცა კარგი ამბავი ის არის, რომ არსებობს სპეციალური ინსტრუქცია - `for ციკლი` რომელიც საშუალებას მოგცემს ერთი ინსტრუქცია ან ინსტრუქციების მიმდევრობა იმდენჯერ გაიმეორო რამდენჯერაც გინდა. 

```java
for (int i = 0; i < რაოდენობა; i++) {
    ბრძანებები რომელთა გამეორებაც გვინდა
}
```

`for ციკლი`, ისევე როგორც მეთოდი, შედგება ორი ნაწილისგან. `for ციკლის` თავისგან და `for ციკლის` ტანისგან. `for ციკლის` თავში ერთადერთი რისი შეცლვაც შეგიძლია არის `რაოდენობა`, რომელიც აღნიშნავს თუ რამდენჯერ გინდა გაიმეორო `for ციკლის` ტანში არსებული ინსტრუქციების მიმდევრობა. კოდის დანარჩენი ნაწილი შეუცვლელი დატოვე, თუ რას ნიშნავს ეს `int i = 0; ...` ცოტა ხნით დავიკიდოთ. მთავარი ის არის, რომ რა რიცხვსაც რაოდენობის მაგივრად ჩაწერ(და უნდა ჩაწერო რამე ნატურალური რიცხვი), იმდენჯერ გამეორდება მეთოდის ტანში არსებული ინსტრუქტიცები. მეთოდის მსგავსად `for ციკლის` ტანში დაწერილი ინსტრუქციები იწერება გახსნილ ფიგურულ ფრჩხილსა და დახურულ ფიგურულ ფრჩხილს შორის და იმისათვის, რომ ადამიანისთვის მარტივად აღსაქმელი იყოს "შეწეულია" `tab`-ებით. მაგალითად ამოცანის ამოხსნა შემდეგი კოდით არის შესაძლებელი:

```java
import stanford.karel.*;

public class ForExample extends Karel {
    public void run() {
        for (int i = 0; i < 99; i++) {
            move();
        }
        pickBeeper();
    }
}
```

რა თქმა უნდა, for ციკლის ტანში შეიძლება არა ერთი, არამედ რამდენიმე ინსტრუქცია/ბრძანება ეწეროს. ამ შემთხვევაში არსებული ინსტრუქციები მეორდება მიმდევრობით (თითქოს ეს ინსტრუქციები ერთმანეთის ქვეშ დააკოპირეს). მაგალითად კოდი

```java
for (int i = 0; i < 4; i++) {
    move();
    turnLeft();
}
```
ნიშნავს არა იმას, რომ კარელმა ჯერ ოთხი `move()` უნდა შეასრულოს და შემდეგ 4 `turnLeft()`, არამედ ნიშანავს, ჯერ შეასრულოს `move()` მერე `turnLeft()` და ეს გაიმეოროს 4-ჯერ. რის შედეგადაც კარელი საწყის წერტილზე დაბრუნდება, თუკი ირგვლივ კედლები არ არის.