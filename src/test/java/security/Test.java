package security;

import java.util.ArrayList;
import java.util.List;

import sn.isi.dao.ComptesImpl;
import sn.isi.dao.DroitsImpl;
import sn.isi.dao.IComptes;
import sn.isi.dao.IDroits;
import sn.isi.entities.Comptes;
import sn.isi.entities.Droits;

public class Test {
	public static void main(String[] args){

        Droits d = new Droits();
        IDroits Ddao = new DroitsImpl();
        Comptes Comptes = new Comptes();
        Comptes.setUsername("khady");
        Comptes.setPassword("passer");
        //List<Droits> droits = new ArrayList<Droits>();
       // droits.add(Ddao.get(1,d));
        //Comptes.setDroits(droits); 

        IComptes Cdao = new ComptesImpl();
        int resultats = Cdao.add(Comptes);


	}
	}
