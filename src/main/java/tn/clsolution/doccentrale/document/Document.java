package tn.clsolution.doccentrale.document;

import lombok.*;
import tn.clsolution.doccentrale.file.File;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "document")
    private List<File> files=new ArrayList<>();

}
