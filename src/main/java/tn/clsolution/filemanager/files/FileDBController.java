package tn.clsolution.filemanager.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
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
    public ResponseEntity<FileDBResponse> store(@RequestParam("file") MultipartFile file) {
        try {
            FileDB result = this.fileUploadService.store(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(new FileDBResponse(result.getId(), result.getName(), result.getType(), result.getSize()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable() String id) {
        Optional<FileDB> file = this.fileUploadService.download(id);
        if (file.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        FileDB result = file.get();
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(result.getContentType())).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + result.getName() + "." + result.getType() + "\"").body(result.getData());
    }


    @GetMapping()
    public ResponseEntity<List<FileDBResponse>> getFilesList() {
        List<FileDBResponse> files = this.fileUploadService.filesList().map(x -> new FileDBResponse(x.getId(), x.getName(), x.getType(), x.getSize())).collect(Collectors.toList());
        return ResponseEntity.ok(files);
    }


}
