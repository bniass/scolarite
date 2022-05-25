package cours.odc.ugb.scolarite.dao;

import cours.odc.ugb.scolarite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUtilisateur extends JpaRepository<User, Integer> {
    public User findByUsername(String login);
    public User findByEmail(String email);
}
