package com.techeazy.lmds.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techeazy.lmds.entity.Client;
import com.techeazy.lmds.repositoryRead.ClientRepositoryRead;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectUserDetailsService implements UserDetailsService {

	@Autowired
	private ClientRepositoryRead clientRepositoryRead;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client client = clientRepositoryRead.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User details not found for the user: " + username));
		List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(client.getRole()));
		return new User(client.getEmail(), client.getPassword(), authorities);
	}

}
