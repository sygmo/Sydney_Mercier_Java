package com.trilogyed.gamestoreinvoicing.util.feign;

import com.trilogyed.gamestoreinvoicing.model.Console;
import com.trilogyed.gamestoreinvoicing.model.Game;
import com.trilogyed.gamestoreinvoicing.model.TShirt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "gamestore-catalog")
public interface GamestoreCatalog {

    @GetMapping(value = "/console/{id}")
    public Console getConsoleById(@PathVariable long id);

    @GetMapping(value = "/game/{id}")
    public Game getGameById(@PathVariable long id);

    @GetMapping(value = "/tshirt/{id}")
    public TShirt getTShirtById(@PathVariable long id);
}
