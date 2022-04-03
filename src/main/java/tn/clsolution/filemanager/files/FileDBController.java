package tn.clsolution.filemanager.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.clsolution.filemanager.files.message.ResponseFile;
import tn.clsolution.filemanager.files.message.ResponseMessage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
public class FileDBController {
    final FileDBService fileUploadService;

    @Autowired
    public FileDBController(FileDBService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping()
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            FileDB result = this.fileUploadService.store(file);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(result.getId()));

        } catch (Exception e) {
            String message = "file upload failed: " + file.getName();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping()
    public ResponseEntity<List<ResponseFile>> getFilesList() {
        List<ResponseFile> files = this.fileUploadService.getAllFiles().map(dbFile -> new ResponseFile(dbFile.getId(), dbFile.getName(), dbFile.getType(), dbFile.getSize())).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFile> downloadFile(@PathVariable() String id) {
        try {
            FileDB file = this.fileUploadService.downloadFile(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseFile(file.getId(), file.getName(), file.getType(), file.getSize()));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseFile());
        }
    }


}
