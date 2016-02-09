#include "mockGPIO.hpp"

bool mockGPIO::init() {
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
}
