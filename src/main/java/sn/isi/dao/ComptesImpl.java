package sn.isi.dao;

import java.util.ArrayList;
import java.util.List;

import sn.isi.dto.ComptesDto;
import sn.isi.dto.DroitsDto;
import sn.isi.entities.Comptes;
import sn.isi.entities.Droits;

public class ComptesImpl extends RepositoryImpl<Comptes> implements IComptes {

	@Override
	public Comptes getByUsername(String username) {
		return (Comptes) session.createQuery("FROM Comptes comptes WHERE comptes.username = :comptes_username")
				.setParameter("comptes_username", username).uniqueResult();
	}

	@Override
	public Comptes login(String username, String password) {
		List<Comptes> comptes = new ArrayList<>();
        Comptes c = new Comptes();
        comptes = this.list(c);
        for (Comptes ing : comptes) {
            if(ing.getUsername().equals(username) && ing.getPassword().equals(password)) {
                return ing;
            }
        }
        return null;
	}
	
	    public ComptesDto ComptesEntityToComptesDto (Comptes comptes) {
	        ComptesDto comptesdto = new ComptesDto();
	        comptesdto.setId(comptes.getId());
	        comptesdto.setUsername(comptes.getUsername());
	        if (comptes.getDroits() != null) {
	            List<DroitsDto> Droits = new ArrayList<DroitsDto>();
	            comptes.getDroits().forEach(droits->{
	                Droits.add(new DroitsDto( ));
	            });
	            comptesdto.setDroits(Droits);
	        }

	        return comptesdto;
	    }

		public Comptes ComptesDtoToComptesEntity(ComptesDto comptesDto) {
			Comptes comptes = new Comptes();
	        comptes.setId(comptesDto.getId());
	        comptes.setUsername(comptesDto.getUsername());
	        if (comptesDto.getDroits() != null) {
	            List<Droits> droits = new ArrayList<Droits>();
	            comptes.getDroits().forEach(name->{
	                Droits droit = new DroitsImpl().getByName(name.getName());
	                droits.add(droit);
	            });
	            comptes.setDroits(droits); 
	        }
	        comptes.setPassword(comptesDto.getPassword());
	        return comptes;
		}

		

	 

}
