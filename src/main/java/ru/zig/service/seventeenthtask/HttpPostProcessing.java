package ru.zig.service.seventeenthtask;

public interface HttpPostProcessing extends HttpProcessing{
    String applicationNumber();

    String body();

    String globalId();
}