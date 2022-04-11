package tn.clsolution.doccentrale.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.clsolution.doccentrale.document.Document;
import tn.clsolution.doccentrale.document.DocumentRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;
    private final DocumentRepository documentRepository;
    private final FileMapper fileMapper;

    public FileDTO store(MultipartFile file,Long document_id) throws IOException {
        String originalFilename = file.getOriginalFilename();

        File newFile =new File();
        newFile.setName(originalFilename.substring(0,originalFilename.lastIndexOf('.')));
        newFile.setType(originalFilename.substring(originalFilename.lastIndexOf('.')+1));
        newFile.setSize(file.getSize());
        newFile.setData(file.getBytes());

        Document document=this.documentRepository.findById(document_id).get();
        newFile.setDocument(document);

        File savedFile = this.fileRepository.save(newFile);
        return this.fileMapper.fileToDTO(savedFile,new FileDTO());
    }

    public FileDTO update(String id,FileDTO fileDTO){
        File file =this.fileRepository.findById(id).get();
        File updatedFile=this.fileMapper.updateFile(fileDTO,file,documentRepository);
        return this.fileMapper.fileToDTO(this.fileRepository.save(updatedFile),new FileDTO());
    }

    public List<FileDTO> findAll() {
        return this.fileRepository.findAll().stream().map(file -> this.fileMapper.fileToDTO(file,new FileDTO())).collect(Collectors.toList());
    }

    public FileDTO findOneById(String id) {
        File file =this.fileRepository.findById(id).get();
        return this.fileMapper.fileToDTO(file,new FileDTO());
    }
    public File findOne(String id){
        return this.fileRepository.findById(id).get();
    }

    public void deleteOne(String id) {
        this.fileRepository.deleteById(id);
    }

}
