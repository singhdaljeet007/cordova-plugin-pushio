var exec = require('cordova/exec');

var PLUGIN_NAME = 'pushio';

var pushio = {
  register: function (user_id, cb) {
    exec(cb, null, PLUGIN_NAME, 'register', [user_id]);
  },
  init: function (imei_no, cb) {
    exec(cb, null, PLUGIN_NAME, 'init', [imei_no]);
  },
  getNotificationData : function (cb) {
    exec(cb, null, PLUGIN_NAME, 'getNotificationData', []);
  }
};
module.exports = pushio;
