# FillStats

პრობლემა:
```
დაწერეთ პროგრამა რომელიც ფაილიდან წაიკითხავს ტექტს და დათვლის შემდეგ
სტატისტიკებს: სიმბოლოების რაოდენობა, სიტყვების რაოდენობა(სიტყვები სფეისებით
გამოყოფილია ერთმანეთისგან), წინადადებების რაოდენობა. რამდენი წინდადება მთავრდება
წერტილით, კითხვის ნიშნით და ძახილის ნიშნით?
```



## პრობლემის გადაჭრის გზა
პირველ რიგში ჩვენი პრობლემა დავყოთ სამ ნაწილად
* საჭიროა წავიკითხოთ ფაილი და ჩავწეროთ ინფორმაცია შესაბამის ცვლადში.
* ამის შემდგომ უკვე შეგვიძლია გამოვითვალოთ თითოეული ინფორმაცია.
* ბოლო ნაბიჯი კი მიღებული ინფორმაციის დაბეჭვდაა.

---

### წავიკითხოთ ფაილიდან ინფორმაცია

readContent ფუნქციას გადაეცემა ფაილის სახელი, რომლიდანაც BufferReader ის საშუალებით კითხულობს ხაზ-ხაზ ინფორმაციას, მანამ სანამ ყველა ხაზს არ წაიკითხავს. ამ ინფორმაციას აწებებს content სტრინგ ტიპის ცვლადს, რომელშიც ბოლოს მთლიანი ფაილის ინფორმაცია იქნება ჩაწერილი. თუ რაიმე შეცდომა დაფიქსირდა და კოდი return content -მდე ვერ ჩავიდა, მაშინ ფუნქცია დააბრუნებს NULL-ს და ამის შემდგომ პროგრამა შეწყვეტს მუშაობას. 
```java
// Read Content
String content = readContent("FileStats.java");

// Check If Error
if (content == null)
	return;
```

```java
private String readContent(String fileName) {
	try {
		String content = "";
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		while (true) {
			String line = br.readLine(); // 1. read current line

			if (line == null) { // 2. if (line == null) => there are no more lines to read
				break;
			}

			// 3. at this point (line != null) => there are more lines to read
			content += line + '\n'; // 4. append content current line
		}
		br.close();
		return content;
	} catch (Exception e) {
		println(e);
	}
	return null;
}
```

---

### ინფორმაციის დახარისება
იმისათვის, რომ დავახარისხოთ ფაილიდან წაკითხული ინფორმაცია, ვწერთ ჯერ ფუნქციებს, რადგან კარგი დეკომპოზიცია გვქონდეს. გავიაროთ თითეული ფუნქციის იმპლემენტაცია ცალ-ცალკე.
```java
// Evaluate
int symbolCount = countSymbols(content);
int wordCount = countWords(content);
int sentenceCount = countSentences(content);
int sentencesWithDot = countSentences(content, ".");
int sentencesWithQuestionMark = countSentences(content, "?");
int sentencesWithExclamationPoint = countSentences(content, "!");
```

თუ რამდენი სიმბოლოსგან შედგებოდა ტექსტი ამის გასაგებად შეგვიძლია უბრალოდ string -ის სიგრძე დავაბრუნოთ.
```java
// Count symbols of content
private int countSymbols(String content) {
	return content.length();
}
```

StringTokenizer -ის საშუალებით შეგვიძლია დავითვალოთ თუ რამდენი სიტყვა მონაწილეობდა ფაილში.
```java
// Count words by StringTokenizer.
private int countWords(String content) {
	StringTokenizer st = new StringTokenizer(content);
	return st.countTokens();
}
```

ვიყენებთ countSentences ფუნქციის overload-ს. თუ კონკრეტული სიმბოლოთი გვაინტერესებს რამდენი წინადადება სრულდება შეგვიძლია პირდაპირ ეს სიმბოლო გადავცეთ, თუ არადა ვიყენებთ მეორე ფუნქციას, რომელიც იძახებს countSentences ფუნქციას და თან გადასცემს სამივე სიმბოლოს, რითიც შეიძლება დასრულდეს წინადადება.
```java
// Count sentences by calling overloaded function
private int countSentences(String content) {
	return countSentences(content, ".?!");
}

// Count sentences depends on marks. Mark is symbol at the end of sentence.
private int countSentences(String content, String marks) {
	StringTokenizer st = new StringTokenizer(content, marks);
	return st.countTokens() - 1;
}
```

---

### მიღებული შედეგების დაბეჭვდა
ამოცანის ბოლო ეტაპია, მიღებული შედეგები გამოვიტანოთ ფანჯარაზე, ამისათვის კი ვიყენებთ println ფუნქციას.
```java
// Print Results
println("Total Symbols: " + symbolCount);
println("Total Words: " + wordCount);
println("Total Sentences: " + sentenceCount);
println("Total Sentences Ending with . : " + sentencesWithDot);
println("Total Sentences Ending with ? : " + sentencesWithQuestionMark);
println("Total Sentences Ending with ! : " + sentencesWithExclamationPoint);
```

---

## ხშირად დასმული კითხვები
1) რატომ უნდა დავაბრუნოთ countSentences -ში st.countTokens()-1 და არა პირდაბირ ტოკენების რაოდენობა?

პასუხი: ტოკენების რაოდენობა არის - თუ რამდენად გაიყო კონკრეტული სიმბოლოთი ტექსტი. იმისათვის, რომ ამ სიმბოლოების რაოდენობა გავიგოთ ტოკენების რაოდენობას უნდა გამოვაკლოთ 1.

---

## შესაძლო ხარვეზები ამოხსნის იმპლემენტაციისას
პირველ რიგში, მინდა მოგილოცოთ პროგრამის წარმატებით დასრულება და იმპლემენტაცია, თუმცა არსებობს დეტალი, რისი გათვალისწინებაც საკმაოდ მნიშვნელოვანია ამ ამოცანის გადაჭრისას.

1. საჭიროა გვქონდეს კარგი დეკომპოზიცია. ჩვენ შეგვეძლო შეგვექმნა სამი ფუნქცია ცალცალკე, რომლებიც დაითვლიდნენ სათითაოდ რომელი სიმბოლოთი რამდენი წინადადება სრულდებოდა, მაგრამ ეს არ იქნებოდა დეკომპოზიციურად სწორად დაწერილი კოდი.