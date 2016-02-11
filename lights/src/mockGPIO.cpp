#include <stdio.h>
#include <stdlib.h>
#include "mockGPIO.hpp"
#include "timer.h"

#define OSCILLISCOPE_EVENTS 300

mockGPIO::~mockGPIO() {
    if ( oscilliscope ) {
        free(oscilliscope);
    }
}

bool mockGPIO::init() {
    oscilliscope = (oscilliscopeEvent_t *) malloc(sizeof(oscilliscopeEvent_t) * OSCILLISCOPE_EVENTS);
    if ( !oscilliscope ) {
        fputs("Unable to allocate memory for virtual oscilliscope.\n", stderr);
        return false;
    }
    oscilliscopePtr = oscilliscope;
    oscilliscopeEnd = oscilliscope +  OSCILLISCOPE_EVENTS;
    return true;
}

void mockGPIO::setInput(int pin) {
}

void mockGPIO::setOutput(int pin) {
}

bool mockGPIO::getPin(int pin) {
    return false;
}

void mockGPIO::setPin(int pin, bool val) {
    if ( oscilliscopePtr < oscilliscopeEnd ) {
        oscilliscopePtr->pin = pin;
        oscilliscopePtr->value = val;
        fillTime(&oscilliscopePtr->time);
        ++oscilliscopePtr;
        if ( oscilliscopePtr >= oscilliscopeEnd ) {
            FILE *file = fopen("oscilliscope.dat", "w");
            if ( file ) {
                if ( fwrite(oscilliscope, OSCILLISCOPE_EVENTS, sizeof(oscilliscopeEvent_t), file) < 0 ) {
                    fputs("Unable to write oscilliscope file.\n", stderr);
                } else {
                    puts("Wrote oscilliscope data to file.\n");
                }
                fclose(file);
            } else {
                fputs("Unable to open oscilliscope file.\n", stderr);
            }
        }
    }
}
