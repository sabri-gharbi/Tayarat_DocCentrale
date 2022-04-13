package tn.clsolution.doccentrale.document;

import org.mapstruct.*;
import tn.clsolution.doccentrale.file.File;
import tn.clsolution.doccentrale.file.FileDTO;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DocumentMapper {


    DocumentDTO documentToDTO(Document document);
    Document updateDocument(DocumentDTO documentDTO, @MappingTarget Document document);

    @Mapping(target = "files",ignore = true)
    DocumentResponse documentToDocumentResponse(Document document,@MappingTarget DocumentResponse documentResponse);

    @AfterMapping
    default void afterDocumentToDocumentResponse(Document document,@MappingTarget DocumentResponse documentResponse){
        final List<File> files=document.getFiles();
        if ( files != null ) {
           List<FileDTO> fileDTOS= files.stream().map(file -> new FileDTO(file.getId(), file.getName(),file.getType(), file.getSize(), file.getDocument().getId())).collect(Collectors.toList());
           documentResponse.setFiles(fileDTOS);
        }
    }


}
