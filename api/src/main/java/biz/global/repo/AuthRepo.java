package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.global.model.AdminModel;

public interface AuthRepo extends JpaRepository<AdminModel, Long> {


}
