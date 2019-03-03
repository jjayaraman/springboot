package com.jai.springboot.ldap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

@Service
public class LdapService {

	@Autowired
	LdapTemplate ldapTemplate;

	public void authenticate(String user, String password) {

		LdapQueryBuilder.query().base("dc=egate-t,dc=local");

		List<String> list = ldapTemplate.list("cn=Administrator,ou=Users,dc=egate-t,dc=local");

		list.forEach(System.out::println);

		// ldapTemplate.authenticate(query, password);
	}

}
