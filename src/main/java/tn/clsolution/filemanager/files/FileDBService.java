package tn.clsolution.filemanager.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FileDBService {

    private final FileDBRepository fileUploadRepository;

    @Autowired
    public FileDBService(FileDBRepository fileUploadRepository) {
        this.fileUploadRepository = fileUploadRepository;
    }

    public FileDB store(MultipartFile file) throws IOException {
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        String name = originalFilename.substring(0, originalFilename.lastIndexOf('.'));
        String extension = originalFilename.substring(originalFilename.lastIndexOf('.') + 1);
        FileDB fileDb = new FileDB(name, extension, file.getSize(), file.getBytes(), file.getContentType());
        return fileUploadRepository.save(fileDb);

    }


    public Optional<FileDB> download(String id) {
        return this.fileUploadRepository.findById(id);
    }

    public Stream<FileDB> filesList() {
        return this.fileUploadRepository.findAll().stream();
    }

    public void delete(String id) {
        this.fileUploadRepository.deleteById(id);
    }
}
