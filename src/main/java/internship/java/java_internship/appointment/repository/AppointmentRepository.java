package internship.java.java_internship.appointment.repository;

import internship.java.java_internship.animal.cat.model.entity.Cat;
import internship.java.java_internship.appointment.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
}
