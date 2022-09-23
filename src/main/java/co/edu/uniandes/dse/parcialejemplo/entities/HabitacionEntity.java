package co.edu.uniandes.dse.parcialejemplo.entities;



import javax.persistence.Entity;

import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;


@Getter
@Setter
@Entity
public class HabitacionEntity {
    private Integer identificacion;
    private Integer capacidad;
    private Integer camas;
    private Integer baños;
    private Long id;
    
    @PodamExclude
    @ManyToOne
    private HotelEntity hotel;

}
