package com.example.todolist_api_spr.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class todolistVo {

    private int todo_seq;

    private String content;

    private int checked;

    private int index;

    private int complete;



    public todolistVo(int todo_seq) {
        this.todo_seq = todo_seq;
    }

    public todolistVo(int todo_seq, String content, int checked) {
        this.todo_seq = todo_seq;
        this.content = content;
        this.checked = checked;
    }





}
