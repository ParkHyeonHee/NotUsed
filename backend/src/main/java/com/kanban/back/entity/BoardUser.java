package com.kanban.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kanban.back.dto.reponseDTO.mainpageDTO.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "board_user")
public class BoardUser {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "b_id", referencedColumnName = "b_id")
    @JsonIgnore
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "u_id", referencedColumnName = "u_id")
    })
    @JsonIgnore
    private UserTable userTable;

    @Id
    private Integer board_user_id;
    public BoardUserMainDTO toMainDTO(){
        return BoardUserMainDTO.builder()
                .board(board)
                .userTable(userTable)
                .board_user_id(board_user_id)
                .build();
    }

}
