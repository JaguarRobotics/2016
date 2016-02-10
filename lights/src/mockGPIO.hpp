#ifndef FRC1810_2016_LIGHTS_MOCKGPIO_HPP
#define FRC1810_2016_LIGHTS_MOCKGPIO_HPP
#include <time.h>
#include "GPIO.hpp"

struct oscilliscopeEvent {
    int pin;
    bool value;
    struct timespec time;
};
typedef struct oscilliscopeEvent oscilliscopeEvent_t;

class mockGPIO : public GPIO {
    public:
        virtual ~mockGPIO();
        virtual bool init();
        virtual void setInput(int);
        virtual void setOutput(int);
        virtual bool getPin(int);
        virtual void setPin(int, bool);
    
    private:
        oscilliscopeEvent_t *oscilliscope;
        oscilliscopeEvent_t *oscilliscopePtr;
        oscilliscopeEvent_t *oscilliscopeEnd;
};
typedef class mockGPIO mockGPIO_t;

#endif
