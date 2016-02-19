#include "lib.h"
#include "patterns.h"

CRGB pattern0(int frame, int led) {
  return CRGB(
              (frame / 8 % 6 + led) % 6 == 1 ? 255 : 0,
              (frame / 8 % 6 + led) % 6 == 0 ? 255 : 0,
              (frame / 8 % 6 + led) % 6 == 2 ? 255 : 0
             );
}

CRGB pattern1(int frame, int led) {
  return CRGB(255, 0, 0);
}

CRGB pattern2(int frame, int led) {
  return CRGB(0, 255, 0);
}

CRGB pattern3(int frame, int led) {
  return CRGB(0, 0, 255);
}

CRGB pattern4(int frame, int led) {
  return CRGB(255, 255, 0);
}

CRGB pattern5(int frame, int led) {
  return CRGB(0, 255, 255);
}

CRGB pattern6(int frame, int led) {
  return CRGB(255, 0, 255);
}

CRGB pattern7(int frame, int led) {
  return CRGB(255, 255, 255);
}

