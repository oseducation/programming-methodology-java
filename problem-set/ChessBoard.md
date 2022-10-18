# ChessBoard

პრობლემა:
```
დახატეთ ჭადრაკის დაფა 8x8-ზე.
```



## პრობლემის გადაჭრის გზა
პირველ რიგში ჩვენი პრობლემა დავყოთ სამ ნაწილად
* იმისდა მიხედვით, თუ რა არის ეკრანზე გამოსული ფანჯრის ზომა, უნდა დავადგინოთ ფანჯრის სიგანეს შეავსებს თუ სიმაღლეს დაფა და შესაბამისად გავიგოთ,რა იქნება თითეული უჯრის ზომა.
* ორმაგი ციკლის გამოყენებით, უნდა დავთვალოთ, თუ სად უნდა ჩავსვათ თითოეული უჯრა.
* მნიშვნელოვანი ნაწილია ასევე დაფის უჯრებისთვის ფერის შერჩევა.

---

### უჯრის ზომის დადგენა

მოცემული ფუნქცია აბრუნებს მინიმალურ ზომას ორი განსხვავებული ზომის უჯრიდან. sizeAccordingToWidth სიგრძის უჯრები არის საჭირო იმისთვის,რომ ფანჯრის სიგანე შევავსოთ, ხოლო sizeAccordingToHeight სიგრძის უჯრების გამოყენებით სიმაღლეში ივსება ფანჯარა.
```java
private double calculateCellSize() {
	double height = getHeight();
	double width = getWidth();
	
	double sizeAccordingToWidth = width / N_COL;
	double sizeAccordingToHeight = height / N_ROW;

	if (sizeAccordingToWidth > sizeAccordingToHeight) {
		return sizeAccordingToHeight;
	} else {
		return sizeAccordingToWidth;
	}
}
```

---

### უჯრების დახატვა
მოცემული ფუნქცია აკეთებს უჯრის დახატვას ზომისა და კორდინატების მიხედვით. ფუნქციის გამოძახება ხდება ისე, რომ rowNum და colNum იღებს მნიშვნელობებს 0-დან 7-ის ჩათვლით. cellSize კი ჩვენ მიერ მარამდე დათვლილი უჯრის სიგრძეა.
```java
private void drawCheckerboardCell(double cellSize, int rowNum, int colNum) {
	double x = cellSize * rowNum;
	double y = cellSize * colNum;

	GRect cell = new GRect(x, y, cellSize, cellSize);
	cell.setFilled(true);
	if ((rowNum + colNum) % 2 == 1) {
		cell.setColor(Color.BLACK);
	} else {
		cell.setColor(Color.ORANGE);
	}
	add(cell);
}
```

---

### უჯრებისთვის ფერების შერჩევა
დაფის დახატვისას კონკრეტული ფერი გამოყენებული უნდა იყოს ერთი უჯრის დაშორებით. შესაბამისად, (rowNum + colNum) % 2 == 1 ამ ნაწილის გამო, if -ში შევა ყოველი მომდევნო ორი უჯრიდან ერთ-ერთისთვის.
```java
cell.setFilled(true);
if ((rowNum + colNum) % 2 == 1) {
	cell.setColor(Color.BLACK);
} else {
	cell.setColor(Color.ORANGE);
}
```

---

## შესაძლო ხარვეზები ამოხსნის იმპლემენტაციისას
პირველ რიგში, მინდა მოგილოცოთ პროგრამის წარმატებით დასრულება და იმპლემენტაცია, თუმცა არსებობს დეტალი, რისი გათვალისწინებაც საკმაოდ მნიშვნელოვანია ამ ამოცანის გადაჭრისას.

1. საჭიროა, რომ დავადგინოთ უჯრის ზომა ისე, რომ ზუსტად ჩაჯდეს ფანჯარაში და არ გადაცდეს ფანჯარას. მაგალითად თუ სწორად ჯდება, როცა ფანჯრის სიმაღლის მიხედვით დავთვლით უჯრას, მაშინ თუ სიგანის მიხედვით დათვლილ უჯრის ზომას გამოვიყენებთ, მივიღებთ, რომ ბევრ უჯრას ვერც დავინახავთ.