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
    time->tv_sec += time->tv_nsec / 1000000000;
    time->tv_nsec %= 1000000000;
}

void highResSleep(struct timespec time) {
    struct timespec now = getTime();
    now.tv_sec += time.tv_sec;
    now.tv_nsec += time.tv_nsec;
    highResSleepTo(time);
}

void highResSleepTo(struct timespec time) {
    struct timespec now;
    fillTime(&now);
//    struct timespec ossleep;
//    ossleep.tv_sec = time.tv_sec - now.tv_sec;
//    ossleep.tv_nsec = time.tv_nsec - now.tv_nsec;// - 100;
//    while ( ossleep.tv_nsec < 0 ) {
//        ossleep.tv_nsec += 1000000000;
//        --ossleep.tv_sec;
//    }
//    sleep(ossleep.tv_sec);
//    nanosleep(&ossleep, NULL);
    do {
        fillTime(&now);
    } while ( now.tv_sec <= time.tv_sec && (now.tv_sec != time.tv_sec || now.tv_nsec < time.tv_nsec) );
    /*
    while ( now.tv_sec < time.tv_sec || now.tv_nsec < time.tv_nsec || (now.tv_sec == time.tv_sec && now.tv_nsec < time.tv_nsec) ) {
        if ( now.tv_sec < time.tv_sec ) {
            //sleep(time.tv_sec - now.tv_sec - 1);
        } else if ( time.tv_nsec - now.tv_nsec > 2000 ) {
            //usleep((time.tv_nsec - now.tv_nsec) / 1000 - 1);
        }
        fillTime(&now);
    }
    */
}
