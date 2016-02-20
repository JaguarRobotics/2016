#include "lib.h"
#include "calculations.h"
#include "patterns.h"

#define VALUE LOW

CRGB calculateLED(int frame, int led) {
  if ( digitalRead(CTRL0) == VALUE ) {
    if ( digitalRead(CTRL1) == VALUE ) {
      if ( digitalRead(CTRL2) == VALUE ) {
        if ( digitalRead(CTRL3) == VALUE ) {
          return pattern0(frame, led);
        } else {
          return pattern1(frame, led);
        }
      } else {
        if ( digitalRead(CTRL3) == VALUE ) {
          return pattern2(frame, led);
        } else {
          return pattern3(frame, led);
        }
      }
    } else {
      if ( digitalRead(CTRL2) == VALUE ) {
        if ( digitalRead(CTRL3) == VALUE ) {
          return pattern4(frame, led);
        } else {
          return pattern5(frame, led);
        }
      } else {
        if ( digitalRead(CTRL3) == VALUE ) {
          return pattern6(frame, led);
        } else {
          return pattern7(frame, led);
        }
      }
    }
  } else {
    if ( digitalRead(CTRL1) == VALUE ) {
      if ( digitalRead(CTRL2) == VALUE ) {
        if ( digitalRead(CTRL3) == VALUE ) {
          return pattern8(frame, led);
        } else {
          return pattern9(frame, led);
        }
      } else {
        if ( digitalRead(CTRL3) == VALUE ) {
          return pattern10(frame, led);
        } else {
          return pattern11(frame, led);
        }
      }
    } else {
      if ( digitalRead(CTRL2) == VALUE ) {
        if ( digitalRead(CTRL3) == VALUE ) {
          return pattern12(frame, led);
        } else {
          return pattern13(frame, led);
        }
      } else {
        if ( digitalRead(CTRL3) == VALUE ) {
          return pattern14(frame, led);
        } else {
          return pattern15(frame, led);
        }
      }
    }
  }
}

