#include "lib.h"
#include "patterns.h"

CRGB pattern0(long frame, int led) {
  return CRGB(
              (frame / 8 % 6 + led) % 6 == 1 ? 255 : 0,
              (frame / 8 % 6 + led) % 6 == 0 ? 255 : 0,
              (frame / 8 % 6 + led) % 6 == 2 ? 255 : 0
             );
}

CRGB pattern1(long frame, int led) {
  return CRGB(255, 0, 0);
}

CRGB pattern2(long frame, int led) {
  return CRGB(0, 255, 0);
}

CRGB pattern3(long frame, int led) {
  return CRGB(0, 0, 255);
}

CRGB pattern4(long frame, int led) {
  return CRGB(255, 255, 0);
}

CRGB pattern5(long frame, int led) {
  return CRGB(0, 255, 255);
}

CRGB pattern6(long frame, int led) {
  return CRGB(255, 0, 255);
}

CRGB pattern7(long frame, int led) {
  return CRGB(255, 255, 255);
}

CRGB pattern8(long frame, int led) {
  return CRGB(
              (frame / 8 % 6 + led) % 6 == 1 ? 255 : 0,
              (frame / 8 % 6 + led) % 6 == 0 ? 255 : 0,
              (frame / 8 % 6 + led) % 6 == 2 ? 255 : 0
             );
}

CRGB pattern9(long frame, int led) {
  return CRGB(255, 0, 0);
}

CRGB pattern10(long frame, int led) {
  return CRGB(0, 255, 0);
}

CRGB pattern11(long frame, int led) {
  return CRGB(0, 0, 255);
}

CRGB pattern12(long frame, int led) {
  return CRGB(255, 255, 0);
}

CRGB pattern13(long frame, int led) {
  return CRGB(0, 255, 255);
}

CRGB pattern14(long frame, int led) {
  return CRGB(255, 0, 255);
}

CRGB pattern15(long frame, int led) {
  return CRGB(255, 255, 255);
}

