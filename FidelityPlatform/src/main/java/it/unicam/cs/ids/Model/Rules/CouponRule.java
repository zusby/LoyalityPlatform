package it.unicam.cs.ids.Model.Rules;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Coupon.Coupon;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.FidelityProgram;
import it.unicam.cs.ids.Model.Purchase;

public class CouponRule extends FidelityProgram implements RuleApplier {


    private Coupon coupon;

    public CouponRule(String programID, Timestamp endingDate, Timestamp startingDate, Coupon coupon) {
        super(programID, endingDate, startingDate);
        this.coupon = coupon;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    /**
     * This function applies a discount to a purchase based on a fidelity card and a coupon, but throws an exception if the
     * purchase price is below the minimum price specified in the coupon.
     *
     * @param card A fidelity card object that represents the customer's loyalty program membership.
     * @param purchase The purchase object represents a transaction made by a customer, containing information such as the
     * price of the purchase and the date it was made.
     */

    public void applyRule(FidelityCard card, Purchase purchase) {
        if (purchase.getPrice() < coupon.getMinimumPrice()) {
            throw new IllegalArgumentException();
        }
        purchase.setDiscount((purchase.getPrice() * coupon.getDiscountPercentage()) + coupon.getValue());



    }
}
