#ifndef FRC1810_2016_LIGHTS_PIGPIO_HPP
#define FRC1810_2016_LIGHTS_PIGPIO_HPP
#include "GPIO.hpp"

class PiGPIO : public GPIO {
    public:
        virtual bool init();
        virtual void setInput(int);
        virtual void setOutput(int);
        virtual bool getPin(int);
        virtual void setPin(int, bool);
    
    private:
        volatile unsigned *gpio;
};
typedef class PiGPIO PiGPIO_t;

#endif
