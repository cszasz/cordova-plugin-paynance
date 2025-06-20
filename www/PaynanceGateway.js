var exec = require('cordova/exec');

exports.openGateway = function (params, success, error) {
    alert('Opening Paynance Gateway with params: ' + JSON.stringify(params));
    exec(success, error, 'PaynanceGateway', 'openGateway', [params]);
};
