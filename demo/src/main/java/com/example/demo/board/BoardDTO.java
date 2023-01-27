package com.example.demo.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BoardDTO {
    private String title;
    private String category;
    private String context;
    private Long account;
}
