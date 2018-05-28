package neu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.model.RegisterModel;
import neu.edu.Admin;
import neu.edu.Customer;
import neu.edu.Owner;
import neu.edu.User;
import neu.edu.dao.UserDao;
import neu.edu.model.RestLogicalErrorException;

@Service
public class RegistrationService {

    @Autowired
    public UserDao userDao;

    public boolean getRegisterUser(RegisterModel registerUser) throws RestLogicalErrorException {
        if (registerUser.getUserName() == null || registerUser.getPassword() == null) {

            throw new RestLogicalErrorException("Registration Parameters incomplete.");
        }
        User user = new User();

        //set user
        user.setName(registerUser.getName());
        user.setUsername(registerUser.getUserName());
        user.setPassword(registerUser.getPassword());
        user.setDob(registerUser.getDob());
        user.setType(registerUser.getType());
        user.setGender(registerUser.getGender());
//		userDao.setUser(user);

        //get user from db
//		user = userDao.getUserByName(registerUser.getUserName());
        if (registerUser.getType().equals("Customer")) {
            Customer customer = new Customer();
            
            //https://www.mkyong.com/hibernate/hibernate-cascade-example-save-update-delete-and-delete-orphan/
            //http://www.mkyong.com/hibernate/hibernate-one-to-many-relationship-example/
            customer.setContactNo(registerUser.getContactNo());
            customer.setUser(user);
            //user.getCustomers().add(customer);
        } else {
            Owner owner = new Owner();
            owner.setContactNo(registerUser.getContactNo());
            owner.setUser(user);
        }
        if (!userDao.userRegistration(user)) {
            throw new RestLogicalErrorException("Duplicate User.");

        }
        return true;
    }
}
