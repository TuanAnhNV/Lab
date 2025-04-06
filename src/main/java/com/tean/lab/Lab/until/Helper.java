package com.tean.lab.Lab.until;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;

import java.time.*;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class Helper {
  public static final String ZONE_UTC = "UTC";
  public static final String ZONE_VN = "Asia/Ho_Chi_Minh";

  public static long getNowMillisAtUtc() {
    return LocalDateTime.now(ZoneId.of(ZONE_UTC)).toInstant(ZoneOffset.UTC).toEpochMilli();
  }

  public static long convertUnixTime(String dateString) {
    LocalDate localDate = LocalDate.parse(dateString);
    Instant instant = localDate.atStartOfDay(ZoneOffset.UTC).toInstant();
    return instant.getEpochSecond();
  }

  public static long timeToLongAtUtc(LocalDateTime dateTimeAtUtc) {
    return ZonedDateTime.of(dateTimeAtUtc, ZoneId.of(ZONE_UTC)).toInstant().toEpochMilli();
  }

  public static long convertDayToMilliseconds(long day) {
    // 1 day = 24 hours = 24 * 60 minutes = 24 * 60 * 60 seconds = 24 * 60 * 60 * 1000 milliseconds
    return day * 24 * 60 * 60 * 1000;
  }

  public static LocalDateTime getNowDateTimeAtUtc() {
    return LocalDateTime.now(ZoneId.of(ZONE_UTC));
  }

  public static LocalDate getNowDateAtUtc() {
    return getNowDateTimeAtUtc().toLocalDate();
  }

  public static LocalDateTime longToLocalDateTimeUtc(Long millisAtUtc) {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(millisAtUtc), ZoneId.of(ZONE_UTC));
  }

  public static LocalDateTime longToLocalDateTimeVn(Long millisAtUTC) {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(millisAtUTC), ZoneId.of(ZONE_VN));
  }

  public static LocalDate longToLocalDateVn(Long millisAtUTC) {
    return longToLocalDateTimeVn(millisAtUTC).toLocalDate();
  }

  public static LocalDate longToLocalDate(Long millisAtUtc) {
    return LocalDate.ofInstant(Instant.ofEpochMilli(millisAtUtc), ZoneId.of(ZONE_UTC));
  }


  public static LocalDateTime getNowDateTimeAtVn() {
    return LocalDateTime.now(ZoneId.of(ZONE_VN));
  }

  public static LocalDate getNowDateAtVn() {
    return getNowDateTimeAtVn().toLocalDate();
  }

  public static long timeToLongAtVn(LocalDateTime dateTimeAtVn) {
    return ZonedDateTime.of(dateTimeAtVn, ZoneId.of(ZONE_VN)).toInstant().toEpochMilli();
  }

  public static long getStartOfDay(LocalDate date) {
    LocalDateTime localDateTime = date.atStartOfDay();
    return localDateTime
        .atZone(ZoneId.of(ZONE_VN))
        .withZoneSameInstant(ZoneId.of(ZONE_UTC))
        .toInstant()
        .toEpochMilli();
  }

  public static long getEndOfDay(LocalDate date) {
    LocalDateTime localDateTime = date.atStartOfDay().plusDays(1).minusSeconds(1);
    return localDateTime
        .atZone(ZoneId.of(ZONE_VN))
        .withZoneSameInstant(ZoneId.of(ZONE_UTC))
        .toInstant()
        .toEpochMilli();
  }

//  public static String md5Token(String token) {
//    return DigestUtils.sha256Hex(token);
//  }

  public static String getPath(HttpServletRequest request) {
    StringBuilder requestURL = new StringBuilder(request.getRequestURI());
    String queryString = request.getQueryString();
    return queryString == null ? requestURL.toString() : requestURL.append('?').append(queryString).toString();
  }

  public static String genUserCampaignProductDigitalKey(Integer userId, Integer campaignProductDigitalId) {
    return userId.toString() + "_" + campaignProductDigitalId.toString();
  }

  public static DateTimeFormatter genyyMMDDDateTimeFormatter() {
    return DateTimeFormatter.ofPattern("yyyyMMdd");
  }
}
