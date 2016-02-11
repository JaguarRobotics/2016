#include <stdio.h>
#include <string.h>
#include <sys/utsname.h>
#include "systemDetect.hpp"
#include "PiGPIO.hpp"
#include "mockGPIO.hpp"

#define RPI_2_MACHINE "armv7l"
#define RPI_2_OFFSET 0x3F200000
#define RPI_0_MACHINE "armv6l"
#define RPI_0_OFFSET 0x20200000

GPIO_t *gpio;

bool detectSystemGPIO() {
    if ( !gpio ) {
        struct utsname sys;
        if ( uname(&sys) != 0 ) {
            fputs("Unable to get uname of system.\n", stderr);
            return false;
        }
        if ( strcmp(sys.machine, RPI_2_MACHINE) == 0 ) {
            gpio = new PiGPIO_t(RPI_2_OFFSET);
        } else if ( strcmp(sys.machine, RPI_0_MACHINE) == 0 ) {
            gpio = new PiGPIO_t(RPI_0_OFFSET);
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
