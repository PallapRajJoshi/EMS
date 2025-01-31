package com.springproject.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("/upload")
	public String getUpload() {
		return "UploadPhoto";
	}

	@PostMapping("/upload")
	public String postUpload( @RequestParam MultipartFile image,Model m) {
		if (!image.isEmpty()) {
			try {
				Files.copy(image.getInputStream(), Path.of("src/main/resources/static/image/"+image.getOriginalFilename()),
						StandardCopyOption.REPLACE_EXISTING);
				m.addAttribute("message", "File Upload Success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			m.addAttribute("message","Upload Fail");
		}
		
		return "UploadPhoto";
	}
}
