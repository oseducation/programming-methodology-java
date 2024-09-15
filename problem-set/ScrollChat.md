# ScrollChat

პრობლემა:
```
ამოცანის გაგრძელება. დაამატეთ სქროლი. თუკი ტექსტი ჩაცდება ეკრანს მაშინ ახალი
ტექსტი მაინც უნდა გამოჩნდეს ეკრანის ბოლოში, შესაბამისად სულ პირველად შეყვანილი
ტექსტი გაქრება ეკრანიდან.
```



## პრობლემის გადაჭრის გზა
პირველ რიგში ჩვენი პრობლემა დავყოთ ორ ნაწილად:
* საჭირო ელემენტების ინიციალიზაცია.
* Enter -ზე დაჭერისას ან ღილაკზე დაჭერისას მესიჯის გამოტანა.

---

### ინიციალიზაციის ნაწილი
1. შევქმნათ GLabel -ების ArrayList, რომელშიც შევინახავთ თითოეულ დაწერილ მესიჯს.
2. yForNewMessage არის იმისთვის, რომ განვსაზღვროთ ახალი მესიჯი სად უნდა დაემატოს.
3. დავამატოთ JTextField და JButton ფანჯრის სამხრეთ ნაწილზე და დავამატოთ addActionListener ორივე კომპონენტისთვის.


```java
public void init() {
	// Initialize messages list
	yForNewMessage = 0;
	messages = new ArrayList<GLabel>();

	// Initialize text field
	messageInput = new JTextField(20);
	add(messageInput, SOUTH);
	messageInput.addActionListener(this);

	// Initialize button
	addButton = new JButton("Add");
	add(addButton, SOUTH);

	addActionListeners();
}
```

---

### მესიჯების გამოტანა ფანჯარაზე
ეს ნაწილი შეგვიძლია კიდევ 2 ქვეკომპონენტად ჩავშალოთ:
1. ახალი მესიჯის დამატება.
    * message ცვლადში ჩავწერთ თუ რა მესიჯი უნდა მომხმარებელს რომ გაგზავნოს, რომლის მიხედვითაც შემდგომ შევქმნით GLabel -ს.
    * შექმნილ GLabel -ს შესაბამის ადგილას გამოვიტანთ და დავამატებთ ასევე ArrayList-ში.
2. გაგება შევსებულია თუ არა ფანჯარა მესიჯებით და შესაბამისად მოქმედება.
    * მას შემდეგ რაც ვიცით, რომ ახალი მესიჯი ვეღარ ეტევა ფანჯარაზე, შეგვიძლია გადავუაროთ ყველა GLabel -ს for ციკლის დახმარებით და ავწიოთ ზევით ყველა მათგანი ერთი labelSize -ით.
    * ამის შემდგომ ვიცით, რომ სულ ზევით რა მესიჯიც იყო, ესეიგი ArrayList -ში პირველი, მაინც აღარ გამოჩნდება და ტყუილად რომ არ გადავტვირთოთ სია, შეგვიძლია წავშალოთ ArrayList -დან.
    * ხოლო თუ ადგილი კიდევ გვაქვს ფანჯარაზე და ჯერ არ შევსებულა, საკმარისია მხოლოდ yForNewMessage ცვლადი გავზარდოთ, რადგან შემდეგი მესიჯი დაბლა შესაბამის ადგილას დაიხატოს და წინა მესიჯს არ გადაეწეროს თავზე.

```java
public void actionPerformed(ActionEvent e) {
	// 1. Get message
	String message = messageInput.getText();

	// 2. Add message on canvas
	GLabel messageLabel = new GLabel(message);
	double labelSize = messageLabel.getAscent();
	add(messageLabel, X_OFF, yForNewMessage + labelSize);

	// 3. Increment message count
	messages.add(messageLabel);

	// 4. Check if last label is visible
	if (messageLabel.getY() > getHeight()) {
		// 4.1 if not move all labels up by one label's size
		for (GLabel label : messages) {
			label.move(0, -labelSize);
		}
		// 4.2 remove first label
		messages.remove(0);
	} else {
		yForNewMessage += labelSize;
	}
}
```

---

## შესაძლო ხარვეზები ამოხსნის იმპლემენტაციისას
პირველ რიგში, მინდა მოგილოცოთ პროგრამის წარმატებით დასრულება და იმპლემენტაცია, თუმცა არსებობს დეტალი, რისი გათვალისწინებაც საკმაოდ მნიშვნელოვანია ამ ამოცანის გადაჭრისას.

1. მნიშვნელოვანია, რომ სწორად დავადგინოთ GLabel-ის Y პოზიცია. ხშირი შეცდომაა, რომ ავიწყდებათ დამატება თვითონ GLabel ის ascent -ის. რაც იწვევს იმას, რომ არ ჩანს ყველაზე პირველი დამატებული მესიჯი.