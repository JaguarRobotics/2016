#include <stdio.h>
#include <string.h>
#include <sys/utsname.h>
#include "systemDetect.hpp"
#include "PiGPIO.hpp"
#include "mockGPIO.hpp"

#define RPI_MACHINE "armv7l"

GPIO_t *gpio;

bool detectSystemGPIO() {
    if ( !gpio ) {
        struct utsname sys;
        if ( uname(&sys) != 0 ) {
            fputs("Unable to get uname of system.\n", stderr);
            return false;
        }
        if ( strcmp(sys.machine, RPI_MACHINE) == 0 ) {
            gpio = new PiGPIO_t();
        } else {
            gpio = new mockGPIO_t();
        }
    }
    return true;
}

GPIO_t *getSystemGPIO() {
    if ( !gpio ) {
        if ( !detectSystemGPIO() ) {
            return NULL;
        }
    }
    return gpio;
}
