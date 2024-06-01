package com.example.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO{

	private EntityManager entityManager;
	
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional 
	public void save(Student student) {
		this.entityManager.persist(student);
	}
	
	@Override
	public Student findById(Integer id) {
		return this.entityManager.find(Student.class, id);
	}
	
	@Override
	public List<Student> findall(){
		TypedQuery<Student> query = entityManager.createQuery("FROM Student order by firstName",Student.class);
		return query.getResultList();
	}
	
	@Override
	public List<Student> findByLastName(String lastName){
		TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName=:data",Student.class);
		query.setParameter("data",lastName);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}
	
	@Override
	@Transactional 
	public void delete(Integer id) {
		Student student = entityManager.find(Student.class,id);
		entityManager.remove(student);
	}
	
}
