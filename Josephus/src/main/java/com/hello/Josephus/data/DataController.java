package com.hello.Josephus.data;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class DataController {

    private long last;

    @GetMapping("/Josephus")
    public String greetingForm(Model model) {
        model.addAttribute("data", new Data());
        return "problem";
    }

    @PostMapping("/Josephus")
    public String greetingSubmit(@ModelAttribute Data data, Map<String, Object> map) {

        Josephus obj = new Josephus(data.getWhole(), data.getCycle());
        long last = obj.solve();
        String orderInfo = obj.order().toString();

        // System.out.println(obj.solve());
        // System.out.println(orderInfo);

        map.put("lastman", last);
        map.put("order", orderInfo);

        return "result";
    }

}
