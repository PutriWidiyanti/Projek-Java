package latihan.putri.maven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import latihan.putri.maven.model.BiodataModel;

public interface BiodataRepository extends JpaRepository<BiodataModel, Long> {

}
