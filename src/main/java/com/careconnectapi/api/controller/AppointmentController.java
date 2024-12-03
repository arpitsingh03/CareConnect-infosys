package com.careconnectapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.careconnectapi.api.model.AppointmentRequestBody;
import com.careconnectapi.api.model.AppointmentIdRequest;
import com.careconnectapi.api.service.AppointmentService;

@RestController
@CrossOrigin
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Create a new appointment
    @RequestMapping(value = "/makeAppointment", method = RequestMethod.POST)
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentRequestBody appointmentRequestBody) throws Exception {
        return ResponseEntity.ok(appointmentService.createAppointment(appointmentRequestBody));
    }

    // Update an existing appointment
    @RequestMapping(value = "/updateAppointment", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentRequestBody appointmentRequestBody) throws Exception {
        return ResponseEntity.ok(appointmentService.updateAppointment(appointmentRequestBody));
    }

    // List all appointments with pagination
    @RequestMapping(value = "/listAllAppointments", method = RequestMethod.GET)
    public ResponseEntity<?> listAllAppointments(@RequestParam(defaultValue = "0") final Integer pageNumber,
                                                 @RequestParam(defaultValue = "10") final Integer size) throws Exception {
        return ResponseEntity.ok(appointmentService.listAllAppointments(pageNumber, size));
    }

    // Delete an appointment by ID
    @RequestMapping(value = "/deleteAppointment", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAppointment(@RequestBody AppointmentIdRequest appointmentIdRequest) throws Exception {
        return ResponseEntity.ok(appointmentService.deleteAppointment(appointmentIdRequest));
    }

    // Get the total number of appointments
    @RequestMapping(value = "/Appointmentscount", method = RequestMethod.GET)
    public ResponseEntity<?> countAppointments() throws Exception {
        return ResponseEntity.ok(appointmentService.countNumberOfAppointments());
    }
}