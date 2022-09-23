package co.edu.uniandes.dse.parcialejemplo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;

import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HabitacionService {
    @Autowired
    HabitacionRepository habRepository;
    @Transactional
	public HabitacionEntity createHabitacion(HabitacionEntity hab) throws IllegalOperationException{
		log.info("Inicia proceso de creación del hotel");

		if(hab.getIdentificacion()>=hab.getCamas()){
            throw new IllegalOperationException("El hotel ya existe");
        }


        return habRepository.save(hab);
    }
}
