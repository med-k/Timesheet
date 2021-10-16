package tn.spring.timesheet.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.spring.timesheet.entities.Entreprise;
import tn.spring.timesheet.repository.EntrepriseRepository;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
class EntrepriseServiceImplTest {

    @Mock private EntrepriseRepository entrepriseRepository;

    private EntrepriseServiceImpl underTest;

    @BeforeEach
    void setUp(){
        underTest = new EntrepriseServiceImpl(entrepriseRepository);
    }

    @Test
    void ajouterEntreprise() {
        Entreprise entreprise = new Entreprise("tictactrip","informatique");

        Mockito.when(entrepriseRepository.save(entreprise)).thenReturn(new Entreprise("tictactrip","informatique"));

        Entreprise addedEntreprise = underTest.ajouterEntreprise(entreprise);

        verify(entrepriseRepository).save(entreprise);
        assertThat(addedEntreprise.getName()).isEqualTo(entreprise.getName());
        assertThat(addedEntreprise.getRaisonSocial()).isEqualTo(entreprise.getRaisonSocial());

    }

    @Test
    void getAllEntreprise() {
        underTest.getAllEntreprise();
        verify(entrepriseRepository).findAll();
    }

    @Test
    void getNombreEntreprise() {
        underTest.getNombreEntreprise();
        verify(entrepriseRepository).countEntreprise();
    }

    @Test
    void getAllEntrepriseNames() {
        underTest.getAllEntrepriseNames();
        verify(entrepriseRepository).getAllNamesOfEntreprise();
    }

    @Test
    void getAllEntrepriseByRaisonSocial() {
        String raisonSocial = "informatique";

        underTest.getAllEntrepriseByRaisonSocial(raisonSocial);

        ArgumentCaptor<String> raisonSocialArgumentCaptor = ArgumentCaptor.forClass(String.class);

        verify(entrepriseRepository).getAllEntrepriseByRaisonSocial(raisonSocialArgumentCaptor.capture());

        String capturedRaisonSocial = raisonSocialArgumentCaptor.getValue();

        assertThat(capturedRaisonSocial).isEqualTo(raisonSocial);
    }

    @Test
    void getEntrepriseById() {
        int id = 1;

        underTest.getEntrepriseById(id);

        ArgumentCaptor<Integer> idArgumentCpator = ArgumentCaptor.forClass(Integer.class);

        verify(entrepriseRepository).findById(idArgumentCpator.capture());

        int capturedUd = idArgumentCpator.getValue();

        assertThat(id).isEqualTo(capturedUd);
    }

    @Test
    void editEntrepriseById() {
        int id = 1;
        Entreprise entreprise = new Entreprise("tictactrip","informatique");
        Entreprise edittedEntreprise =new Entreprise("vermeg","assurence");
        Mockito.when(entrepriseRepository.findById(id)).thenReturn(java.util.Optional.of(entreprise));
        Mockito.when(entrepriseRepository.existsById(id)).thenReturn(true);
        Mockito.when(entrepriseRepository.save(entreprise)).thenReturn(edittedEntreprise);

        Entreprise updatedEntreprise = underTest.editEntrepriseById(edittedEntreprise,1);
        assertThat(updatedEntreprise.getRaisonSocial()).isEqualTo(edittedEntreprise.getRaisonSocial());
        assertThat(updatedEntreprise.getName()).isEqualTo(edittedEntreprise.getName());
    }

    @Test
    @Disabled
    void editEntrepriseNameById() {
        int id = 1;
        Entreprise entreprise = new Entreprise("tictactrip","informatique");
        Entreprise edittedEntreprise =new Entreprise("vermeg","informatique");
        Mockito.when(entrepriseRepository.findById(id)).thenReturn(java.util.Optional.of(edittedEntreprise));
        Entreprise updatedEntreprise = underTest.editEntrepriseNameById("vermeg",1);
        assertThat(updatedEntreprise.getName()).isEqualTo("vermeg");
    }

    @Test
    void deleteEntrepriseById() {
        int id = 1;
        underTest.deleteEntrepriseById(id);
        verify(entrepriseRepository).deleteById(1);
    }

    @Test
    void deleteAllEntreprise() {
        underTest.deleteAllEntreprise();
        verify(entrepriseRepository).deleteAll();
    }
}