package com.pm.zomatoClone.factories;

import com.pm.zomatoClone.models.*;
import com.pm.zomatoClone.strategies.PaymentStrategy;

import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy, double totalCost, String orderType);
}
