package com.example.fixplayground.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FixController {
    private FixService fixService;
    @Autowired
    FixController(FixService fixService) {
        this.fixService = fixService;
    }

    @RequestMapping("/connect")
    public String connectFix() {
        fixService.connect();
        return "{\"msg\" :\"Hello World\" }";
    }

    @RequestMapping("/disconnect")
    public String disconnectFix() {
        fixService.disconnect();
        return "Hello dummy World";
    }

    @PostMapping("/sendorder")
    public String sendOrder(@RequestBody Order order) {
        fixService.sendOrder(order);
        return "{\"msg\" :\"Hello World\" }";
    }
}
