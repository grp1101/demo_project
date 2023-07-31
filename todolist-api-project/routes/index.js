const {json} = require('express');
var express = require('express');
var router = express.Router();


var movies = require('../movies.json');


router.get('/movies', function (req, res) {
    res.send(movies);
    console.log(movies);
});


/* GET home page. */
router.get('/', function (req, res, next) {
    res.render('index', {title: 'Express'});
});

module.exports = router;
