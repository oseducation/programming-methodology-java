პრობლემა: გარემოს გამართვის ინსტრუქცია Mac პლატფორმისთვის

გარემოს გამართვა შეგვიძლია დავყოთ სამ ნაწილად: 

1. ჯავას დაყენება
2. ეკლიფსის დაყენება
3. სტენფორდის ბიბლიოთეკების დაყენება

პირველი:  ჯავას დაყენებისთვის კლასრუმზე არსებული `jre-8u221-macosx-x64.dmg` უნდა დააყენოთ. ეს მარტივად შესრულებადია, უბრალოდ გახსნით ფაილს და მიჰყვებით პროცესს და დააყენებს.

მეორე: ეკლიფსის დაყენებისთვისაც უნდა გამოიყენოთ ან კლასრუმზე არსებული საინსტალაციო, ანდაც გადმოწეროთ [აქედან](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2022-12/R/eclipse-inst-jre-mac64.dmg)

$\color{#ad2f25}\text{გაფრთხილება: }$  M1-ს მქონე ჩიპებიან მაქბუკებზე დარწმუნდით, რომ უახლესი OS გიყენიათ.

დაყენების შემდეგ უნდა შევცვალოთ ეკლიფსის ფოლდერში ჯავას ვერსია. ამისთვის გახსენით `Finder`, შედით აპლიკაციებში და იპოვეთ Ecliplse, მონიშნეთ მარჯვენა ღილაკით და დააჭირეთ `Show Package Contents`. შემდგომ შედით Contents ფოლდერში და გახსენით `Info.plist`. აქ დაბლა ნახავთ შემდეგნაირ კოდს:
```html
<array>
    <!-- to use a specific Java version (instead of the platform's default) uncomment one of the following options,
            or add a VM found via $/usr/libexec/java_home -V
        <string>-vm</string><string>/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Commands/java</string>
        <string>-vm</string><string>/Library/Java/JavaVirtualMachines/1.8.0.jdk/Contents/Home/bin/java</string>
    -->
    <string>-keyring</string>
    <string>~/.eclipse_keyring</string>
</array>
```
ჩვენ უნდა დავამატოთ აქ ერთი ხაზი კოდი `<string>-vm</string><string>/Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/bin/java</string>` და მივიღებთ შემდეგნაირ კოდს:

```html
<array>
    <string>-vm</string><string>/Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/bin/java</string>
    <!-- to use a specific Java version (instead of the platform's default) uncomment one of the following options,
            or add a VM found via $/usr/libexec/java_home -V
        <string>-vm</string><string>/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Commands/java</string>
        <string>-vm</string><string>/Library/Java/JavaVirtualMachines/1.8.0.jdk/Contents/Home/bin/java</string>
    -->
    <string>-keyring</string>
    <string>~/.eclipse_keyring</string>
</array>
```
შეინახეთ ფაილი და ამით ეკლიფსის ჩართვა შეგეძლებათ უკვე.

მესამე: ჩართეთ ეკლიფსი და `help`-ში გახსენით `Install new software`. `work with`-ში ჩაწერეთ `https://web.stanford.edu/class/archive/cs/cs106a/cs106a.1174/resources/plugin/` ეს ლინკი და დააჭირეთ ენტერს. შემდგომ დააჭირეთ `Select All` და გადადით შემდეგ ეტაპზე `next` ღილაკით. `I accept the terms of the license agreement` მონიშნეთ და გადადით შემდეგ ეტაპზე და დაიწყებს დაყენებას. დაყენების შემდგომ ახლიდან ჩართვას მოგთხოვთ და ამის მერე ყველაფერი დაყენებული იქნება.