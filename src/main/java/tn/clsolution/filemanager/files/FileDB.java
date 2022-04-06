package tn.clsolution.filemanager.files;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name = "File")
@Getter
@Setter
@NoArgsConstructor
public class FileDB {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;
    private String type;
    private Long size;
    @Lob
    private byte[] data;
    private String contentType;

    public FileDB(String name, String type, Long size, byte[] data, String contentType) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.data = data;
        this.contentType = contentType;
    }
}
