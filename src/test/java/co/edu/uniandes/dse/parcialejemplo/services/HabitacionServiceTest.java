package co.edu.uniandes.dse.parcialejemplo.services;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
// import co.edu.uniandes.dse.parcialejemplo.services.habitacionService;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(HabitacionService.class)
public class HabitacionServiceTest {
    @Autowired
	private HabitacionService habitacionService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

    private List<HabitacionEntity> habitacionList = new ArrayList<>();

    /**
	 * Configuración inicial de la prueba.
	 */
	@BeforeEach
	void setUp() {
		clearData();
		insertData();
	}

    /**
	 * Limpia las tablas que están implicadas en la prueba.
	 */
	private void clearData() {
        entityManager.getEntityManager().createQuery("delete from habitacionEntity");
	}

    /**
	 * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
	 */
	private void insertData() {

		for (int i = 0; i < 3; i++) {
			HabitacionEntity habitacionEntity = factory.manufacturePojo(HabitacionEntity.class);
			entityManager.persist(habitacionEntity);
			habitacionList.add(habitacionEntity);
		}

	}

    /**
     * Prueba para crear un habitacion.
     * 
     * @throws EntityNotFoundException
     * @throws IllegalOperationException
     */
	@Test
	void testCreatehabitacion() throws EntityNotFoundException, IllegalOperationException {
		HabitacionEntity newEntity = factory.manufacturePojo(HabitacionEntity.class);
		
		
		HabitacionEntity result = habitacionService.createHabitacion(newEntity);
		assertNotNull(result);

		HabitacionEntity entity = entityManager.find(HabitacionEntity.class, result.getId());

		assertEquals(newEntity.getBaños(), entity.getBaños());
        assertEquals(newEntity.getCamas(), entity.getCamas());
        assertEquals(newEntity.getCapacidad(), entity.getCapacidad());
        assertEquals(newEntity.getHotel(), entity.getHotel());
        assertEquals(newEntity.getIdentificacion(), entity.getIdentificacion());
		assertEquals(newEntity.getId(), entity.getId());
	}
}
