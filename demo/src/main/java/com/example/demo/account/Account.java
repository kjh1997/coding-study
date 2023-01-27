package com.example.demo.account;

import com.example.demo.Role;
import com.example.demo.board.Board;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Account {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "account_id")
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "account")
    private List<Board> boardList;
}
