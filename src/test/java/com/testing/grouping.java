package com.testing;

import org.testng.annotations.Test;

public class grouping {
    @Test(groups = {"smoke"})
    public void testLogin() {
        System.out.println("Login test executed");
    }

    @Test(groups = {"smoke"})
    public void testSearch() {
        System.out.println("Search test executed");
    }

    @Test(groups = {"regression"})
    public void testCheckout() {
        System.out.println("Checkout test executed");
    }

}
