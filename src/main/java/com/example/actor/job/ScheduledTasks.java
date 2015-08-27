package com.example.actor.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.actor.setting.CronSetting;

@Component
public class ScheduledTasks {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

  @Autowired
  CronSetting cron;

  @Scheduled(fixedRate = 10000)
  public void reportCurrentTime() {
    System.out.println("Rate " + sdf.format(new Date()));
    try { TimeUnit.SECONDS.sleep(2L); } catch (InterruptedException e) { e.printStackTrace(); }
  }

  @Scheduled(initialDelay = 15000, fixedDelay = 10000)
  public void report() {
    System.out.println("Delay " + sdf.format(new Date()));
    try { TimeUnit.SECONDS.sleep(2L); } catch (InterruptedException e) { e.printStackTrace(); }
  }

  @Scheduled(cron = "*/5 * * * * MON-FRI", zone= "Asia/Tokyo")
  public void cron() {
    System.out.println("Cron " + sdf.format(new Date()));
    try { TimeUnit.SECONDS.sleep(2L); } catch (InterruptedException e) { e.printStackTrace(); }
  }

  @Scheduled(cron = "${cron.cron2}")
  public void cron2() {
    System.out.println("Cron2 " + sdf.format(new Date()));
    try { TimeUnit.SECONDS.sleep(2L); } catch (InterruptedException e) { e.printStackTrace(); }
  }

}