package internship.java.java_internship.appointment.service;

import internship.java.java_internship.appointment.model.entity.Appointment;
import internship.java.java_internship.appointment.repository.AppointmentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@Validated
public class AppointmentServiceJPA implements AppointmentService{
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceJPA(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public Optional<Appointment> getAppointmentById(UUID appointmentId) {

        return Optional.ofNullable(appointmentRepository.findById(appointmentId)
                .orElse(null));
    }

    @Override
    public Appointment saveNewAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {

        return appointmentRepository.findAll();
    }

    @Override
    public boolean deleteAppointmentById(UUID appointmentId) {
        Optional <Appointment> optAppointment =appointmentRepository.findById(appointmentId);
        if(optAppointment.isEmpty())
            return false;

        appointmentRepository.deleteById(appointmentId);
        return true;
    }

    @Override
    public Appointment updateAppointmentById(UUID appointmentId, Appointment appointment) {
        return null;
    }
}
