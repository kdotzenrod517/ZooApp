package com.example.kdotz.zoo.utils;

import com.squareup.otto.Bus;

/**
 * Created by kdotz on 5/8/2017.
 */

public class EventBus extends Bus {
    private static final EventBus bus = new EventBus();

    public static Bus getInstance() {return bus;}

    private EventBus() {}
}
