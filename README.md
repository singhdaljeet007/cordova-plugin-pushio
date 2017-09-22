# cordova-plugin-pushio

Installation

$ cordova plugin add https://github.com/singhdaljeet007/cordova-plugin-pushio.git


Usage

in app.component.ts

declare var pushio: any;

@Component({
templateUrl: 'app.html'
})
export class MyApp {
...

// registreing you device to push IO
registerPushIo()
{
	let deviceImei = <Your Device Id/IMEI>
	pushio.init(deviceImei);
}
...

}

NB: Registering your device to push IO requires working internet connection.
Don’t forget adding connectivity check.

You’re all set.



