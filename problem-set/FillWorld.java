
/**
 * კარელი დგას 1x1 უჯრაზე, შეავსებინეთ მას მთელი სამყარო თითო ბრილიანტით. ანუ მთელ
 * სამყაროში ყველა უჯრაზე უნდა იდოს ზუსტად ერთი ბრილიანტი. ჩათვალეთ რომ საწყისი
 * სამყარო ცარიელი არ არის და გარკვეულ(ჩვენთვის უცნობ) უჯრებში თითო(მხოლოდ ერთი)
 * ბრილიანტი დევს. ამასთან გაითვალისწინეთ, რომ სამყაროს ზომები თქვენთვის უცნობია და
 * თქვენი პროგრამა უნდა მუშაობდეს ნებისმიერი ზომის სამყაროსათვის.
 */

import stanford.karel.*;

public class FillWorld extends SuperKarel {
    public void run() {
        fillWorld();
    }

    void fillWorld() {
        if (frontIsBlocked()) {
            turnLeft();
            fillOneLine();
        } else {
            while (frontIsClear()) {
                fillOneLine();
                goUp();
            }
        }
    }

    // გადავა შემდეგ როუზე
    private void goUp() {
        if (facingEast()) turnLeft(); //თუ მარცხნიდან მარჯვნივ ვმოძრაობდით
        else turnRight(); // თუ მარჯვნიდან მარცხნივ მოვედით

        if (frontIsClear()) {
            move();
            if (leftIsBlocked()) turnRight(); //მარცხენა კედლის შემთხვევაში ვუხვევთ მარჯვნივ
            else turnLeft(); // მარჯვენას შემთხვევაში მარცხნივ
        }
    }


    // მთლიან როუს შეავსებს თითო ბრილიანტით
    private void fillOneLine() {
        putBeeperSafely(); // of by one ბაგისთვის
        while (frontIsClear()) {
            move();
            putBeeperSafely();
        }
    }

    //თუ უჯრაზე ბრილიანტი არ დევს, დადებს ბრილიანტს
    private void putBeeperSafely() {
        if (noBeepersPresent()) putBeeper();
    }
}
