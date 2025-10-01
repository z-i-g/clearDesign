package ru.zig.service.seventhtask;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

@Slf4j
public class DateExample {
    // Используем вместо SimpleDateFormat, DateTimeFormatter потокобезопасен и можно вынести как поле класса
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ROOT);

    public static void main(String[] args) {
        // Можно вынести как параметр и далее обернуть в try catch для контроля ошибок
        String dateString = "2024-05-13 14:30:00";

        try {
            // Вместо Date используем LocalDateTime
            LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
            // Добавляем временную зону, например, системную
            ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
            System.out.println("ZonedDateTime: " + zonedDateTime);
        } catch (DateTimeParseException ex) {
            log.error("Ошибка преоброзования даты: {}", dateString);
            ex.getLocalizedMessage();
        }
    }
}