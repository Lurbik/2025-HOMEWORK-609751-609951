package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.*;

public class TestComandoPosa {

    @Test
    public void TestPartitaPosa() {
        String[] comandi = {
            "prendi osso",     // prende un attrezzo
            "posa osso",       // lo posa
            "posa chiave",     // non è presente nella borsa
            "fine"
        };

        IOSimulator io = Simulatore.creaSimulazionePartitaEGioca(comandi);

        assertTrue(io.hasNextMessaggio());
        assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());

        assertTrue(io.hasNextMessaggio());
        assertEquals("attrezzo preso con successo!", io.nextMessaggio()); // prendi osso

        assertTrue(io.hasNextMessaggio());
        assertEquals("attrezzo posato con successo!", io.nextMessaggio()); // posa osso

        assertTrue(io.hasNextMessaggio());
        assertEquals("Attrezzo non presente nella borsa!", io.nextMessaggio()); // posa chiave

        assertTrue(io.hasNextMessaggio());
        assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
    }
}
