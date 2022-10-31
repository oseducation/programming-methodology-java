#  სამუშაო გარემოს გამართვა Windows პლათფორმისთვის

  

##  3 მთავარი ნაბიჯი Eclipse-ის დაყენებისთვის:

  

1. ძველი JRE-ს ვერსიების ახლით ჩანაცვლება;

2. Eclipse-ს დაყენება;

3. Stanford-ის Plugin-ის დაყენება.

  

###  1. ძველი JRE-ს ვერსიების ახლით ჩანაცვლება

####  1.1 წაშალეთ JRE-ს ძველი ვერსიები.

პირველ რიგში აუცილებელია ძველი JRE ვერსიების წაშლა. ამისთვის საჭიროა გავხსნათ `Programs and Features` ფანჯარა (ვაწვებით `Start`-ს, შემდეგ ვეძებთ `Control Panel`-ს და ვაწვებით `Programs and Features`-ს). თქვენი ფანჯარა უნდა გამოიყურებოდეს შემდეგნაირად:

![Program and Features](/problem-set/images/Programs_and_Features.jpg)

* იმ შემთხვევაში, თუ თქვენი პროგრამების სახელების ჩამონათვალში შენიშნეთ `Java/J2SE Runtime Environment`, `Java SDK`, `Java SE Development Kit`, `Java Update` ან რაიმე მსგავსი, წაშალეთ (წასაშლელად საჭიროა 2-ჯერ დააწვეთ არჩეულ პროგრამას).

დახურეთ `Programs and Features` ფანჯარა, იგი აღარ დაგვჭირდება.

####  1.2 ჩამოტვირთეთ JDK.
ჩაიწერეთ JDK მოცემული ლინკიდან: [Link](https://drive.google.com/drive/folders/1qqIU5UYdES95yj4LTzdCPWMBLGtF8UAU).
![JDK File on drive](/problem-set/images/Download_JDK.jpg)

#### 1.3 დააყენეთ JDK.
Setup-ისთვის გახსენით ფაილი და მიჰყევით ნაბიჯებს:
* მონიშნეთ `Next`. 
 ![Setup Stage 01](/problem-set/images/JDK_Setup_01.jpg)
 * მონიშნეთ `Next`, სურვილისამებრ შეგიძლიათ ფაილების დაყენების ლოკაცია შეცვალოთ `Change...` ღილაკზე დაკლიკვით, თუმცა რეკომენდირებულია, რომ არ შეცვალოთ.
 ![Setup Stage 02](/problem-set/images/JDK_Setup_02.jpg)
 * ანალოგიურად, მონიშნეთ `Next`.
 ![Setup Stage 03](/problem-set/images/JDK_Setup_03.jpg)

 ### 2. Eclipse-ის დაყენება

 #### 2.1 ჩამოტვირთეთ Eclipse.
 ჩაიწერეთ Eclipse.zip მოცემული ლინკიდან: [Link](https://drive.google.com/drive/folders/1qqIU5UYdES95yj4LTzdCPWMBLGtF8UAU).
![Eclipse Zip on drive](/problem-set/images/Download_Eclipse.jpg)

#### 2.2 დააყენეთ Eclipse.
იპოვეთ ჩაწერილი Zip ფაილი და მიჰყევით ნაბიჯებს:
* მარჯვენა კლიკი Zip ფაილზე.
* ჩამონათვალიდან აარჩეთ `Extract Files...`
 ![Setup Stage 01](/problem-set/images/Eclipse_Setup_01.jpg)
 * `Destination Folder`-ად მიუთითეთ `Program Files` და მონიშნეთ `OK`.
 ![Setup Stage 02](/problem-set/images/Eclipse_Setup_02.jpg)
 * მოძებნეთ `Program Files`-ში `eclipse` საქაღალდე და შექმენით `Application` ტიპის ფაილის Shortcut.
 ![Setup Stage 03](/problem-set/images/Eclipse_Setup_03.jpg)
 * `Windows can't create shortcut here.` მსგავსი ტიპის შეტყობინების შემთხვევაში მონიშნეთ `Yes`.
 ![Setup Stage 04](/problem-set/images/Eclipse_Setup_04.jpg)

 #### 2.3 გახსენით Eclipse.
 გადადით Desktop-ზე, იპოვეთ Eclipse-ის Shortcut და გახსენით იგი. გამოსულ შეტყობინებაში მონიშნეთ `Use this as the default and do not ask again` და დააწექით `Launch`-ს.
  ![Launch Message](/problem-set/images/Eclipse_Launch.jpg)

 ### 3. Stanford-ის Plugin-ის დაყენება
 
 Eclipse-ის გახსნის შემდეგ Welcome ფანჯარა დახურეთ და მიჰყევით ნაბიჯებს:
* ფანჯარის ზედა მარცხენა კუთხეში დააწექით `Help`-ს, შემდეგ კი `Install New Software`.
![Plugin Stage 01](/problem-set/images/Plugin_01.jpg)
* `Work with`-ის მარჯვნივ ჩასვით მოცემული ლინკი და დააწექით `Enter`-ს კლავიატურაზე.
> ლინკი:  https://web.stanford.edu/class/archive/cs/cs106a/cs106a.1174/resources/plugin/

![Plugin Stage 02](/problem-set/images/Plugin_02.jpg)
* დააწექით `Select All`-ს, შემდგომ `Next`-ს.
![Plugin Stage 03](/problem-set/images/Plugin_03.jpg)
* დააწექით `Next`-ს.
![Plugin Stage 04](/problem-set/images/Plugin_04.jpg)
* მონიშნეთ `I accept the terms of the license agreement` და შემდგომ დააწექით `Finish`-ს.
![Plugin Stage 05](/problem-set/images/Plugin_05.jpg)
* შეტყობინების ამოვარდნის შემთხვევაში დააწექით `Install Anyway`-ს.
![Plugin Stage 06](/problem-set/images/Plugin_06.jpg)
* ახალ შეტყობინებაზე დააწექით `Restart Now`-ს.
![Plugin Stage 07](/problem-set/images/Plugin_07.jpg)

პროგრამა გადაიტვირთება და Eclipse მზად არის. რაიმე პრობლემის შემთხვევაში დაიხმარეთ Google.
