#include <time.h>
#include <unistd.h>
#include "timer.h"

void fillTime(struct timespec *time) {
    clock_gettime(CLOCK_MONOTONIC_RAW, time);
}

struct timespec getTime() {
    struct timespec time;
    fillTime(&time);
    return time;
}

void normalizeTime(struct timespec *time) {
    time->tv_sec += time->tv_nsec / 1000000;
    time->tv_nsec %= 1000000;
}

void highResSleep(struct timespec time) {
    struct timespec now = getTime();
    now.tv_sec += time.tv_sec;
    now.tv_nsec += time.tv_nsec;
    highResSleepTo(time);
}

void highResSleepTo(struct timespec time) {
    normalizeTime(&time);
    struct timespec now;
    fillTime(&now);
    while ( now.tv_sec <= time.tv_sec || now.tv_nsec < time.tv_nsec ) {
        if ( now.tv_sec < time.tv_sec ) {
            sleep(time.tv_sec - now.tv_sec - 1);
        } else if ( time.tv_nsec - now.tv_nsec > 2000 ) {
            usleep((time.tv_nsec - now.tv_nsec) / 1000 - 1);
        }
        fillTime(&now);
    }
}
