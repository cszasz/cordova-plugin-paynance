var exec = require('cordova/exec');

exports.openGateway = function (params, success, error) {
    exec(success, error, 'PaynanceGateway', 'openGateway', [params]);
};

exports.checkGateway = function (success, error) {
    exec(success, error, 'PaynanceGateway', 'checkGateway', []);
};