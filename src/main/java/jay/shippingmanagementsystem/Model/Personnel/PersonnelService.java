package jay.shippingmanagementsystem.Model.Personnel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnelService {

    @Autowired
    private PersonnelDao personnelDao;

    public List<Personnel> getPersonnelList() {
        return personnelDao.findAll();
    }

    public Optional<Personnel> getPersonnelById(Long id) {
        return personnelDao.findById(id);
    }

    public void createPersonnel(Personnel personnel){
        personnelDao.save(personnel);
    }

    public void deletePersonnel(Long id){
        personnelDao.deleteById(id);
    }
}
