package com.example.discord_clone_api.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class userController {

//    @Autowired
//    private todolistService _todolistService;
//
//    @RequestMapping(method = RequestMethod.POST, value ="/parent_list")
//    public List<todolistVo> select_todolist() {
//
//        System.out.println("/api/parent_list 실행");
//        List<todolistVo> list=_todolistService.select_todolist_service();
//
//        return list;
//    }
//
//    @PostMapping("/input_list")
//    public todolistVo insert_todolist(@RequestBody todolistVo body) {
//
//        System.out.println("/api/input_list 실행");
//        int insertCnt=_todolistService.insert_todolist_service(body);
//        todolistVo todo = new todolistVo();
//
//        if(insertCnt == 1){
//            return body;
//        }else{
//            return todo;
//        }
//    }
//
//    @PostMapping("/child_list_delete")
//    public ArrayList delete_todolist(@RequestBody HashMap<String , String> body) {
//
//        System.out.println("/api/child_list_delete 실행");
//        int deleteCnt=_todolistService.delete_todolist_service(body);
//        ArrayList<HashMap<String,String>> todo = new ArrayList();
//
//        if(deleteCnt==1){
//            todo.addAll(Collections.singleton(body));
//        }
//
//        return todo;
//    }
//
//
//    @PostMapping("/child_list_checked")
//    public todolistVo update_todolist(@RequestBody todolistVo body ) {
//
//        System.out.println("/api/child_list_checked 실행");
//
//        int updateCnt=_todolistService.update_todolist_service(body);
//        todolistVo todo = new todolistVo();
//
//        if(updateCnt == 1){
//            return body;
//        }else{
//            return todo;
//        }
//    }
//
//    @PostMapping("/remove_list")
//    public ArrayList all_delete_todolist() {
//
//        System.out.println("/api/remove_list 실행");
//        int AlldeleteCnt=_todolistService.all_delete_todolist_service();
//        ArrayList<HashMap<String,String>> todo = new ArrayList();
//
//        return todo;
//    }

}