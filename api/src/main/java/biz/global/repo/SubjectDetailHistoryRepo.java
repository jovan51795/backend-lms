package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import biz.global.model.SubjectDetailHistory;

public interface SubjectDetailHistoryRepo extends JpaRepository<SubjectDetailHistory, Long> {
    
    @Query(nativeQuery = true, value="SELECT * FROM subject_detail_history WHERE subject_id = ?1 AND  professor_id =?2  LIMIT 1")
    SubjectDetailHistory findHistory( Long subid, Long profid);
    
    @Query(nativeQuery = true, value="SELECT * FROM subject_detail_history WHERE subject_id = ?1 AND  professor_id IS NULL  LIMIT 1")
    SubjectDetailHistory findHistory( Long subid);
    
   

}
