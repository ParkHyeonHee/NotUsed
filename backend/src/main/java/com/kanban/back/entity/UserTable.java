package com.kanban.back.entity;

import com.kanban.back.dto.reponseDTO.mainpageDTO.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_table")
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
public class UserTable {
    @CreatedDate
    private LocalDateTime u_date_join;
    private String u_name;
    private String u_email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String u_id;
    @OneToMany(mappedBy = "userTable", cascade = CascadeType.REMOVE)
    private List<CardPartner> cardPartners;

    @OneToMany(mappedBy = "userTable")
    private List<Comment> comments;

    @OneToMany(mappedBy = "userTable", cascade = CascadeType.REMOVE)
    private List<TmpTable> tmpTables;

    @OneToMany(mappedBy = "userTable", cascade = CascadeType.REMOVE)
    private List<BoardUser> boardUsers;



    public UserTableMainDTO toMainDTO(){
        return UserTableMainDTO.builder()
                .u_date_join(u_date_join)
                .u_name(u_name)
                .u_email(u_email)
                .u_id(u_id)
                .cardPartners(cardPartners)
                .comments(comments)
                .tmpTables(tmpTables)
                .boardUsers(boardUsers)
                .build();
    }


}
