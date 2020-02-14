package fr.dawan.formation.AppQCMMono.Persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.dawan.formation.AppQCMMono.Models.Theme;

public class ThemeDAO extends GenericDAO<Theme> {

	public ThemeDAO(String persistenceUnitName) {
		super(persistenceUnitName);
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	
	
	@Override
	public Theme saveOrUpdate(Theme theme) {
		// TODO Auto-generated method stub
		//GenericDAO<Theme> daoTheme = new  GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
		Set<Theme> themes;
		themes=findAll(Theme.class);
		boolean existYet=false;
		for (Theme theme2 : themes) {
			if (theme2.getValue().equals(theme.getValue())) {
				existYet=true;
				return theme2;
				
			}
			
		}
		if (!existYet) super.saveOrUpdate(theme);
		return theme;
		//daoTheme.close();
		
		
		
	}

	
	
	
}
