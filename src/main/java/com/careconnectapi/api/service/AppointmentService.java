package com.careconnectapi.api.service;

import com.careconnectapi.api.entity.AppointmentEntity;
import com.careconnectapi.api.model.AppointmentRequestBody;
import com.careconnectapi.api.model.AppointmentIdRequest;
import com.careconnectapi.api.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Create a new appointment
    public AppointmentEntity createAppointment(AppointmentRequestBody appointmentRequestBody) {
        AppointmentEntity newAppointment = mapToEntity(appointmentRequestBody);
        return appointmentRepository.save(newAppointment);
    }

    // Update an existing appointment
    public AppointmentEntity updateAppointment(AppointmentRequestBody appointmentRequestBody) {
        AppointmentEntity updatedAppointment = mapToEntity(appointmentRequestBody);
        return appointmentRepository.save(updatedAppointment);
    }

    // List all appointments with pagination
    public Page<AppointmentEntity> listAllAppointments(int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        return appointmentRepository.findAll(pageable);
    }

    // Delete an appointment by ID
    public String deleteAppointment(AppointmentIdRequest appointmentIdRequest) {
        appointmentRepository.deleteById(appointmentIdRequest.getAptId());
        return "Appointment Deleted";
    }

    // Count the total number of appointments
    public long countNumberOfAppointments() {
        return appointmentRepository.count();
    }

    // Helper method to map request body to entity
    private AppointmentEntity mapToEntity(AppointmentRequestBody appointmentRequestBody) {
        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setAppointmentId(appointmentRequestBody.getAppointmentId());
        appointment.setPatientId(appointmentRequestBody.getPatientId());
        appointment.setDoctorId(appointmentRequestBody.getDoctorId());
        appointment.setAppointmentDate(appointmentRequestBody.getAppointmentDate());
        appointment.setAppointmentTime(appointmentRequestBody.getAppointmentTime());
        appointment.setStatus(appointmentRequestBody.getStatus());
        appointment.setReasonForVisit(appointmentRequestBody.getReasonForVisit());
        appointment.setCreatedAt(appointmentRequestBody.getCreatedAt());
        return appointment;
    }
}