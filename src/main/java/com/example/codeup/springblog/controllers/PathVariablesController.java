//package com.example.codeup.springblog.controllers;
//
//import com.example.codeup.springblog.Detail;
//import com.example.codeup.springblog.Item;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class PathVariablesController {
//
//    @GetMapping("/pathvars")
//    public String start(Model model) {
//        List<Item> items = new ArrayList<>();
//        items.add(new Item(1, "Item 1"));
//        items.add(new Item(2, "Item 2"));
//        model.addAttribute("items", items);
//        return "pathvars/index";
//    }
//
//
//    @GetMapping("/pathvars/single/{id}")
//    public String singlePathVariable(@PathVariable("id") int id, Model model) {
//        if (id == 1) {
//            model.addAttribute("item", new Item(1, "Item 1"));
//        } else {
//            model.addAttribute("item", new Item(2, "Item 2"));
//        }
//        return "pathvars/index";
//
//    }
//
//    @GetMapping("/pathvars/item/{itemId}/detail/{detailId}")
//    public String multiplePathVariable(@PathVariable("itemId") int itemId,
//                                       @PathVariable("detailId") int detailId,
//                                        Model model) {
//        for (Item item : items) {
//            if (item.getId() == itemId) {
//                model.addAttribute("item", item);
//                for (Detail detail : item.getDetails()) {
//                    if (detail.getId() == detailId) {
//                        model.addAttribute("detail", detail);
//                    }
//                }
//                }
//            }
//        return "pathvars/index";
//    }
//}
