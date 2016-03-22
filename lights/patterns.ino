#include "constants.h"
#include "lib.h"
#include "patterns.h"

#include "java2c.h"
#include "formula.h"
#include "src/main/java/org/usd232/robotics/lights/simulator/Formula.java"
#include "java2c_cleanup.h"

// long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2
#define _CONCAT(a, b) a ## b
#define CONCAT(a, b) _CONCAT(a, b)
#define PATTERN(index, number, underPattern, custom1, custom2) \
inline CRGB CONCAT(pattern, index)(long frame, int led) { \
  return CONCAT(pattern, number)(frame, led, NUM_LEDS, const_cast<char *>(underPattern), custom1, custom2); \
}
#define SIMPLE_PATTERN(index, number) PATTERN(index, number, "", 0, 0);

SIMPLE_PATTERN(0, 0)
SIMPLE_PATTERN(1, 1)
SIMPLE_PATTERN(2, 2)
SIMPLE_PATTERN(3, 3)
SIMPLE_PATTERN(4, 4)
SIMPLE_PATTERN(5, 5)
SIMPLE_PATTERN(6, 6)
SIMPLE_PATTERN(7, 7)
SIMPLE_PATTERN(8, 8)
SIMPLE_PATTERN(9, 9)
SIMPLE_PATTERN(10, 10)
SIMPLE_PATTERN(11, 11)
SIMPLE_PATTERN(12, 12)
SIMPLE_PATTERN(13, 13)
SIMPLE_PATTERN(14, 14)
SIMPLE_PATTERN(15, 16)

