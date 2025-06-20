var exec = require('cordova/exec');

exports.openGateway = function (params, success, error) {
    exec(success, error, 'PaynanceGateway', 'openGateway', [params]);
};
