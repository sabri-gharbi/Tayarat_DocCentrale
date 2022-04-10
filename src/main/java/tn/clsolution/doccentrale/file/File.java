package tn.clsolution.doccentrale.file;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import tn.clsolution.doccentrale.document.Document;

import javax.persistence.*;


@Entity
@Table(name = "file")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class File {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long size;

    @Lob
    @Column(nullable = false)
    private byte[] data;

    @ManyToOne()
    @JoinColumn(name = "document_id")
    private Document document;
}
