	package com.company.dao;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	
	import com.company.entity.Student;
	
	import jakarta.persistence.EntityManager;
	import jakarta.persistence.TypedQuery;
	import jakarta.transaction.Transactional;
	
	@Repository
	public class StudentDaoImplementation implements IStudentDao {
		
		private EntityManager  entityManager;
	
		@Override
		@Transactional
		public void save(Student thestudent) {
			entityManager.persist(thestudent);
		}
	
		@Autowired
		public StudentDaoImplementation(EntityManager entityManager) {
			this.entityManager = entityManager;
		}
	
		@Override
		public Student findById(Integer ID) 
		{
			return entityManager.find(Student.class, ID);
		}
	
		@Override
		public List<Student> findAll() {
			TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY id DESC", Student.class);
			return theQuery.getResultList();
		}


		@Override
		@Transactional
		public void deletByID(int id) {
			// TODO Auto-generated method stub
			StudentDaoImplementation stimp = this;	
			Student st = stimp.findById(id);
			entityManager.remove(st);
		}

		@Override
		@Transactional
		public int deleteAll() {
			int deletedCount = entityManager.createQuery("DELETE FROM Student").executeUpdate();
			return deletedCount;
			
		}
	
		
	}
