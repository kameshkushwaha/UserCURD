package com.curd.Controlar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curd.entity.User;
import com.curd.services.UserService;

@RestController
@RequestMapping("/api")
public class MainContolar {

    @Autowired
    private UserService userService;


    //for getting the data of all user
    @GetMapping("/users")
	public ResponseEntity<?> getUser() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		List<User> userList = userService.getUser();
		if (!userList.isEmpty()) {
			map.put("status", 1);
			map.put("data", userList);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
	}

    // for saving tha data to Database
    @PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		userService.save(user);
		map.put("status", 1);
		map.put("message", "Record is Saved Successfully!");
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}
// for getting tha data to Database by id
    @GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			User user = userService.findById(id);
			map.put("status", 1);
			map.put("data", user);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception ex) {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}


    


}
