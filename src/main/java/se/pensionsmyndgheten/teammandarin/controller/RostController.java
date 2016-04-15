package se.pensionsmyndgheten.teammandarin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import se.pensionsmyndgheten.teammandarin.repository.Rost;
import se.pensionsmyndgheten.teammandarin.repository.RostRepo;

import java.util.Date;
import java.util.List;

/**
 * Created by olahel on 2016-04-15.
 */
@RestController
public class RostController {

  @Autowired
  RostRepo rostRepo;

  @RequestMapping(value="/rosta", method= RequestMethod.POST)
  public RedirectView rosta(String rost){
    Rost rosten = new Rost(new Date(), Rost.Health.valueOf(rost));
    rostRepo.save(
            rosten
    );
    List<Rost> rosts = rostRepo.findAll();
    return new RedirectView("");
  }

  @RequestMapping(value="/rapport", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public HttpEntity<List<Rost>> rapport(){

    List<Rost> rosts = rostRepo.findAll();

    return new HttpEntity<List<Rost>>(rosts);
  }

}
