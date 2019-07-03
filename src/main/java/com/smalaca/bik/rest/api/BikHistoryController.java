package com.smalaca.bik.rest.api;

import com.google.common.collect.ImmutableMap;
import com.smalaca.credit.CreditGrantedScenario;
import com.smalaca.credit.CreditNotGrantedBikInvalidScenario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/history")
public class BikHistoryController {
    private final Map<String, String> responses = ImmutableMap.of(
            CreditGrantedScenario.PESEL, CreditGrantedScenario.BIK_STATUS,
            CreditNotGrantedBikInvalidScenario.PESEL, CreditNotGrantedBikInvalidScenario.BIK_STATUS
    );

    @GetMapping(value = "/{pesel}")
    public String check(@PathVariable String pesel) {
        return responses.get(pesel);
    }
}
