# Power

## პრობლემა:
```
მომხმარებელს შეჰყავს n და m დაბეჭდეთ n^m
```



## პრობლემის გადაჭრის გზა

თავდაპირველად უნდა წავიკითხოთ მომხმარებლის მიერ შემოყვანილი რიცხვები
```java
		int n = readInt("n: ");
		int m = readInt("m: ");
```
და შემდეგ დავბეჭდოთ n^m:
```java
	println("n^m = " + pow(n, m));
```
ჩვენი მთავარი ამოცანაა დავწეროთ pow(n, m)-ის იმპლემენტაცია, რომელსაც გადავცემთ ორ მთელ რიცხვს და გვიბრუნებს ასევე მთელ რიცხვს
```java
	private int pow(int n, int m){
		// To do
	}
```

## ალგორითმი

რიცხვის ასახარისხებლად გამოვიყენოთ ტრადიციული მეთოდი - ფუძე თავის თავზე გავამრავლოთ იმდენჯერ, რამდენჯერაც ხარისხის მაჩვენებელი გვიჩვენებს.



## იმპლემენტაცია

ამ ალგორითმის იმპლენტაციისთვის დაგვჭირდება for ციკლი და რაიმე ცვლადი, რომელიშიც ციკლის ყოველი იტერაციისას განვაახლებთ მნიშვნელობას.
ციკლი უნდა შესრულდეს m-ჯერ და ყოველ ჯერზე ჩვენ მიერ შექმნილი ცვლადის მნიშვნელობა უნდა გამრავლდეს n-ზე. მივიღებთ შემდეგ კოდს:
```java
	int result = 1;
	for (int i = 0; i < m; i++) {
		result *= n;
	}
	return result;
```

## ხშირად დაშვებული შეცდომები

შეიძლება ერთი შეხედვით გაუგებარი იყო, რატომ არის result ცვლადის მნიშვნელობა თავდაპირველად 1 და არა 0(როგორც, მაგალითად, ჯამის დათვლის დროს).
საქმე ისაა, რომ თუ result ცვლადის თავდაპირველ მნიშვნელობად 0-ს ავიღებდით, ციკლის იტერაციებზე ვეღარ განახლდებოდა და ყოველთვის 0 დარჩებოდა, რადგან 0-ის ნებისმიერ რიცხვზე გამრავლების შედეგი ისევ 0-ია.


## იმუშავებს თუ არა კოდი ყველა შემთხვევისთვის?

ინტუიციურად ადვილი მისახვედრია, რომ კოდი სწორად იმუშავებს იმ შემთხვევებისთვის, როდესაც m > 0.
განვიხილოთ შემთხვევა, როდესაც m = 0. ასეთ დროს ჩვენი პროგრამა for ციკლში არ შემოვა და მეთოდი დააბრუნებს 1-ს - კოდი სწორად იმუშავებს.
რა მოხდება თუ m < 0? ასეთ შემთხვევაშიც მეთოდი დააბრუნებს 1-ს, რადგან ციკლში აღარ შევა. ამის მოგვარება ჩვენთვის აუცილებელი არ არის, შეგვიძლია ჩავთვალოთ, რომ m ყოველთვის არაუარყოფითი იქნება. თუმცა არც ამ პრობლემის გადაჭრაა ძნელი.


## ახარისხება უარყოფითი ხარისხის მაჩვენებლისთვის

იმისათვის რომ ჩვენმა კოდმა სწორად იმუშავოს უარყოფით ხარისხის მაჩვენებლის შემთხვევაშიც, საჭიროა for ციკლში შესვლამდე ჩავატაროთ კონკრეტული მანიპულაციები. გავიხსენოთ, რომ თუ m < 0, n^m = (1/n)^|m| (აქ ხარისხის მაჩვენებელი უკვე დადებითია) მივიღებთ შემდეგ კოდს:
```java
	if (m < 0) {
		n = 1/n;
		m = Math.abs(m); // finds absolute value
	}
```
გავიხსენოთ, რომ n არის int ტიპის ცვლადი. 1/n იქნება 1-ზე ნაკლები, მისი int ცვლადის ტიპში შენახვისას კი დაიკარგება მისი მნიშვნელობა და შეინახება როგორც 0. ამის თავიდან ასაცილებლად შეგვიძლია n ცვლადისთვის გამოვიყენოთ double ცვლადის ტიპი. ასევე double ტიპის უნდა გავხადოთ მთლიანი ფუნქციის მიერ დაბრუნებული ცვლადის მნიშვნელობაც. მივიღებთ შემდეგ კოდს:
```java
	private double pow(double n, int m) {
		double result = 1;
		// if m<0 n^m=(1/n)^|m|
		if (m < 0) {
			n = 1 / n;
			m = Math.abs(m);
		}
		for (int i = 0; i < m; i++) {
			result *= n;
		}
		return result;
	}
```


## ამოხსნის ალტერნატიული გზები

რიცხვის ასახარისხებლად უამრავნაირი კოდი შეგვიძლია დავწეროთ. მაგალითად, ჩვენ მიერ დაწერილ ამოხსნაში შეგვიძლია for ციკლი while ციკლით ჩავანაცვლოთ:
```java
	while (m > 0) {
		result *= n;
		m--;
	}
```
ასევე შესაძლებელია გარკვეული გაუმჯობესებები შევიტანოთ ჩვენს კოდში. მაგალითად თუ გინდა 1^2000000000-ის გამოთვლა, პროგრამა მაინც შევა ციკლში იმისდა მიუხედავად, რომ ამის საჭიროება არ არსებობს, ციკლის შესრულებას კი დაახლოებით 4 წამი უნდება. იმისათვის რომ პროგრამა ციკლში აღარ შევიდეს, ციკლამდე შეგვიძლია დავწეროთ:
```java
	if (n == 1)
		return 1;
```
ასევე დროის გასაუმჯობესებლად შეგვიძლია გამოვიყენოთ სწრაფი ახარისხების ალგორითმი. ამ და ახარისხების სხვა მიდგომებს შეგიძლიათ გაეცნოთ ლინკზე https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
არსებობს მზა ფუნქციაც `Math.pow(double a, double b)`, რომელიც double ტიპის ცვლადს აბრუნებს.
