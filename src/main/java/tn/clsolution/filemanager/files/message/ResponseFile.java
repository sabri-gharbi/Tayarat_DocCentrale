package tn.clsolution.filemanager.files.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ResponseFile {
    private String id;
    private String name;
    private String type;
    private Long size;

    public ResponseFile(String id, String name, String type, Long size) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
    }
}
