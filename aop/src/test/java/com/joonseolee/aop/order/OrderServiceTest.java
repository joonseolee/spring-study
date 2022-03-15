package com.joonseolee.aop.order;

import com.joonseolee.aop.order.aop.AspectV1;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
@Import({
        AspectV1.class
})
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void whenCalledFindAll_thenSuccess() {
        var objList = orderService.findAll();

        System.out.println("orderService is the proxy class - " + AopUtils.isAopProxy(orderService));
        assertThat(objList, notNullValue());
    }
}