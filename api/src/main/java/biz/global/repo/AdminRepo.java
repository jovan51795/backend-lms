package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.global.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {

}
