package fr.hocem.companyservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
public class CompanyRestController {

    @Value("${xParam}")
    private int xParam;

    @Value("${yParam}")
    private int yParam;

    @Value("${me}")
    private String me;

    @GetMapping("/myConfig")
    public Map<String, Object> getMyConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put("xParam", xParam);
        config.put("yParam", yParam);
        config.put("me", me);
        config.put("thread", Thread.currentThread().getName());
        return config;
    }
}
