package com.wonyoung.afterreading.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/main")
    public String main(Model model) throws IOException {
        List<CrawlEntity> bestSellerList = boardService.getBestSellerDatas();
        model.addAttribute("bestList", bestSellerList);
        return "board/main";
    }

}
