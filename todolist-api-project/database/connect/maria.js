const maria = require('mysql');

const conn = maria.createConnection({
    host: '125.133.48.203',
    port: 52099,
    user: 'heatmaster',
    password: 'rpn123!!',
    database: 'todolistdb'
});

module.exports = conn;