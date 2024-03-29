# Avarage

## პრობლემა:

	კონსოლიდან წაიკითხეთ ორი მთელი რიცხვი, დაბეჭდეთ მათი საშუალო არითმეტიკული.

## პრობლემის გადაჭრის გზა:

პრიველ რიგში, კონსოლიდან უნდა წავიკითხოთ ორი რიცხვი, **firstNumber** და **secondNumber**, შემდეგ შევქმით ახალ მეთოდს, რომელსაც გადაეცემა ორი რიცხვი და აბრუნებს მათ საშუალო არითმეტიკულს. ამ მეთოდში უნდა შევკრიბოთ მასზე გადმოცემული ორი რიცხვი, გადავკასტოთ **double**-ში, გავყოთ ორზე და დავაბრუნებინოთ მეთოდს მიღებული პასუხი, ბოლოს მეთოდისგან დაბრუნებული რიცხვი დავბეჭდოთ.

## პრობლემის გადაჭრის გზის კოდად გარდაქმნა:

1. თითოეული რიცხვის შეტანისას უნდა გამოვიყენოთ **readInt()** მეთოდი, რომელსაც არგუმენტად კონსოლში დასაბეჭდი ტექსი გადაეცემა, რისი დაბეჭდვის შემდეგაც ის დაუცდის მომხმარებელის შეყვანილ რიცხვს. მაგალითად, ჩვენ შეგვიძლია გამოვიყენოთ **readInt("Enter the first number: ");** და **readInt("Enter the second number: ");** პირველი და მეორე რიცხვების შესაყვანად. შესაბამისად, კონსოლში დაიწერება **Enter the first number:** და კონსოლი დაუცდის მომხმარებლის შეყვანილ რიცხვს. რიცხვის შეყვანის შემდეგ კონსოლში დაიწერება **Enter the second number:** და კონსოლი ისევ დაუცდის მომხმარების შეყვანილ რიცხვს.

2. შევქმნით ახალ **double** ტიპის მეთოდს, რომელსაც გადაეცემა ორი მთელი რიცხვი **firstNumber** და **secondNumber**. 
```java	
	private double getAvarage(int firstNumber, int secondNumber) {
 		//To-Do
 	}
```
 
3. შევქმნით ახალ ცვლადს sum, რომელშიც ჩავწერთ გადმოცემული ორი რიცხვის ჯამს: 
	**int sum = firstNumber + secondNumber;** 

4. ბოლოს, გადავკასტავთ **sum**-ს **double**-ში და გავყოფთ ორზე:
	**return (double)(firstNumber + secondNumber) / 2;**
**int** ტიპის ცვლადის **double**-ში გადაკასტვა მის წინ **(double)** -ს დაწერით შეგვიძლია.

## შესაძლო ხარვეზები:
1. შესაძლოა თქვენ ეს კოდი სწორად მოგეჩვენოთ **return firstNumber + secondNumber / 2;**, მაგრამ ყველა შემთხევაში არ იმუშავებს, რაგან ოპერაციები სწორი თანმიმდევრობით არ სრულდება, ჯავაში უფრო დიდი პრიორიტეტი გაყოფას ენიჭება, ვიდრე შეკრებას, ამიტომ ამ კოდში პირველ რიგში გაყოფა შესრულდება და შემდეგ შეკრება, პასუხად მივიღებთ პირველ რიცხვს დამატებული მეორე რიცხვის ნახევარი. მაგალითად, როცა პირველი რიცხვი არის **10** და მეორე რიცხვი **8**, ეს ამოხსნა დააბრუნებს **10 + 8 / 2 = 10 + 4 = 14**, რაც არ არის საშუალო არითმეტიკულის ტოლი.

2. განვიხილოთ შემდეგი ვარიანტი: **return (firstNumber + secondNumber) / 2;**. ამ შემთხევაში ოპერაციები სწორი თანმიმდევრობით შესრულდება (ჯერ შეკრება, შემდეგ გაყოფა), თუმცა არც ეს იმუშავებს სწორად ყველა შემთხვევაში. როდესაც რიცხვების ჯამი კენტი აღმოჩნდება, მათი საშუალო არითმეტიკული მთელი რიცხვი არ იქნება. მოცემული ამოხსნა კი მხოლოდ მთელ რიცხვებზეა მორგებული. ის საშუალო არითმეტიკულის მთელ მნიშნელობას დააბრუნებს. მაგალითად, როდესაც პირველი რიცხვი არის **7**, მეორე კი **10**, ეს ამოხსნა დააბრუნებს **(7 + 10) / 2 = 17 / 2 = 8**, რაც არ არის საშუალო არითმეტიკული. სწორედ ამიტომაა საჭირო ჯამის **double**-ში გადაკასტვა.

## რატომ იქნება return (double)sum / 2; სწორი
ამ შემთხევაში ჩვენი **sum** ცვლადი **double**-ში გადაიკასტება, რის შემდეგაც მოქმედებები შესრულდება ისე, როგორც ნამდვილ რიცხვებზე და არა მთელზე. ასევე, **double** ტიპის ცვლადის ორზე გაყოფისას პასუხი განაყოფის არა მთელი, არამედ მისი რეალური მნიშვნელობა იქნება. მაგალითად პრიველი რიცხვი არის **5**, მეორე **10**. მივიღებთ **(double)(5 + 10) / 2 = (double)(15) / 2 = 7.5**


## კიდევ ერთი ამოხსნის ვარიანტი:
ასევე სწორი ამოხსნა იქნებოდა, თუ დავწერდით **return (firstNumber + secondNumber) / 2.0;**, რადგან ამ შემთხვევაში **2.0**-ის დაწერით გაყოფის ოპერატორი მუშაობს როგორც მანდვილ რიცხვებზე გაყოფა, ამიტომ საბოლოო პასუხიც **double** იქნება და არა **int**. მაგალითად,როცა პირველი რიცხვი არის **5**, მეორე კი **8**, მივიღებთ **(5 + 8) / 2.0 = 13 / 2.0 = 6.5**, რაც სწორი პასუხია.
