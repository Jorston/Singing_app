package com.example.app.Modelos;

import java.io.Serializable;
import java.util.Date;

public class FichajeHora implements Serializable {
    String user;
    Date fechaEntrada, fechaSalida, horaEntrada, horaSalida;

    public FichajeHora(String user, Date fechaEntrada, Date fechaSalida, Date horaEntrada, Date horaSalida) {
        this.user = user;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getUser() {
        return user;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }
}