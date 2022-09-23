package co.edu.uniandes.dse.parcialejemplo.services;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialejemplo.exceptions.ErrorMessage;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;
    @Transactional
	public HotelEntity createHoteles(HotelEntity hotel) throws IllegalOperationException{
		log.info("Inicia proceso de creación del hotel");
        String nombre= hotel.getNombre();
		if(hotelRepository.findAll().isEmpty())

        return hotelRepository.save(hotel);
    }
}
