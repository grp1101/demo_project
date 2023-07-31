var express = require('express');
var router = express.Router();
var movies = require('../movies.json');

const maria = require('../database/connect/maria');


// router.get('/parent_list', function (req, res, next) {
//  res.json([{ text: "list1" }, { text: "list2" }, { text: "list3" }]);
// });


// router.get('/input_list', function (req, res, next) {
// //  res.json([{ text:  }]);
// console.log(req);
// console.log("-------------------------------");
// console.log(req.query.work);

// res.json(req.query.work);


// //데이터 가져오는 법 
// 	// const { ex1 , ex2 } = req.query; // res.query에서 params를 접근한다.
// 	// const data = '반환'	
// 	// res.status(200).json(data);

// });


//업데이트 추가하기 (체크 여부, 수정 여부)
// router.get('/child_list_checked', function (req, res, next) {
//     console.log(req.query.checked);
//     console.log(req);
//     res.json(req.query.checked);
// });


// router.get('/child_list_delete', function (req, res, next) {
//     console.log(req.query.work);
//  res.json( { "index" : req.query.index, "work" :req.query.work});
// });


// router.get('/remove_list', function (req, res, next) {
//  res.json([]);
// });


// post
// post
// post
// post

router.post('/parent_list', function (req, res, next) {
    console.log("/parent_list");
//  res.json([{ text: "1" }, { text: "list2" }, { text: "list3" }]);
    maria.query('select todo_seq,content,checked from todo;', function (err, rows, fields) {
        if (!err) {
            console.log("-------------------------------");
            console.log("mariadb select 성공");
            console.log(rows);
            res.json(rows);
        } else {
            console.log("mariadb 조회 실패");
            console.log(err);
        }
    })

});

router.post('/input_list', function (req, res, next) {
    console.log("/input_list");
// res.json(req.body.content);

    const params = req.body;
    console.log("params.work = " + params.content);
    maria.query('INSERT INTO todo (complete,content,checked) VALUES (? , ? , ?);', [1, params.content, 0], function (err, rows, fields) {
        if (!err) {
            console.log("-------------------------------");
            console.log("mariadb insert 성공");
            console.log("rows.insertid = ", rows.insertId);
            res.json({"content": req.body.content, "todo_seq": rows.insertId, "checked": 0});
            console.log("json = ", res.json);
        } else {
            console.log("mariadb 조회 실패");
            console.log(err);
        }
    })

});


router.post('/child_list_checked', function (req, res, next) {
    console.log('/child_list_checked');
    console.log('----------------------------');
    console.log(req.body);

    maria.query('update todo set checked = ? where todo_seq=? ;', [req.body.checked, req.body.todo_seq], function (err, rows, fields) {
        if (!err) {
            console.log("-------------------------------");
            console.log("mariadb update 성공");
            res.json([{
                "todo_seq": req.body.todo_seq,
                "content": req.body.content,
                "checked": req.body.checked
            }, {"index": req.body.index}]);

        } else {
            console.log("mariadb 조회 실패");
            console.log(err);
        }
    })


});


router.post('/child_list_delete', function (req, res, next) {
    console.log('child_list_delete');
    console.log('req.body.todo_seq = ' + req.body.todo_seq);
    maria.query('DELETE FROM todo where todo_seq= ?;', [req.body.todo_seq], function (err, rows, fields) {
        if (!err) {
            console.log("-------------------------------");
            console.log("mariadb delete(one content) 성공");
            res.json([{"todo_seq": req.body.todo_seq, "content": req.body.content}, {"index": req.body.index}]);
        } else {
            console.log("mariadb 조회 실패");
        }
    })
});


router.post('/remove_list', function (req, res, next) {
    console.log("/remove_list");
    maria.query('DELETE FROM todo;', function (err, rows, fields) {
        if (!err) {
            console.log("-------------------------------");
            console.log("mariadb delete(clear All) 성공");
            res.json([]);
        } else {
            console.log("mariadb 조회 실패");
        }
    })

});


// router.get('/:id', function (req, res, next) {
//  var id = parseInt(req.params.id, 10)
//  var movie = movies.filter(function (movie) {
//  return movie.id === id
//  });
//  res.send(movie)
// });


module.exports = router;