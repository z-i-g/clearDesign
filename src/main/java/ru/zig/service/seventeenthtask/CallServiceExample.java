package ru.zig.service.seventeenthtask;

public class CallServiceExample {
    public static void main(String[] args) {
        ExternalServiceContext externalServiceContext = ExternalServiceContext.builder()
                .applicationNumber("testApplicationNumber")
                .body("test body")
                .uri("http://test-uri")
                .globalId("testGlobalId")
                .build();
        // Создаем реализацию для совершения POST запроса HttpProcessing -> HttpPostProcessing -> ExternalSystemPostImplRequest
        HttpPostProcessing externalHttpProcessing = ExternalSystemPostImplRequest.create(externalServiceContext);
        CallService callService = new CallService();
        callService.call(externalHttpProcessing);

    }
}