package tn.clsolution.doccentrale.document;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
@Validated
public class DocumentController {
    private final DocumentService documentService;

    @GetMapping
    public ResponseEntity<List<DocumentDTO>> findAll() {
        List<DocumentDTO> documents = this.documentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(documents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> findOne(@PathVariable("id") Long id) {
        DocumentDTO document = this.documentService.findOne(id);
        return ResponseEntity.ok(document);
    }

    @PostMapping
    public ResponseEntity<DocumentDTO> create(@Valid @RequestBody DocumentDTO documentDTO) {
        DocumentDTO createdDocument = this.documentService.create(documentDTO);
        if (createdDocument == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        this.documentService.delete(id);
        return ResponseEntity.ok(id);
    }

}
