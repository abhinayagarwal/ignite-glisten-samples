package com.gluonhq.hello.service;

import javax.inject.Singleton;

@Singleton
public class Service {

    public String getText() {
        return "This text is INJECTED";
    }
}
