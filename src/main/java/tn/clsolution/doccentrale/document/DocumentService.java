package tn.clsolution.doccentrale.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    //create
    public DocumentResponse create(DocumentDTO documentDTO){
        Document newDocument =this.documentMapper.updateDocument(documentDTO,new Document());
        DocumentResponse document =this.documentMapper.documentToDocumentResponse(this.documentRepository.save(newDocument),new DocumentResponse());
        return document;
    }

    //findOne
    @Transactional
    public DocumentResponse findOne(Long id) {
        Document document=this.documentRepository.findById(id).get();
        return this.documentMapper.documentToDocumentResponse(document,new DocumentResponse());
    }

    //findAll
    @Transactional
    public List<DocumentResponse> findAll() {
        List<DocumentResponse> documents =this.documentRepository.findAll().stream().map(document -> this.documentMapper.documentToDocumentResponse(document,new DocumentResponse())).collect(Collectors.toList());
        return documents;
    }

    @Transactional
    public DocumentResponse update(Long id, DocumentDTO documentDTO){
        Document document=this.documentRepository.findById(id).get();
        Document updatedDocument=this.documentRepository.save(this.documentMapper.updateDocument(documentDTO,document));
        return this.documentMapper.documentToDocumentResponse(updatedDocument,new DocumentResponse());
    }

    //delete
    public void delete(Long id) {
        this.documentRepository.deleteById(id);
    }



}
