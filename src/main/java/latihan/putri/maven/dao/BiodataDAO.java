package latihan.putri.maven.dao;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import latihan.putri.maven.model.BiodataModel;
import latihan.putri.maven.repository.BiodataRepository;

@Service
public class BiodataDAO {

	@Autowired
	BiodataRepository biodataRepository;
	
	//getAll
	public List<BiodataModel> getAll(){
		return biodataRepository.findAll();
	}
	
	//get data by Id
	public BiodataModel getFindOne(Long id) {
		return biodataRepository.findOne(id);
	}
	
	//save
	public BiodataModel save(BiodataModel biodataModel) {
		return biodataRepository.save(biodataModel);
	}
	
	//delete
	public void delete(Long id) {
		biodataRepository.delete(id);
	}
	
}

