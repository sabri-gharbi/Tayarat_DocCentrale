package tn.clsolution.filemanager.files;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileDBResponse {
    private String id;
    private String name;
    private String type;
    private Long size;
    private String contentType;
}
