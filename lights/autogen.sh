#!/bin/sh

aclocal
autoconf
automake --add-missing
automake
./configure
make
