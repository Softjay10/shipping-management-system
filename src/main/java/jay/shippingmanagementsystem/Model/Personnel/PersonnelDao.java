package jay.shippingmanagementsystem.Model.Personnel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelDao extends JpaRepository<Personnel, Long> {

    @Query(value = "SELECT COUNT(p.id) FROM Personnel p")
    Long getPersonnelBy();
}
