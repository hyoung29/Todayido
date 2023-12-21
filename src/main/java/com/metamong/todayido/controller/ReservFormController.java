package com.metamong.todayido.controller;
import com.metamong.todayido.dto.ReservDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// Reservation 클래스 정의


@Slf4j
@Controller
@RequestMapping("/reservation")
public class ReservFormController {

    private ReservDto reservation = new ReservDto();

    @GetMapping("/show")
    public String showReservation(Model model) {
        model.addAttribute("reservation", reservation);
        return "index";
    }

    @PostMapping("/create")
    public String createReservation(@ModelAttribute("newReservation") ReservDto newReservation, Model model) {
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
    public String editReservation(@ModelAttribute("editedReservation") ReservDto editedReservation, Model model) {
        reservation = editedReservation;
        model.addAttribute("reservation", reservation);
        return "index";
    }

    @GetMapping("/cancel")
    public String cancelReservation(Model model) {
        reservation = new ReservDto(); // Reset reservation data
        model.addAttribute("reservation", reservation);
        return "index";
    }

    @GetMapping("/map")
    public String map(int a, int b, Model model){
        log.info("map");
        Map<String, Integer> lmap = new HashMap<>();
        lmap.put("a", a);
        lmap.put("b", b);
        model.addAttribute("lmap", lmap);
        return "map";
    }


}
