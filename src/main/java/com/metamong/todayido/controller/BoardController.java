package com.metamong.todayido.controller;

import com.metamong.todayido.dto.BoardDto;
import com.metamong.todayido.dto.BoardFileDto;
import com.metamong.todayido.dto.SearchDto;
import com.metamong.todayido.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@Slf4j



//메인페이지에서 문의사항클릭하면 문의사항 리스트 페이지로 이동
public class BoardController {
    @GetMapping("qnalist")
    public String qnalist() {
        log.info("qnalist()");
        return "qnalist";
    }

    // 글쓰기 폼 페이지
    @GetMapping("qnaWrite")
    public String qnaWrite() {
        log.info("qnaWrite");
        return "qnaWrite";
    }

    //글쓰기 프로세스 완료되면 list페이지로 이동
    @PostMapping("writeProc") //sQnaWriteFroc
    public String writeProc(@RequestPart List<MultipartFile> files, BoardDto board, HttpSession session, RedirectAttributes rttr) {
        log.info("writeProc()");
        String view = bServ.boardWrite(files, board, session, rttr);
        return view;
    }

    //글 상세 조회 메소드
    @GetMapping("boardDetail")
    public ModelAndView boardDetail(int b_num) {
        log.info("boardDetail() : {}", b_num);
        ModelAndView mv = bServ.getBoard(b_num);
        return mv;
    }


    @Autowired
    private BoardService bServ;


//    @GetMapping("boardList")
//    public ModelAndView boardList(SearchDto sdto, HttpSession session) {
//        log.info("boardList()");
//        ModelAndView mv = bServ.getBoardList(sdto, session);
//        return mv;
//    }

    //    //파일 다운로드
//    @GetMapping("download")
//    public ResponseEntity<Resource> fileDownload(BoardFileDto bfile, HttpSession session) throws IOException {
//        log.info("fileDownload()");
//        ResponseEntity<Resource> resp = bServ.fileDownload(bfile, session);
//        return resp;
//    }
//
//    @GetMapping("boardDelete")
//    public String boardDelete(int b_num, HttpSession session, RedirectAttributes rttr) {
//        log.info("boardDelete()");
//        String view = bServ.deleteBoard(b_num, session, rttr);
//        return view;
//    }
//
//    @GetMapping("updateForm")
//    public ModelAndView updateForm(int b_num) {
//        log.info("updateForm()");
//        ModelAndView mv = bServ.updateBoard(b_num);
//        return mv;
//    }
//
//    @PostMapping("updateProc")
//    public String updateProc(List<MultipartFile> files, BoardDto board, HttpSession session, RedirectAttributes rttr) {
//        log.info("updateProc()");
//        String view = bServ.updateBoard(files, board, session, rttr);
//        return view;
//    }
    @GetMapping("rCategory")
    public String rCategory() {
        log.info("rCategory()");
        return "rCategory";
    }

    @GetMapping("cCategory")
    public String cCategory() {
        log.info("cCategory()");
        return "cCategory";
    }

    @GetMapping("bCategory")
    public String bCategory() {
        log.info("bCategory()");
        return "bCategory";
    }

    @GetMapping("pCategory")
    public String pCategory() {
        log.info("pCategory()");
        return "pCategory";
    }

    @GetMapping("reservForm")
    public String reservForm(int a, int b, Model model) {
        log.info("reservForm()");
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        return "reservForm";
    }
}
