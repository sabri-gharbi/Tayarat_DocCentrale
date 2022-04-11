package tn.clsolution.doccentrale.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDTO {

    private String id;
    private String name;
    private String type;
    private Long size;


    private Long document;
}
