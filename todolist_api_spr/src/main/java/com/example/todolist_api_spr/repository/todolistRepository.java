package com.example.todolist_api_spr.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.todolist_api_spr.vo.todolistVo;

import java.util.HashMap;
import java.util.List;

@Repository("todolistMapper")
public class todolistRepository {

    @Autowired
    SqlSession session;
    public List<todolistVo> findAll(){
        return session.selectList("todolistMapper.findAll");
    };

    public int saveTodo(todolistVo body){
        return session.insert("todolistMapper.saveTodo" , body);
    };

    public int deleteTodo(HashMap<String , String> body){
        return session.delete("todolistMapper.deleteTodo" , body);
    };

    public int updateTodo(todolistVo body){
        return session.update("todolistMapper.updateTodo" , body);
    };

    public int AlldeleteTodo(){
        return session.delete("todolistMapper.AlldeleteTodo");
    };


}
