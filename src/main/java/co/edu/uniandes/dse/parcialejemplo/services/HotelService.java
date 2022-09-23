package co.edu.uniandes.dse.parcialejemplo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;

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


		if(ExisteHotel(hotel, hotelRepository.findAll()) == true){
            throw new IllegalOperationException("El hotel ya existe");
        }
        if(hotel.getNumEstrellas()<1 & hotel.getNumEstrellas()>5){
            throw new IllegalOperationException("El hotel no es valido");
        }

        return hotelRepository.save(hotel);
    }
    public boolean ExisteHotel(HotelEntity hotel, List<HotelEntity> hoteles)
        {
           boolean existe = false;
        
           for(int i=0;i<hoteles.size();i++)
           {
              if(hoteles.get(i).getNombre() == hotel.getNombre())
              {
                 existe = true;
                 break;
              }
           }
        
           return existe;
        }

    
}
