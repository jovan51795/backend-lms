package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import biz.global.model.ProfessorLoad;

public interface ProfessorLoadRepo extends JpaRepository<ProfessorLoad, Long> {
    @Query(nativeQuery = true, value="SELECT * FROM professor_load WHERE subject_id = ?1 AND  professor_id =?2 OR professor_id IS NULL LIMIT 1")
    ProfessorLoad findProfessorLoad( Long subid, Long profid);
    
    @Query(nativeQuery = true, value="SELECT * FROM professor_load WHERE subject_id = ?1 AND section = ?2 LIMIT 1")
    ProfessorLoad findProfessorLoadbySection( Long subid,  String section);
}
