package ru.zig.service.eleventhtask;

import java.util.List;

//@Service
public class MaestroRsProcessing {
    // при использовании интерфейсов все реализации автоматически внедряются механизмами spring
    private final List<ParticipantInfoParser> participantInfoParserList;

    public MaestroRsProcessing(List<ParticipantInfoParser> participantInfoParserList) {
        this.participantInfoParserList = participantInfoParserList;
    }
}