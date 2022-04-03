package tn.clsolution.filemanager.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/document")
@Validated
public class DocumentController {
    final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public ResponseEntity<List<Document>> findAll() {
        List<Document> documents = this.documentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(documents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> findOne(@PathVariable("id") Long id) {
        Optional<Document> result = this.documentService.findOne(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @PostMapping
    public ResponseEntity<Document> create(@Valid @RequestBody Document document) {
        Document createdDocument = this.documentService.create(document);
        if (createdDocument == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {

        this.documentService.delete(id);
        return  ResponseEntity.ok(id);
        }catch (EmptyResultDataAccessException e){

        return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Document> update(@RequestBody Document document, @PathVariable Long id) {
        Document updatedDocument = this.documentService.update(id, document);
        if (updatedDocument == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDocument);
    }
}
