function ddd() {
    console.log("mylib is init!")
    this.mainActiveIndex = null;

}

ddd.prototype.handleSelect = function (key, keyPath) {
    console.log(key);
    console.log(keyPath);
    temp = key;
    if (key == "1") {
        window.location.href = 'index.html';
    } else if (key == "3") {
        window.location.href = 'records.html';
    } else if (key == "4") {
        window.location.href = 'applation.html';
    } else if (key == "0") {
        window.location.href = 'login.html';
    } else {
        if (key == "2-1") {
            window.location.href = 'addDevice.html';
        } else if (key == "2-2") {
            window.location.href = 'device.html';

        } else if (key == "2-3") {
            window.location.href = 'realControl.html';
        }
    }
}
ddd.prototype.mainActiveIndex = function () {
    return temp;
}
$dsc = function $dsc() {
    return new ddd();
}
