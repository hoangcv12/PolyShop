package poly.sof306.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class fileservice {
	@Autowired
	ServletContext app;

	private Path getPath( String filename) {
		File dir = new File("D:\\Java5\\practice\\Assignment_Java6\\src\\main\\resources\\static\\images");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return Paths.get(dir.getAbsolutePath(), filename);
	}

	public byte[] read( String filename) {
		Path path = this.getPath( filename);
		try {
			return Files.readAllBytes(path);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	
	
	public List<String> list(){
		List<String> filename = new ArrayList<String>();
		File dir = new File("D:\\Java5\\practice\\Assignment_Java6\\src\\main\\resources\\static\\images");
		if(dir.exists()) {
			File[] files = dir.listFiles();
			for(File file:files) {
				filename.add(file.getName());
			}
		}
		return filename;
	}
	
	public String save( MultipartFile file){
		
			String name = System.currentTimeMillis() + file.getOriginalFilename();
			String filename = Integer.toHexString(name.hashCode()) + name.substring(name.lastIndexOf("."));
		Path path = this.getPath( filename);
		try {
			file.transferTo(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filename;
	}
		
}
