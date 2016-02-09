#ifndef FRC1810_2016_LIGHTS_GPIO_HPP
#define FRC1810_2016_LIGHTS_GPIO_HPP

class GPIO {
    public:
        virtual bool init() = 0;
        virtual void setInput(int) = 0;
        virtual void setOutput(int) = 0;
        virtual bool getPin(int) = 0;
        virtual void setPin(int, bool) = 0;
};
typedef class GPIO GPIO_t;

#endif
