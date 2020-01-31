package com.ssotom.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ssotom.model.User;
import com.ssotom.security.jwt.JwtProvider;

public class Sensor {
	
	String id;
	String accessToken;
	Date expirationDate;
	
	public Sensor(User user) {
		id = user.getUsername();
		accessToken = user.getPassword();
		expirationDate = new Date(user.getCreatedAt().getTime() + JwtProvider.JWT_EXPIRATION_LONG);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@JsonSerialize
	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	@JsonSerialize
	@JsonProperty("expiration_date")
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
