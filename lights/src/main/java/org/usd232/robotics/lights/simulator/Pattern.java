package org.usd232.robotics.lights.simulator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Pattern
{
    String getName();

    boolean isPattern();
}
