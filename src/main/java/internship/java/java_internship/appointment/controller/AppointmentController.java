package internship.java.java_internship.appointment.controller;

import internship.java.java_internship.animal.cat.model.entity.Cat;
import internship.java.java_internship.animal.cat.service.CatService;
import internship.java.java_internship.appointment.service.AppointmentService;
import internship.java.java_internship.appointment.model.entity.Appointment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AppointmentController {

    public static final String APPOINTMENT_PATH = "/app/v1/appointment";
    public static final String APPOINTMENT_PATH_ID= APPOINTMENT_PATH + "/{appointmentId}";
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping(APPOINTMENT_PATH)
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        return new ResponseEntity<>( appointmentService.getAllAppointments(), HttpStatus.OK);
    }

    @GetMapping(APPOINTMENT_PATH_ID)
    public ResponseEntity<Appointment> getAppointment(@PathVariable("appointmentId") UUID appointmentId) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(appointmentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PostMapping(APPOINTMENT_PATH)
    public ResponseEntity<Appointment> postAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment =  appointmentService.saveNewAppointment(appointment);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    @DeleteMapping(APPOINTMENT_PATH_ID)
    public ResponseEntity<Void> deleteAppointmentById (@PathVariable("appointmentId") UUID appointmentId) {


        if (!appointmentService.deleteAppointmentById(appointmentId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping(APPOINTMENT_PATH_ID)
    public ResponseEntity<Appointment> putAppointment(@PathVariable("appointmentId") UUID appointmentId, @RequestBody Appointment appointment) {

        Appointment updatedAppointment = appointmentService.updateAppointmentById(appointmentId, appointment);
        return new ResponseEntity<>(updatedAppointment, HttpStatus.CREATED);

    }



}
