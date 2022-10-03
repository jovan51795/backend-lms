package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.global.model.Admin;

public interface AuthRepo extends JpaRepository<Admin, Long> {


}
