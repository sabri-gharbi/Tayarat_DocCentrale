package tn.clsolution.doccentrale.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentDTO {
    private Long id;
    @NotEmpty(message = "document title must not be empty")
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
}
