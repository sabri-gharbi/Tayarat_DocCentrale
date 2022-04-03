package tn.clsolution.filemanager.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity(name = "Document")
@Getter
@Setter
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty(message = "fileId cant be empty")
    private String fileId;
    @NotEmpty(message = "dont mess up with me")
    private String name;
    @NotEmpty(message = "dont mess up with me")
    private String type;
    @NotNull
    @Min(value = 500, message = "file size y a5raa")
    private Long size;

    private String docType;
    private String docReference;
    private String docRevision;
    private String docItem;
    private String docTitle;
    private String docAppType;
    private String docRevisionDate;
    private String docATA;
    private String docTransmitterCode;

    public Document(String fileId, String name, String type, Long size, String docType, String docReference, String docRevision, String docItem, String docTitle, String docAppType, String docRevisionDate, String docATA, String docTransmitterCode) {
        this.fileId = fileId;
        this.name = name;
        this.type = type;
        this.size = size;
        this.docType = docType;
        this.docReference = docReference;
        this.docRevision = docRevision;
        this.docItem = docItem;
        this.docTitle = docTitle;
        this.docAppType = docAppType;
        this.docRevisionDate = docRevisionDate;
        this.docATA = docATA;
        this.docTransmitterCode = docTransmitterCode;
    }
}
