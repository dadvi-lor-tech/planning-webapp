package com.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planning.dao.UserDAO;
import com.planning.model.Profile;
import com.planning.model.RightsStatus;
//import com.planning.dao.UserDao;
import com.planning.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	// This means to get the bean called userDao which is auto-implemented by
	// Spring, we will use it to handle the data
	//@Autowired
	//private UserDAO userDAO;

	// TODO: Supprimer méthode mockup et récupérer la liste des utilisateurs en
	// base de données
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Profile profil1 = new Profile(1, "Chef de projet", (float) 100.0);
		Profile profil2 = new Profile(1, "Développeur", (float) 80.0);

		User user1 = new User(RightsStatus.BASIC_USER);
		user1.setId(1);
		user1.setFirstName("Louis");
		user1.setLastName("Guinard");
		user1.setProfile(profil2);

		User user2 = new User(RightsStatus.BASIC_USER);
		user2.setId(2);
		user2.setFirstName("David");
		user2.setLastName("Trochel");
		user2.setProfile(profil2);

		User user3 = new User(RightsStatus.BASIC_USER);
		user3.setId(3);
		user3.setFirstName("Samuel");
		user3.setLastName("Truffier-Blanc");
		user3.setProfile(profil1);

		User user4 = new User(RightsStatus.ADMIN);
		user4.setId(4);
		user4.setFirstName("Nicolas");
		user4.setLastName("Noel");
		user4.setProfile(profil1);

		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);

		return users;
	}

	// TODO: récupérer l'utilisateur en BDD
	public User findUserById(long id) {
		User user1 = new User(RightsStatus.BASIC_USER);
		user1.setId(1);
		user1.setFirstName("Louis");
		user1.setLastName("Guinard");
		Profile profil2 = new Profile(1, "Développeur", (float) 80.0);
		user1.setProfile(profil2);
		return user1;
	}

	// TODO: récupérer l'utilisateur en BDD à partir du projectId
	public User findAdminByProjectId(long projectId) {
		User user4 = new User(RightsStatus.ADMIN);
		user4.setId(4);
		user4.setFirstName("Nicolas");
		user4.setLastName("Noel");
		Profile profil1 = new Profile(1, "Chef de projet", (float) 100.0);
		user4.setProfile(profil1);
		return user4;
	}
}