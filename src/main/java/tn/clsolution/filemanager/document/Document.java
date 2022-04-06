package tn.clsolution.filemanager.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
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
    @NotEmpty(message = "fileName cant be empty")
    private String name;
    @NotEmpty(message = "fileType cant be empty")
    private String type;
    @NotNull
    @Max(value =5000000 , message = "File too large!")
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

}
