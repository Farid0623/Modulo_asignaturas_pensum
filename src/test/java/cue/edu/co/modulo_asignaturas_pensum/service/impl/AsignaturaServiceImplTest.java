package cue.edu.co.modulo_asignaturas_pensum.service.impl;

import cue.edu.co.modulo_asignaturas_pensum.dto.AsignaturaDTO;
import cue.edu.co.modulo_asignaturas_pensum.model.Asignatura;
import cue.edu.co.modulo_asignaturas_pensum.repository.AsignaturaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AsignaturaServiceImplTest {

    @Test
    void createAsignatura_validaYGuarda() {
        AsignaturaRepository repo = mock(AsignaturaRepository.class);
        ApplicationEventPublisher publisher = mock(ApplicationEventPublisher.class);

        // Constructor para test (debes agregarlo en tu service)
        AsignaturaServiceImpl service = new AsignaturaServiceImpl(repo, publisher);

        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setCreditos(2);
        dto.setHorasTeoricas(16);
        dto.setHorasPracticas(16);

        Asignatura entity = new Asignatura();
        entity.setId("id1");
        when(repo.save(any())).thenReturn(entity);

        AsignaturaDTO result = service.createAsignatura(dto);
        assertNotNull(result);
        verify(repo, times(1)).save(any());
        verify(publisher, times(1)).publishEvent(any());
    }
}