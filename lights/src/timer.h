#ifndef FRC1810_2016_LIGHTS_TIMER_H
#define FRC1810_2016_LIGHTS_TIMER_H
#include <time.h>

#ifdef __cplusplus
extern "C" {
#endif

void fillTime(struct timespec *);
struct timespec getTime();

void normalizeTime(struct timespec *);

void highResSleep(struct timespec);
void highResSleepTo(struct timespec);

#ifdef __cplusplus
}
#endif

#endif
