package com.example.discord_clone_api.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class userVo {

    private int todo_seq;

    private String content;

    private int checked;

    private int index;

    private int complete;



    public userVo(int todo_seq) {
        this.todo_seq = todo_seq;
    }

    public userVo(int todo_seq, String content, int checked) {
        this.todo_seq = todo_seq;
        this.content = content;
        this.checked = checked;
    }





}
