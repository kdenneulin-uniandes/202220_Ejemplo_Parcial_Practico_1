package co.edu.uniandes.dse.parcialejemplo.services;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(MedicoService.class)
public class MedicoServiceTest {
    @Autowired
    private MedicoService productoService; 

    @Autowired
    private TestEntityManager entityManager; 

    private List<MedicoEntity> medicos = new ArrayList<>();

    private PodamFactory factory = new PodamFactoryImpl(); 

    @BeforeEach
    void setUp() {
        clearData();
        insertData();
    }

    private void clearData(){
        entityManager.getEntityManager().createQuery("delete from MedicoEntity");
    }

    private void insertData(){

        for (int i = 0; i < 3 ; i++){
            MedicoEntity medicoEntity = factory.manufacturePojo(MedicoEntity.class );
            entityManager.persist(medicoEntity);
            medicos.add(medicoEntity);
        }

    }

    @Test
    void testCreateMedicos() throws IllegalOperationException {
        /*for(MedicoEntity medi: medicos)  {
            MedicoEntity result = medi ;
            MedicoEntity entity = entityManager.find(ProductoEntity.class, result.getId()); 
            assertNotNull(entity);
            assertEquals(newEntity.getNombre(), entity.getNombre());
            assertEquals(newEntity.getCosto(), entity.getCosto());
            assertEquals(newEntity.getCategoria(), entity.getCategoria());
            assertEquals(newEntity.getFoto(), entity.getFoto());
            assertEquals(newEntity.getDescripcion(), entity.getDescripcion());

        }*/
    }


}
