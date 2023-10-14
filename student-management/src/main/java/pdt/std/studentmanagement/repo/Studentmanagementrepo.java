package pdt.std.studentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pdt.std.studentmanagement.entity.Student;
@Repository
public interface Studentmanagementrepo extends JpaRepository<Student, Long> {

}
