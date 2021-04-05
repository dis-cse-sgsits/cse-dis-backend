package sgsits.cse.dis.academics.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.exception.ConflictException;
import sgsits.cse.dis.academics.exception.FileStorageException;
import sgsits.cse.dis.academics.exception.MyFileNotFoundException;
import sgsits.cse.dis.academics.model.Scheme;
import sgsits.cse.dis.academics.model.SchemeFile;
import sgsits.cse.dis.academics.repo.SchemeFileRepository;
import sgsits.cse.dis.academics.repo.SchemeRepository;
import sgsits.cse.dis.academics.request.SchemeFileForm;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.CoursesService;
import sgsits.cse.dis.academics.service.SchemeServices;

@Component
public class SchemeServiceImpl implements SchemeServices {
	
	@Autowired
	private SchemeRepository schemeRepository;

	@Autowired
	private SchemeFileRepository schemeFileRepository;

	@Autowired
	private CoursesService coursesService;
	
	@Override
	public List<String> getAllSubjectAcronym() {
		List<String> subjectAcronymList;
		subjectAcronymList = schemeRepository.findDistinctSubjectAcronym();
		return subjectAcronymList;
	}

	@Override
	public List<String> getSubjectCodesByYearAndSemesterAndCourse(String year, String sem,String course) {
		return schemeRepository.findByYearAndSemesterAndCourseId(year, sem, coursesService.getCourseIdByName(course))
				.stream()
				.map(scheme -> scheme.getSubjectCode())
				.sorted()
				.collect(Collectors.toList());
		
	}

	@Override
	public ResponseEntity<ResponseMessage> uploadFile(SchemeFileForm schemeFileForm, MultipartFile file) throws IOException {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if(fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			SchemeFile schemeFile = new SchemeFile(fileName, file.getContentType(),schemeFileForm.getCourse(), schemeFileForm.getSemester(), file.getBytes());
			schemeFileRepository.save(schemeFile);
			String message = "Uploaded the file successfully: " + fileName;
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
// Upload file to folder:
//		file.transferTo(new File("F:\\hackJOURNEY\\TestUploads\\"+file.getOriginalFilename()));
	}

	public SchemeFile getFile(String fileId) {
		return (SchemeFile) schemeFileRepository.findByfileName(fileId)
				.orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
	}

	public ResponseEntity<ResponseMessage> delete(String fileName) throws FileNotFoundException {

			Optional<Object> schemeFile = schemeFileRepository.findByfileName(fileName);
			if(schemeFile.isPresent()){
				schemeFileRepository.delete((SchemeFile) schemeFile.get());
				String message = "The file is deleted successfully.";
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			}
			else{
				throw new FileNotFoundException("File not found with id " + fileName);
			}
	}

	@Override
	public List<SchemeFile> getAllSchemes() {
			return schemeFileRepository.findAll();
	}


}
