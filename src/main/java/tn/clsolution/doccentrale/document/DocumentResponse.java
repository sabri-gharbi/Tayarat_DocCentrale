package tn.clsolution.doccentrale.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.clsolution.doccentrale.file.FileDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentResponse {
    private Long id;
    private String title;
    private String type;
    private String reference;
    private String revision;
    private String item;
    private String customerClassification;
    private String prerogative;
    private String responsible;
    private String transmitter;
    private String ata;
    private String serviceLevel;
    private Long Costs;
    private Long immobility;
    private Long workforce;
    private Long preparation;
    private LocalDateTime date;
    private String applicationType;
    private String etops;
    private String category;
    private String classification;
    private Boolean sleeping;
    private Boolean impactOPS;
    private Boolean impactMTC;

    private List<FileDTO> files= new ArrayList<>();
}
