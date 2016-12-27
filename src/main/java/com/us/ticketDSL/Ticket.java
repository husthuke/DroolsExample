package com.us.ticketDSL;

/**
 * Created by yangyibo on 16/12/21.
 */
public class Ticket {
    private Customer customer;
    private String   status;

    public Ticket() {

    }

    public Ticket(final Customer customer) {
        super();
        this.customer = customer;
        this.status = "买票";
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public String toString() {
        return "[好看电影院: 尊敬的"+this.customer.getSubscription()+" 卡用户 " + this.customer.getName() + ",您" + this.status + "]";
    }

}
