
/**
 * კარელი დგას 1x1 უჯრაზე, შეავსებინეთ მას მთელი სამყარო თითო ბრილიანტით. ანუ მთელ
 * სამყაროში ყველა უჯრაზე უნდა იდოს ზუსტად ერთი ბრილიანტი. ჩათვალეთ რომ საწყისი
 * სამყარო ცარიელი არ არის და გარკვეულ(ჩვენთვის უცნობ) უჯრებში თითო(მხოლოდ ერთი)
 * ბრილიანტი დევს. ამასთან გაითვალისწინეთ, რომ სამყაროს ზომები თქვენთვის უცნობია და
 * თქვენი პროგრამა უნდა მუშაობდეს ნებისმიერი ზომის სამყაროსათვის.
 * */

import stanford.karel.*;

public class FillWorld extends SuperKarel {
    public  void  run(){
        while(frontIsClear()){
            fillOneRow();
            goBack();
            goUp();
        }
    }
    // გადავა შემდეგ როუზე
    private void goUp(){
        turnLeft();
        if(frontIsClear()){
            move();
            turnRight();
        }
    }

    // დაბრუნდება ბოლოში
    private void goBack(){
        turnAround();
        while(frontIsClear())move();
        turnAround();
    }

    // მთლიან როუს შეავსებს თითო ბრილიანტით
    private void fillOneRow(){
        putBeeperSafely();
        while(frontIsClear()){
            move();
            putBeeperSafely();
        }
    }

    //თუ უჯრაზე ბრილიანტი არ დევს, დადებს ბრილიანტს
    private void putBeeperSafely(){
        if(noBeepersPresent())putBeeper();
    }
}
