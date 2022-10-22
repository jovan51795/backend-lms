package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.global.model.Parent;


public interface ParentRepo extends JpaRepository<Parent, Long> {

    Parent  findByLastName(String lastName);

}
