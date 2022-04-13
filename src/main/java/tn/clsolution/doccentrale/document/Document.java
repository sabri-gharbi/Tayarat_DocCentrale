package tn.clsolution.doccentrale.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.clsolution.doccentrale.file.File;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(nullable = true)
    private String type;
    @Column(nullable = true)
    private String reference;
    @Column(nullable = true)
    private String revision;
    @Column(nullable = true)
    private String item;
    @Column(nullable = true)
    private Boolean sleeping;
    @Column(nullable = true,length = 1)
    private String applicationType;
    @Column(nullable = true,length = 1)
    private String etops;
    @Column(nullable = true,length = 1)
    private String category;
    @Column(nullable = true,length = 1)
    private String classification;
    @Column(nullable = true)
    private String customerClassification;
    @Column(nullable = true)
    private String prerogative;
    @Column(nullable = true)
    private Long Costs;
    @Column(nullable = true)
    private String serviceLevel;
    @Column(nullable = true)
    private LocalDateTime date;
    @Column(nullable = true)
    private String responsible;
    @Column(nullable = true)
    private String transmitter;
    @Column(nullable = true)
    private String ata;
    @Column(nullable = true)
    private Boolean impactOPS;
    @Column(nullable = true)
    private Boolean impactMTC;
    @Column(nullable = true)
    private Long immobility;
    @Column(nullable = true)
    private Long workforce;
    @Column(nullable = true)
    private Long preparation;

    @OneToMany(mappedBy = "document",cascade = CascadeType.REMOVE)
    private List<File> files=new ArrayList<>();

}
