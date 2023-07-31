package com.example.discord_clone_api.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("todolistMapper")
public class userRepository {

    @Autowired
    SqlSession session;
//    public List<todolistVo> findAll(){
//        return session.selectList("todolistMapper.findAll");
//    };

//    public int saveTodo(todolistVo body){
//        return session.insert("todolistMapper.saveTodo" , body);
//    };
//
//    public int deleteTodo(HashMap<String , String> body){
//        return session.delete("todolistMapper.deleteTodo" , body);
//    };
//
//    public int updateTodo(todolistVo body){
//        return session.update("todolistMapper.updateTodo" , body);
//    };
//
//    public int AlldeleteTodo(){
//        return session.delete("todolistMapper.AlldeleteTodo");
//    };


}
