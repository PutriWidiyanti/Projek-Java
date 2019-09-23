package latihan.putri.maven.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import latihan.putri.maven.dao.BiodataDAO;
import latihan.putri.maven.model.BiodataModel;

@RestController
@RequestMapping("/bio")
public class BiodataController {
	@Autowired
	BiodataDAO biodataDAO;
	
	//save
	@PostMapping("/data")
	public BiodataModel save(@Valid @RequestBody BiodataModel biodataModel) {
		return biodataDAO.save(biodataModel);
	}
	
	//getAll
	@GetMapping("/data")
	public List<BiodataModel> getAll(){
		return biodataDAO.getAll();
	}
	
	//get By Id
	@GetMapping("/data/{id}")
	public ResponseEntity<BiodataModel> getById(@PathVariable (value="id") Long id){
		BiodataModel bm=biodataDAO.getFindOne(id);
		
		if(bm==null) {
			return ResponseEntity.notFound().build();
			
		}else {
			return ResponseEntity.ok().body(bm);
		}
	}
	
	//update
	@PutMapping("/body/{id}")
	public ResponseEntity<BiodataModel> update(@PathVariable (value="id") Long id, @Valid @RequestBody BiodataModel biodataModel){
		BiodataModel bm=biodataDAO.getFindOne(id);
		
		if(bm==null) {
			return ResponseEntity.notFound().build();
		}else {
			bm.setNama(biodataModel.getNama());
			biodataModel.setJurusan(biodataModel.getJurusan());
			BiodataModel bmResult=biodataDAO.save(bm);
			return ResponseEntity.ok().body(bmResult);
		}
	}
	
	//delete
	@DeleteMapping("/bio/{id}")
	public ResponseEntity<BiodataModel> delete(@PathVariable(value="id") Long id){
		BiodataModel bm = biodataDAO.getFindOne(id);
		
		if(bm==null) {
			return ResponseEntity.notFound().build();
		}else {
			biodataDAO.delete(id);
			return ResponseEntity.ok().build();
		}
	}
}
