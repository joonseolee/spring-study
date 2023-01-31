package com.joonseolee.asnyc.controller;

import com.joonseolee.asnyc.service.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/async")
@RequiredArgsConstructor
public class AsyncController {

    private final AsyncService asyncService;

    @GetMapping
    public String testAsync() {
        AtomicInteger value = new AtomicInteger(0);

        IntStream.range(0, 100).forEach(it -> {
            try {
                asyncService.asyncMethod(it);
                value.set(value.intValue() + 1);
            } catch (TaskRejectedException e) {
                log.error("threadPool is flooded - {}", it);
                log.info("atomicInteger value -> {}", value.intValue());
            }
        });
        return "";
    }
}
