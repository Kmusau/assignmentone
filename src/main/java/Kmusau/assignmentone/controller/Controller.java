package Kmusau.assignmentone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Kmusau.assignmentone.model.AuthenticationRequest;
import Kmusau.assignmentone.model.AuthenticationResponse;
import Kmusau.assignmentone.model.Students;
import Kmusau.assignmentone.services.MyUserDetailsService;
import Kmusau.assignmentone.services.StudentsService;
import Kmusau.assignmentone.util.JwtUtil;

@RestController
public class Controller {

	@Autowired
	private StudentsService stservice;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired 
	private JwtUtil jwtTokenUtil;

	@GetMapping("v1/test")
	public String testFunction(){
	    return "Hello World";
	}

	@GetMapping("/")
	public String Home(){
	    return "Welcome home";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
		);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails); 
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@GetMapping("/students")
	public List<Students> allstudents(){
	    return stservice.studentlist();
		}

	@GetMapping("/student/{idnum}")
	public Students singlestudent(@PathVariable String idnum){
		return stservice.singlestudent(idnum);
		}

	@PostMapping("/student/create")
	public void addstudent(@RequestBody Students stu){
		stservice.addstudent(stu);
		}

	@PutMapping("/student/{idnum}")
	public void updatestudent(@RequestBody Students stu, @PathVariable String idnum){
		stservice.updatestudent(idnum, stu);
	}

	
}
