package com.metamong.todayido.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Reservation 클래스 정의
class Reservation {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    // Getter, Setter, Constructors 등을 정의하세요.
}


@Getter
@Setter
@Slf4j
@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private Reservation reservation = new Reservation();

    @GetMapping("/show")
    public String showReservation(Model model) {
        model.addAttribute("reservation", reservation);
        return "index";
    }

    @PostMapping("/create")
    public String createReservation(@ModelAttribute("newReservation") Reservation newReservation, Model model) {
        reservation = newReservation;
        model.addAttribute("reservation", reservation);
        return "index";
    }

    @GetMapping("/edit")
    public String editReservationForm(Model model) {
        model.addAttribute("editedReservation", reservation);
        return "edit";
    }

    @PostMapping("/edit")
    public String editReservation(@ModelAttribute("editedReservation") Reservation editedReservation, Model model) {
        reservation = editedReservation;
        model.addAttribute("reservation", reservation);
        return "index";
    }

    @GetMapping("/cancel")
    public String cancelReservation(Model model) {
        reservation = new Reservation(); // Reset reservation data
        model.addAttribute("reservation", reservation);
        return "index";
    }
}
