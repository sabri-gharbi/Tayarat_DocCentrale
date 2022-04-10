package tn.clsolution.doccentrale.file;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;


    @PostMapping()
    public ResponseEntity<FileDTO> storeFile(@RequestParam("file") MultipartFile fileData) {
        try {
            FileDTO fileDTO =this.fileService.store(fileData);
            return ResponseEntity.status(HttpStatus.CREATED).body(fileDTO);
        } catch (IOException ex) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FileDTO> update(@PathVariable String id, @RequestBody FileDTO fileDTO){
        FileDTO updatedFileDto =this.fileService.update(id,fileDTO);
        return ResponseEntity.ok(updatedFileDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable() String id) {
        File file = this.fileService.findOne(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"").body(file.getData());
    }

    @GetMapping()
    public ResponseEntity<List<FileDTO>> getFilesList() {
        List<FileDTO> files = this.fileService.findAll();
        return ResponseEntity.ok(files);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFile(@PathVariable String id) {
        this.fileService.deleteOne(id);
        return ResponseEntity.ok().build();
    }


}
