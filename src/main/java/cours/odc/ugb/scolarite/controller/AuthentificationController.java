package cours.odc.ugb.scolarite.controller;

import cours.odc.ugb.scolarite.dao.IUtilisateur;
import cours.odc.ugb.scolarite.model.JwtRequest;
import cours.odc.ugb.scolarite.model.JwtResponse;
import cours.odc.ugb.scolarite.model.User;
import cours.odc.ugb.scolarite.security.JwtTokenUtil;
import cours.odc.ugb.scolarite.service.CustumUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthentificationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private CustumUserDetailsService custumUserDetailsService;
    @Autowired
    private IUtilisateur iUtilisateur;

    private void authenticate(String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED",e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS",e);
        }
    }
    @PostMapping("/login")
    public @ResponseBody
    JwtResponse Logon(@RequestBody JwtRequest jwtRequest) throws  Exception{
        try {
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
            final UserDetails userDetails=custumUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
            final String token=jwtTokenUtil.generateToken(userDetails);
            User u=iUtilisateur.findByUsername(jwtRequest.getUsername());
            List<String> roles=u.getRoles().stream().map(role->role.getName()).collect(Collectors.toList());
            return new JwtResponse(u.getUsername(),u.getName(),token,roles, "on");

        }catch (Exception ex){
            return  new JwtResponse("failed");
        }
    }
}
