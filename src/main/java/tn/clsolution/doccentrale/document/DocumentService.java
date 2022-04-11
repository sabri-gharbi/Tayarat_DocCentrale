package tn.clsolution.doccentrale.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    //create
    public DocumentDTO create(DocumentDTO documentDTO){

        Document newDocument =this.documentMapper.updateDocument(documentDTO,new Document());
        System.out.println(newDocument.getTitle());
        Document document= this.documentRepository.save(newDocument);
        return this.documentMapper.documentToDTO(document);
    }

    //findOne
    public DocumentDTO findOne(Long id) {
        Document document=this.documentRepository.findById(id).get();
        return this.documentMapper.documentToDTO(document);
    }

    //findAll
    public List<DocumentDTO> findAll() {
        List<DocumentDTO> documents =this.documentRepository.findAll().stream().map(document -> this.documentMapper.documentToDTO(document)).collect(Collectors.toList());
        return documents;
    }

    //delete
    public void delete(Long id) {
        this.documentRepository.deleteById(id);
    }

}
