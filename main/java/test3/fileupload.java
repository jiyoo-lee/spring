package test3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class fileupload {

	@PostMapping("/fileupload")
	public String fileUp (Model model,@RequestParam("multifiles")
			List<MultipartFile> multiFileList, HttpServletRequest request) throws Exception{
		
		String path = "c:\\upload\\";
		List<String> fileNameList = new ArrayList<String>();
		for(int i = 0; i <multiFileList.size(); i++) {
			String fileName = multiFileList.get(i).getOriginalFilename();
			File fe = new File(path);
			path = path + fileName;
			FileCopyUtils.copy(multiFileList.get(i).getBytes(), new File(path));
			fileNameList.add(fileName);
			
		}
		model.addAttribute("results",fileNameList);
		
		return "view/filesUploadResult";
	}

}
