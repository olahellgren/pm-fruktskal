package se.pensionsmyndgheten.teammandarin.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by olahel on 2016-04-15.
 */
public interface RostRepo extends CrudRepository<Rost, Long> {

  List<Rost> findAll();

}
