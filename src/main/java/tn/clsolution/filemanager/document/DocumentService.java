package tn.clsolution.filemanager.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    //create
    public Document create(Document document) {
        return this.documentRepository.save(document);
    }

    //findOne
    public Optional<Document> findOne(Long id) {
        return this.documentRepository.findById(id);
    }

    //findAll
    public List<Document> findAll() {
        return this.documentRepository.findAll();
    }

    //delete
    public void delete(Long id) {
        this.documentRepository.deleteById(id);
    }

    //update
    public Document update(Long id, Document document) {
        return document;
    }

}
