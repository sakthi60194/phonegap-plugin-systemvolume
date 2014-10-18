var exec = require('cordova/exec');

module.exports = {

    setSystemVolume: function(volume) {
    	alert("hello");
        exec(null, null, "SystemVolume", "setSystemVolume", [volume]);
    },
};