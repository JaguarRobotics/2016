var targetHeight = 128;
var margin = 32;

var fr = new FileReader();
var oscilliscope = [];
var colors = [];

var fileChooser = document.getElementById("file");
var canvas = document.getElementById("canvas");
var context = canvas.getContext("2d");

function endianIndependentByte(a) {
    return a.charCodeAt(0);
}

function littleEndianShort(a, b) {
    return endianIndependentByte(a) + endianIndependentByte(b) * 256;
}

function littleEndianInt(a,  b,  c,  d) {
    return littleEndianShort(a, b) + littleEndianShort(c, d) * 65536;
}

function littleEndianLong(a,  b,  c,  d,  e,  f,  g,  h) {
    return littleEndianInt(a, b, c, d) + littleEndianInt(e, f, g, h) * 4294967296;
}

function endianIndependentBool(a) {
    return endianIndependentByte(a) != 0;
}

function paintOscilliscope(x, y, width, height, start, end, pin) {
    context.beginPath();
    context.strokeStyle = "#3F3F3F";
    context.lineWidth = 1;
    context.moveTo(x - margin, y);
    context.lineTo(x + width + margin, y);
    context.stroke();
    context.moveTo(x - margin, y + height);
    context.lineTo(x + width + margin, y + height);
    context.stroke();
    var min = oscilliscope[start].time.seconds + oscilliscope[start].time.nanos / 1000000000;
    var max = oscilliscope[end].time.seconds + oscilliscope[end].time.nanos / 1000000000;
    var scale = max - min;
    context.beginPath();
    context.strokeStyle = colors[oscilliscope[0].pin];
    context.lineWidth = 4;
    context.moveTo(x, y + height * oscilliscope[start].value);
    for ( var i = start; i <= end; ++i ) {
        if ( oscilliscope[i].pin == pin ) {
            var time = oscilliscope[i].time.seconds + oscilliscope[i].time.nanos / 1000000000 - min;
            var scaled = time / scale;
            context.lineTo(x + scaled * width, y + oscilliscope[i].value * height);
            context.lineTo(x + scaled * width, y + !oscilliscope[i].value * height);
        }
    }
    context.stroke();
}

function paintPin(width, height, bars, min, length, pin) {
    var start = 0;
    var bar = 1;
    var barHeight = (height - margin) / (bars - 1);
    for ( var i = 0; i < oscilliscope.length; ++i ) {
        var time = oscilliscope[i].time.seconds + oscilliscope[i].time.nanos / 1000000000 - min;
        if ( time > bar * length ) {
            paintOscilliscope(margin, margin + barHeight * (bar - 1), width - 2 * margin, barHeight - margin, start, i - 1, pin);
            start = i;
            ++bar;
        }
    }
}

function paint() {
    var width = canvas.width;
    var height = canvas.height;
    context.fillRect(0, 0, width, height);
    var bars = Math.round((height - margin) / (targetHeight + margin));
    var min = oscilliscope[0].time.seconds + oscilliscope[0].time.nanos / 1000000000;
    var max = oscilliscope[oscilliscope.length - 1].time.seconds + oscilliscope[oscilliscope.length - 1].time.nanos / 1000000000;
    var scale = max - min;
    var length = scale / bars;
    context.beginPath();
    context.strokeStyle = "#3F3F3F";
    context.lineWidth = 1;
    context.moveTo(width - margin, margin);
    context.lineTo(width - margin, height - margin);
    for ( var i = 0; i < length; i += 1 / 1000000 ) {
        context.moveTo(margin + (width - 2 * margin) * i / length, 0);
        context.lineTo(margin + (width - 2 * margin) * i / length, height);
    }
    context.stroke();
    var pins = [];
    for ( var i = 0; i < oscilliscope.length; ++i ) {
        if ( pins.indexOf(oscilliscope[i].pin) < 0 ) {
            pins.push(i);
            paintPin(width, height, bars, min, length, i);
        }
    }
}

function generateColors() {
    var c = [];
    var black = "#000000";
    for ( var i = 0; i < oscilliscope.length; ++i ) {
        if ( c.indexOf(oscilliscope[i].pin) < 0 ) {
            var color = Math.floor(Math.random() * 16777216).toString(16);
            c[oscilliscope[i].pin] = black.substring(0, black.length - color.length) + color;
        }
    }
    colors = c;
}

fr.onload = function() {
    var data = [];
    var binary = fr.result.split("");
    for ( var i = 0; i + 24 <= binary.length; ) {
        var entry = {
            "time": {}
        };
        entry.pin = littleEndianInt(binary[i], binary[i + 1], binary[i + 2], binary[i + 3]);
        i += 4;
        entry.value = endianIndependentBool(binary[i]);
        i += 4;
        entry.time.seconds = littleEndianLong(binary[i], binary[i + 1], binary[i + 2], binary[i + 3], binary[i + 4], binary[i + 5], binary[i + 6], binary[i + 7]);
        i += 8;
        entry.time.nanos = littleEndianLong(binary[i], binary[i + 1], binary[i + 2], binary[i + 3], binary[i + 4], binary[i + 5], binary[i + 6], binary[i + 7]);
        i += 8;
        data.push(entry);
    }
    oscilliscope = data;
    generateColors();
    paint();
};

function load() {
    fr.readAsBinaryString(fileChooser.files[0]);
}

canvas.width = canvas.clientWidth;
canvas.height = canvas.clientHeight;
context.fillStyle = "#00003F";
context.fillRect(0, 0, canvas.clientWidth, canvas.clientHeight);
load();
