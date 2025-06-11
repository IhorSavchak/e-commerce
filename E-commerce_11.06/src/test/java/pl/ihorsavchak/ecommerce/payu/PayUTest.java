package pl.ihorsavchak.ecommerce.payu;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PayUTest {
    @Test
    void itRegisterPayment() {
        PayU payU = thereIsPayU();
        OrderCreateRequest request = thereIsExampleOrderCreateRequest();
        OrderCreateResponse response = payU.handle(request);

        assertNotNull(response.getRedirectUrl());
        assertNotNull(response.orderId());
    }

    private OrderCreateRequest thereIsExampleOrderCreateRequest() {
        var exampleOrderCreateRequest = new OrderCreateRequest();
        exampleOrderCreateRequest
                .setCustomerIp("127.0.0.1")
                .setDescription()
                .setCurrencyCode()
                .setTotalAmount()
                .setExtOrderId()
                .setBuyer(new Buyer()
                        .setEmail()
                        .setFirstName()
                        .setLOastName()
                )
                .setProducts(Array.list(

                ));
    }

    private PayU thereIsPayU() {
        var cfg = PayUConfiguration.sandbox();
        return new PayU();
    }

}
