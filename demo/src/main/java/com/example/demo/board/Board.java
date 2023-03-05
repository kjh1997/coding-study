package com.example.demo.board;

import com.example.demo.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@Table(indexes = @Index(name = "idx_title", columnList = "title"))
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private Long id;


    private String title;
    private String category;
    private String context;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;


}
