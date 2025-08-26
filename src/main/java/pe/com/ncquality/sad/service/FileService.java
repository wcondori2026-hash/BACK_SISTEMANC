package pe.com.ncquality.sad.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Stream;

import org.jboss.logging.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("fileService")
public class FileService {
	private static Logger depurador = Logger.getLogger(FileService.class.getName());
	private final Path rootFolder = Paths.get("upload");
	
	public void grabar(MultipartFile file) throws Exception {
		depurador.info("::::::::::::::::::::::: grabar ::::::::::::::::::::::");
		Files.copy(file.getInputStream(), this.rootFolder.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);		
	}

	public Resource leer(String nombre) throws Exception {
		Path file = rootFolder.resolve(nombre);
		depurador.info("toUri ==> " + file.toUri());
		Resource resource = new UrlResource(file.toUri());
		return resource;
	}

	public void grabar(List<MultipartFile> files) throws Exception {
		depurador.info("::::::::::::::::::::::: grabar files::::::::::::::::::::::");
		for (MultipartFile file : files) {
			this.grabar(file);
		}
	}

	public Stream<Path> getArchivos() throws Exception {
		return Files.walk(rootFolder, 1).filter(path -> !path.equals(rootFolder)).map(rootFolder::relativize);
	}

}
