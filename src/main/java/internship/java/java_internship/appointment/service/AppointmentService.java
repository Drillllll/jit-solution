package internship.java.java_internship.appointment.service;

import internship.java.java_internship.animal.cat.model.entity.Cat;
import internship.java.java_internship.appointment.model.entity.Appointment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentService {

    Optional<Appointment> getAppointmentById(UUID appointmentId);
    Appointment saveNewAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();

    boolean deleteAppointmentById(UUID appointmentId);

    Appointment updateAppointmentById(UUID appointmentId, Appointment appointment);
}
