package ru.zig.service.seventeenthtask;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class ExternalServiceContext {
    private final String applicationNumber;
    private final String body;
    private final String uri;
    private final String globalId;
}