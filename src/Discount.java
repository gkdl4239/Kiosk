public enum Discount {
    NATIONALMERIT(price -> price *0.8),
    SOLDIER(price->price*0.9),
    STUDENT(price->price*0.95),
    CIVILIAN(price->price);

    private final DiscountPolicy policy;

    Discount(DiscountPolicy policy){
        this.policy = policy;
    }

    public double apply(double price){
        return policy.calculate(price);
    }

    interface DiscountPolicy{
        double calculate(double price);
    }
}
