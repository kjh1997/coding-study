package com.example.demo.board;


import com.example.demo.NotFoundUserProfileException;
import com.example.demo.account.Account;
import com.example.demo.account.AccountRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final AccountRespository accountRespository;



    public void saveBoard(BoardDTO boardDTO) {

        System.out.println(accountRespository.existsById(boardDTO.getAccount()));
        if (accountRespository.existsById(boardDTO.getAccount())) {
            System.out.println(boardDTO.getAccount());

            Optional<Account> account = accountRespository.findById(boardDTO.getAccount());

            System.out.println(account.get().getName());
            Board board = Board.builder()
                    .account(account.get())
                    .title(boardDTO.getTitle())
                    .category(boardDTO.getCategory())
                    .context(boardDTO.getContext())
                    .build();
            boardRepository.save(board);

        } else{
            throw new NotFoundUserProfileException();
        }


    }

    public Page<Board> getBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Page<Board> getBoardListByTitle(Pageable pageable, String q) {
        return boardRepository.findByTitle(pageable, q);
    }




}
