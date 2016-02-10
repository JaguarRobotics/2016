#include <stdio.h>
#include <stdint.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/mman.h>
#include <sys/types.h>
#include <sys/stat.h>
#include "PiGPIO.hpp"

bool PiGPIO::init() {
    int memfd = open("/dev/mem", O_RDWR | O_SYNC);
    if ( memfd < 0 ) {
        fputs("Can not open /dev/mem.\n", stderr);
        return false;
    }
    void *map = mmap(
        NULL,
        4 * 1024, // Block size
        PROT_READ | PROT_WRITE,
        MAP_SHARED,
        memfd,
        0x20200000 // GPIO base address
    );
    close(memfd);
    if ( map == MAP_FAILED ) {
        fprintf(stderr, "MMap failed to map memory: %d.\n", (int) (intptr_t) map);
        return false;
    }
    gpio = (volatile unsigned *) gpio;
    return true;
}

void PiGPIO::setInput(int pin) {
    *(gpio + pin / 10) &= ~(7 << ((pin % 10) * 3));
}

void PiGPIO::setOutput(int pin) {
    setInput(pin);
    *(gpio + pin / 10) |= (1 << ((pin % 10) * 3));
}

bool PiGPIO::getPin(int pin) {
    return *(gpio + 13) & (1 << pin);
}

void PiGPIO::setPin(int pin, bool val) {
    *(gpio + (val ? 7 : 10)) = 1 << pin;
}
