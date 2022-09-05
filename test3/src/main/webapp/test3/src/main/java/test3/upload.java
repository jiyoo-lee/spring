package test3;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class upload {
	
	//파일 업로드 : 바이너리파일 Exception
	//MultipartFile 클래스 import시 같은 name명인 첨부파일을 전부 불러온다.
	@RequestMapping("/fileupload.do")
	public String filesok (Model model, MultipartFile file1, HttpServletRequest req) throws Exception {
		
		//Local fileUpload 
		String directory = "c:\\upload\\";
				
		//사용자가 업로드하는 파일명을 알아오는 부분
		String fileName = file1.getOriginalFilename();
		//저장 할 상대, 절대 경로 
		File fe = new File(directory);
		String url = "";
		if(fileName.equals("")) {
			url="첨부파일 없음";
		}
		else {
			url = directory + fileName;
			//FileCopyUtils.copy : ajax, (form)post 둘다 사용이 가능함
			//파일 복사 기능, (servlet에서)write 기능 + steam을 합친 형태로 구현 됨
			FileCopyUtils.copy(file1.getBytes(), new File(url));			
		}
		model.addAttribute("result_file",url);

		return "view/okfile";
	}
	/*server에 직접적으로 등록하는 방식 */
	@RequestMapping("/fileupload2.do")
	public String serverUpload (Model model, MultipartFile file2, HttpServletRequest req) throws Exception {
		// 첨부파일에 파일이 등록되었을경우
		if(!file2.equals("")) {
			String fileType = file2.getContentType(); //업로드 할 파일 타입을 확인하는 사항
			System.out.println(fileType);
			
			if(!fileType.equals("image/jpeg") || !fileType.equals("image/png") || !fileType.equals("image/gif")) {
				System.out.println("해당 업로드는 이미지만 가능합니다.");
			}
			//getServletContext().getRealPath("") : 서버 상대경로
			String directory = req.getServletContext().getRealPath("");
			String upload_directory = directory + "upload/"; //상대 경로에 업로드 할 디렉토리 생성
			File fe = new File(upload_directory);
			if(!fe.exists()) {
				fe.mkdir();
			}
			String fileName = file2.getOriginalFilename();
			String copyFile = upload_directory + fileName;
			FileCopyUtils.copy(file2.getBytes(), new File(copyFile));
			model.addAttribute("result_file",copyFile);
		}
		else {
			model.addAttribute("result_file","첨부파일이 없습니다.");
		}
		return "view/okfile";
	}
}
