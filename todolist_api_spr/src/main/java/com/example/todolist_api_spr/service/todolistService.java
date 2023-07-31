package com.example.todolist_api_spr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todolist_api_spr.repository.todolistRepository;
import com.example.todolist_api_spr.vo.todolistVo;

import java.util.HashMap;
import java.util.List;

@Service
public class todolistService {

    @Autowired
    private todolistRepository _todolistRepository;

    public List<todolistVo> select_todolist_service(){
        return _todolistRepository.findAll();
    }

    public int insert_todolist_service(todolistVo body){
        return _todolistRepository.saveTodo(body);
    }

    public int delete_todolist_service(HashMap<String , String> body){
        return _todolistRepository.deleteTodo(body);
    }

    public int update_todolist_service(todolistVo body){
        return _todolistRepository.updateTodo(body);
    }

    public int all_delete_todolist_service(){
        return _todolistRepository.AlldeleteTodo();
    }

}
