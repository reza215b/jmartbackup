package com.RezaRahadiJmartMH;

import com.RezaRahadiJmartMH.dbjson.JsonAutowired;
import com.RezaRahadiJmartMH.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class PaymentController implements BasicGetController<Payment> {

    public static final long DELIVERED_LIMIT_MS = 5;
    public static final long ON_DELIVERY_LIMIT_MS = 10;
    public static final long ON_PROGRESS_LIMIT_MS = 15;
    public static final long WAITING_CONF_LIMIT_MS = 20;

    @PostMapping("/{id}/cancel")
    public @ResponseBody
    boolean cancel(int id) {
        return false;

    }

    @PostMapping("/create")
    public @ResponseBody
    Payment create(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan) {
        return null;

    }

    public JsonTable<Payment> getJsonTable() {
        JsonTable<Payment> paymentTable = null;
        return paymentTable;
    }

    @PostMapping("/{id}/submit")
    public @ResponseBody
    boolean submit(int id, String receipt) {
        return false;

    }

    private static boolean timekeeper(Payment payment) {
    return false;
    }
}