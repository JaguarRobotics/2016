#include <stdio.h>
#include <time.h>
#include "GPIO.hpp"
#include "systemDetect.hpp"
#include "timer.h"

#define DATA_PIN 14
//#define FAST_MODE

#ifdef FAST_MODE
#define T0H 250
#define T1H 600
#define T0L 1000
#define T1L 650
#define RES 50000
#else
#define T0H 500
#define T1H 1200
#define T0L 2000
#define T1L 1300
#define RES 50000
#endif

void send0(GPIO_t *gpio, struct timespec *time) {
    gpio->setPin(DATA_PIN, true);
    time->tv_nsec += T0H;
    normalizeTime(time);
    highResSleepTo(*time);
    gpio->setPin(DATA_PIN, false);
    time->tv_nsec += T0L;
    normalizeTime(time);
    highResSleepTo(*time);
}

void send1(GPIO_t *gpio, struct timespec *time) {
    gpio->setPin(DATA_PIN, true);
    time->tv_nsec += T1H;
    normalizeTime(time);
    highResSleepTo(*time);
    gpio->setPin(DATA_PIN, false);
    time->tv_nsec += T1L;
    normalizeTime(time);
    highResSleepTo(*time);
}

void sendReset(GPIO_t *gpio, struct timespec *time) {
    gpio->setPin(DATA_PIN, false);
    time->tv_nsec += RES;
    normalizeTime(time);
    highResSleepTo(*time);
}

void sendByte(GPIO_t *gpio, struct timespec *time, unsigned char val) {
    for ( unsigned char i = 7; i >= 0; --i ) {
        if ( val & (1 << i) ) {
            send1(gpio, time);
        } else {
            send0(gpio, time);
        }
    }
}

void sendColor(GPIO_t *gpio, struct timespec *time, unsigned char red, unsigned char green, unsigned char blue) {
    sendByte(gpio, time, red);
    sendByte(gpio, time, green);
    sendByte(gpio, time, blue);
}

int main(int argc, const char **argv) {
    //*
    if ( !detectSystemGPIO() ) {
        fputs("Unable to init GPIO code.\n", stderr);
        return 1;
    }
    GPIO_t *gpio = getSystemGPIO();
    gpio->init();
    gpio->setOutput(DATA_PIN);
    struct timespec time = getTime();
    while ( true ) {
        sendColor(gpio, &time, 255, 0, 0);
        sendColor(gpio, &time, 0, 255, 0);
        sendColor(gpio, &time, 0, 0, 255);
        sendReset(gpio, &time);
        time.tv_sec += 1;
        highResSleepTo(time);
        sendColor(gpio, &time, 0, 0, 255);
        sendColor(gpio, &time, 0, 255, 0);
        sendColor(gpio, &time, 255, 0, 0);
        sendReset(gpio, &time);
        time.tv_sec += 1;
        highResSleepTo(time);
    }
    return 0;
    // */
}
