package tn.spring.timesheet.services;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tn.spring.timesheet.entities.Contrat;
import tn.spring.timesheet.repository.ContratRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ContratServiceImpl implements IContratService{

    private static final Logger logger = LogManager.getLogger(ContratServiceImpl.class);
    private final ContratRepository contratRepository ;

    @Override
    public Contrat addContrat(Contrat contrat){
        logger.info("info d'ajout contrat");
        try{
            logger.debug("debug ajout contrat");
            Contrat cont = contratRepository.save(contrat);
            logger.info("info contrat added successfuly");
            return cont;
        }catch(Exception e){
            logger.error("Error contrat non ajouter causedBy"+e.getMessage());
            return null;
        }
    }

    @Override
    public List<Contrat> getAllContrat() {
        logger.info("info all contracts");
        try {
          logger.debug("debug get all contracts");
          List<Contrat> conts= contratRepository.findAll() ;
          logger.info("All contracts success");
          return conts;
        }
        catch (Exception e) {
         logger.error("Error caused By" +e.getMessage());
            return null;
        }
    }

    @Override
    public int countContrat() {
        logger.info("get contract number");
        try
        {
            logger.debug("debug Contract counting");
            int X= contratRepository.countcont() ;
            logger.info("info get contracts number") ;
            return X;

        }
        catch (Exception e) {
            logger.error("Error caused by"+e.getMessage());
            return 0;
        }

    }

    @Override
    public Contrat getByType(String type) {

        logger.info("get Contrat by type");
        try {
            logger.debug("debug get contract by type");
            Contrat cont = contratRepository.getContratByType(type);
            logger.info("info get contrat by type") ;
            return cont ;
        }
        catch (Exception e) {
            logger.error("Error caused by "+e.getMessage());
            return null;
        }
    }


}
