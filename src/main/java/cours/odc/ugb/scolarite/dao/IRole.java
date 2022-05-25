package cours.odc.ugb.scolarite.dao;




import cours.odc.ugb.scolarite.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRole extends JpaRepository<Role, Integer> {
    public Role findRoleByName(String name);
}
