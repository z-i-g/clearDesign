package ru.zig.service.seventeenthtask;

public class ExternalSystemPostImplRequest implements HttpPostProcessing {
    private final String applicationNumber;
    private final String body;
    private final String uri;
    private final String globalId;

    private ExternalSystemPostImplRequest(String applicationNumber, String body, String uri, String globalId) {
        this.applicationNumber = applicationNumber;
        this.body = body;
        this.uri = uri;
        this.globalId = globalId;
    }

    public static ExternalSystemPostImplRequest create(ExternalServiceContext context) {
        return new ExternalSystemPostImplRequest(context.getApplicationNumber(), context.getBody(), context.getUri(), context.getGlobalId());
    }

    @Override
    public String applicationNumber() {
        return this.applicationNumber;
    }

    @Override
    public String body() {
        return this.body;
    }

    @Override
    public String globalId() {
        return this.globalId;
    }

    @Override
    public String actionDescription() {
        return "Вызов внешнего сервиса по заявке %s".formatted(this.applicationNumber);
    }

    @Override
    public String uri() {
        return this.uri;
    }
}