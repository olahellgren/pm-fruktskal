package se.pensionsmyndgheten.teammandarin.repository;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by olahel on 2016-04-15.
 */
@Entity
@Data
@NoArgsConstructor
public class Rost{

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long id;
  private Date date;
  private Health health;

  public Rost(Date date, Health health) {
    this.date = date;
    this.health = health;
  }

  public String getDate() {
    return this.date.toLocaleString();
  }

  public enum Health {
    ROD, GRON, GUL;
  }


}
