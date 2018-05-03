package com.example.opet.myapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.opet.myapplication", appContext.getPackageName());
    }

    @Test
    public void testRoom() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        AppDatabase appdb = AppDatabase.getInstance(appContext);
        LembreteDAO lembreteDAO = appdb.lembreteDAO();

        Lembrete lembrete = new Lembrete();
        lembrete.setTexto("Putaria generalizada!");

        assertEquals(1,lembreteDAO.inserir(lembrete));

        List<Lembrete> lembretes = lembreteDAO.findAll();
        assertTrue(lembretes.size() > 0);

        Lembrete resultado = lembreteDAO.findById(1);
        assertNotNull(resultado);
        assertEquals(1, resultado.getID());

//        resultado.setTexto("Testando");
        resultado.setImportancia(Importancia.Alta.ordinal());
        assertEquals(1,lembreteDAO.atualizar(resultado));

        Lembrete resultado2 = lembreteDAO.findById(resultado.getID());
        assertNotNull(resultado2);
//        assertEquals("Testando", resultado2.getTexto());
        assertEquals(Importancia.Alta.ordinal(), resultado2.getImportancia());

        assertEquals(1, lembreteDAO.remover(resultado2));
    }
}
