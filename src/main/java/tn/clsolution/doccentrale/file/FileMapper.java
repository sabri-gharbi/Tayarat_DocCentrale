package tn.clsolution.doccentrale.file;

import org.mapstruct.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import tn.clsolution.doccentrale.document.Document;
import tn.clsolution.doccentrale.document.DocumentRepository;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FileMapper {

    @Mapping(target = "document",ignore = true)
    FileDTO fileToDTO(File file,@MappingTarget FileDTO fileDTO);

    @AfterMapping
    default void afterFileToDTO(File file,@MappingTarget FileDTO fileDTO) {
        fileDTO.setDocument(file.getDocument()==null?null:file.getDocument().getId());
    }


    @Mapping(target = "document",ignore = true)
    File updateFile(FileDTO fileDTO,@MappingTarget File file,@Context DocumentRepository documentRepository);

    @AfterMapping
    default void afterUpdateFile(FileDTO fileDTO, @MappingTarget File file , @Context DocumentRepository documentRepository){
        if (fileDTO.getDocument() != null && (file.getDocument() == null || !file.getDocument().getId().equals(fileDTO.getDocument()))) {
            final Document document = documentRepository.findById(fileDTO.getDocument())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "document not found"));
            file.setDocument(document);
        }
    }







}
