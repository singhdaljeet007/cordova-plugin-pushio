Cordova Pushio Plugin
======================

Installation
======================
$ ionic cordova plugin add https://github.com/singhdaljeet007/cordova-plugin-pushio.git

Usage
=======================
declare var pushio: any;
————————

@Component({
================

  templateUrl: 'app.html'
===================

})
=====================
export class MyApp {
================
….

pushio.init(deviceImei);

pushio.register(custId);

…

}

Supported Platforms

Android Only