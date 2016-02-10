#ifndef FRC1810_2016_LIGHTS_MOCKGPIO_HPP
#define FRC1810_2016_LIGHTS_MOCKGPIO_HPP
#include "GPIO.hpp"

class mockGPIO : public GPIO {
    public:
        virtual bool init();
        virtual void setInput(int);
        virtual void setOutput(int);
        virtual bool getPin(int);
        virtual void setPin(int, bool);
};
typedef class mockGPIO mockGPIO_t;

#endif
