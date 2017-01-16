package com.us.fusion;

/**
 * Created by yangyibo on 17/1/3.
 */
public class EventTest {
    private String uei;
    public String interfejs;

    public EventTest(String uei, String interfejs) {
        this.uei = uei;
        this.interfejs = interfejs;
        System.out.println("\nCreating an event, interface - " + interfejs + ", uei - " + uei);
    }

    public String getUei() {
        return uei;
    }
    public void setUei(String uei) {
        this.uei = uei;
    }
    public String getInterfejs() {
        return interfejs;
    }
    public void setInterfejs(String interfejs) {
        this.interfejs = interfejs;
    }
}
