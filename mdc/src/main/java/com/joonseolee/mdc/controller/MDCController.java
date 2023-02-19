package com.joonseolee.mdc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mdc")
public class MDCController {

    @GetMapping("/immediate")
    public String sayNow() {
        log.info("start sayNow.");
        log.info("call right away.");
        log.info("end sayNow.");
        return "sayNow";
    }

    @GetMapping("/delay")
    public String sayDelay() throws InterruptedException {
        log.info("start sayDelay.");
        Thread.sleep(5000);
        log.info("end sayDelay.");
        return "sayDelay";
    }
}
