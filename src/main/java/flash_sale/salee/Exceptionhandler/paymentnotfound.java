package flash_sale.salee.Exceptionhandler;

public class paymentnotfound extends RuntimeException{
    public paymentnotfound(String message){
        super(message);
    }
}
