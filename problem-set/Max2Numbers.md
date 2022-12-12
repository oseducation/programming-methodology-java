# ამოხსნა
იმისთვის რომ ვიპოვოთ `n` რიცხვიდან 2 მაქსიმალური მნიშვნელობა შემოვიღოთ 2 `int` ცვლადი 
	- `max1Elem` - რომელშიც შევინახავთ ამ დროისთვის არსებულ მაქსიმალურ მნიშვნელობას
	- `max2Elem` - რომელშიც შევინახავთ ამ დროისთვის არსებულ სიდიდით მეორე მაქსიმალურ მნიშვნელობას
ყოველი ახალი `newElem` რიცხვის შემოსვლისას უბრალოდ უნდა შევამოწმოთ:
	- თუ `newElem > max1Elem` მაშინ `max2Elem = max1Elem` და `max1Elem = newElem` 
	- თუ `newElem <= max1Elem && newElem > max2Elem` მაშინ `max2Elem = newElem`

ხოლო თავდაპირველად `max1Elem=max2Elem=Integer.MIN_VALUE`.

## მაგალითი
n = 4 ელემენტები არის [10, -1, 20, 2]
newElem = 10	- max1Elem = 10 max2Elem = Integer.MIN_VALUE
newElem = -1	- max1Elem = 10 max2Elem = -1
newElem = 20	- max1Elem = 20 max2Elem = 10
newElem = 2		- max1Elem = 20 max2Elem = 10
