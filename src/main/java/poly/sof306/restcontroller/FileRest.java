package poly.sof306.restcontroller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import poly.sof306.service.impl.fileservice;

@CrossOrigin("*")
@RestController
public class FileRest {

	@Autowired
	fileservice fileservice;
	
	@GetMapping("rest/file/{file}")
	public byte[] download( @PathVariable("file") String file) {
		return fileservice.read( file);
	}
	
	@PostMapping("/rest/file")
	public String upload( @PathParam("file") MultipartFile file){
		return fileservice.save( file);
	}
	
	@GetMapping("rest/file")
	public List<String> list(){
		return fileservice.list();
	}
}
