public enum Discount {
    NATIONALMERIT(1,price -> price *0.8),
    SOLDIER(2,price->price*0.9),
    STUDENT(3,price->price*0.95),
    CIVILIAN(4,price->price);

    private final int code;
    private final DiscountPolicy policy;

    Discount(int code,DiscountPolicy policy){
        this.code = code;
        this.policy = policy;
    }

    public double apply(double price){
        return policy.calculate(price);
    }

    public static Discount fromCode(int code){
        for(Discount discount : values()){
            if(discount.code == code){
                return discount;
            }
        }
        throw new IllegalArgumentException("유효하지 않는 번호입니다");
    }

    interface DiscountPolicy{
        double calculate(double price);
    }
}
