package org.perscholas.consumeapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.consumeapi.models.Quote;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
public class HomeController {


    @GetMapping("/")
    public String index(RestTemplate restTemplate, Model model){

        Quote quote = restTemplate.getForObject(
                "https://quoters.apps.pcfone.io/api/random", Quote.class);
        log.warn(quote.toString());
        model.addAttribute("quote", quote.getValue().getQuote());

        return "index";
    }
}
