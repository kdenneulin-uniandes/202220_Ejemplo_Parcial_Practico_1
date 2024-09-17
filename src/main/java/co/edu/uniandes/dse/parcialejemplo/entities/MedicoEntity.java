package co.edu.uniandes.dse.parcialejemplo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class MedicoEntity extends BaseEntity {
    String nombre; 
    String apellido; 
    String registroMedico; 

    @PodamExclude
    @ManyToMany
    List<EspecialidadEntity> especialidades = new ArrayList<>(); 

}
