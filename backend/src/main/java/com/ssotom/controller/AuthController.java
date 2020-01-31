package com.ssotom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssotom.model.User;
import com.ssotom.repository.UserRepository;
import com.ssotom.request.LoginForm;
import com.ssotom.response.ErrorResponse;
import com.ssotom.response.JwtResponse;
import com.ssotom.response.MessageResponse;
import com.ssotom.security.jwt.JwtProvider;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest, BindingResult result) {
		
		if(result.hasErrors()) {
			return ErrorResponse.returnError(result);
		}

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
		if (userRepository.existsByUsername(user.getUsername())) {
			return new ResponseEntity<MessageResponse>(new MessageResponse("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account		
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEnabled(true);

		return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
	}

}
