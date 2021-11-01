# კონტრიბუცია
პირველ რიგში ძალიან დიდი მადლობა ამ პროექტში კონტრიბუციისთვის რომ მოიცალე. 

## რა უნდა ვიცოდე სანამ კონტრიბუციას გავაკეთებ?
უნდა გესმოდეს როგორ მუშაობს git. [აქ](https://guides.github.com/introduction/git-handbook/) შეგიძლია ნახო მოკლე მიმოხილვა.

## როგორ გავაკეთო კონტრიბუცია?
* დააყენე [Git](https://help.github.com/en/articles/set-up-git)
* გააკეთე ამ რეპოს განშტოება(`fork`)
* დაკლონე რეპო შენს კომპზე რომელიმე ფოლდერში.
```
git clone https://github.com/შენი-იუზერნეიმი/programming-methodology-java.git
```
* აირჩიე საკითხი(`issue`) რომლის გადაჭრაც გინდა - [საკითხების სია](https://github.com/oseducation/programming-methodology-java/issues)
* შენს ლოკალურ რეპოში გააკეთე ბრენჩი ამ საკითხის იდენტიფიკატორით
```
git checkout -b PMJ-1234
```
* შეიტანე აუცილებელი ცვლილებები
* დააკომიტე(`commit`) ცვლილებები. მიაქციე ყურადღება იმას, რომ [დაუწერო კარგი კომიტ მესიჯი](https://chris.beams.io/posts/git-commit)
* თუკი ბევრი კომიტი გაქვს შეაწებე ერთმანეთს რომ ერთ კომიტად გადაიქცეს. დეტალებისთვის ნახე [interactive rebase](https://www.atlassian.com/git/tutorials/rewriting-history/git-rebase)
* ატვირთე(`push`) ცვლილებები შენს მიერ შექმნილ განშტოებაში(`fork`)
```
git push origin PMJ-1234
``` 
* შენი განშტოებიდან(`fork`) შექმენი `pull request` ამ რეპოს `master` ბრენჩზე.
* როდესაც `pull request` დაიმერჯება(`merge`), ჩამოტვირთე(`pull`) ცვლილებები upstream-იდან ლოკალურ რეპოში და წაშალე ზედმეტი ბრენჩი.
