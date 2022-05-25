package cours.odc.ugb.scolarite.service;



import cours.odc.ugb.scolarite.dao.IUtilisateur;
import cours.odc.ugb.scolarite.model.Role;
import cours.odc.ugb.scolarite.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
//ou @Component
public class CustumUserDetailsService implements UserDetailsService {
	@Autowired
	private IUtilisateur userDAO ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userDAO.findByUsername(username);

		return user;
	}
	
	private Collection getAuthorities(List roles) {
		List authorities = new ArrayList();
		for(Object role : roles)
		{
			Role l = (Role)role;
			authorities.add(new SimpleGrantedAuthority(l.getName()));
		}
		return authorities ;
	}

}
