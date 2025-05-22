package org.example.parking;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //LISTO TODO test
        Estacionamiento est = new Estacionamiento();
        Vehiculo vehiculo = new Vehiculo("ABC123", "Up", Vehiculo.Tipo.AUTO);
        est.ingresarVehiculo("11111111", "Agus", vehiculo);

        Ticket ticket = est.retirarVehiculo("ABC123");

        assertEquals("ABC123", ticket.getVehiculo().getPatente());
        assertEquals("Up", ticket.getVehiculo().getModelo());
        assertEquals(Vehiculo.Tipo.AUTO, ticket.getVehiculo().getTipo());
        assertEquals("Agus", ticket.getCliente().getNombre());

    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // LISTO TODO test
        Ticket ticket = new Ticket(
                new Cliente("11111111", "Agus"),
                new Vehiculo("ABC123", "Up", Vehiculo.Tipo.AUTO)
        );
        ticket.setHoraSalida(ticket.getHoraEntrada().plusMinutes(70));

        assertEquals(200.0, ticket.calcularPrecio());
    }

}