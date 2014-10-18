var exec = require('cordova/exec');

module.exports = {

    setSystemVolume: function(volume) {
        exec(null, null, "SystemVolume", "setSystemVolume", [volume]);
    },
    setNormalVolume: function(volume) {
        exec(null, null, "SystemVolume", "setNormalVolume", [volume]);
    },
};