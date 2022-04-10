package tn.clsolution.doccentrale.document;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DocumentMapper {


    DocumentDTO documentToDTO(Document document);
    Document updateDocument(DocumentDTO documentDTO,@MappingTarget Document document);


}
