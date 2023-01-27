package com.example.demo.board;

import com.example.demo.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.QueryParameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/save")
    public ResponseEntity<BaseResponse> saveBoard(@RequestBody BoardDTO boardDTO) {
        boardService.saveBoard(boardDTO);

        return ResponseEntity.ok(new BaseResponse<>(200, "성공적으로 작성하였습니다."));
    }

    @GetMapping("/list")
    public ResponseEntity<BaseResponse> getBoardList(
            @PageableDefault(size = 10, sort = "board_id", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam("q") String q
    ) {
        if (q != null) {
            Page<Board> result = boardService.getBoardList(pageable);
            return ResponseEntity.ok(new BaseResponse<>(200, "success", result));
        }
        Page<Board> result = boardService.getBoardList(pageable);
        return ResponseEntity.ok(new BaseResponse<>(200, "success", result));
    }

}
