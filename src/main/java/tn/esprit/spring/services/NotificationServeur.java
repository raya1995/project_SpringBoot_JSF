package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.UserRepository;


@Service
public class NotificationServeur {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CryptWithMD5 cryptWithMD5;
	public NotificationServeur(JavaMailSender javaMAilSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotification(Client user){
		
		String password="";
		
		for (int i=0;i<10;i++ ) {
			password = password+randomCharacter("abcdefjhijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUV");
		}
		String randomdigit=randomCharacter("123456789");
		password=insertAtRandom(password, randomdigit);
		String randomSymbol=randomCharacter("$£@@@");
		password = insertAtRandom(password, randomSymbol);
		String pass=password;
		String cryptePassword=cryptWithMD5.cryptWithMD5(pass);
		System.out.println("avant base de donne "+cryptePassword);
		
		user.setPassword(cryptePassword);		
		userRepository.save(user);
		System.out.println("apres base de donne "+cryptePassword);
		System.out.println("base de donne "+user.getPassword());
		
		System.out.println(pass);
		//sending email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("oboubaker43@gmail.com");
		mail.setSubject("oussama");
		mail.setText(pass);
		javaMailSender.send(mail);
		System.out.println("apres mail"+user.getPassword());
	}
	public static String randomCharacter(String charachter) {
		int n = charachter.length();
		int r = (int)(n*Math.random());
		
		return charachter.substring(r,r+1);
	}
	public static String insertAtRandom(String str,String toInsert) {
		int n = str.length();
		int r=(int)(n * Math.random());
		return str.substring(0,r)+ toInsert + str.substring(r);
	}	
	
	
	
}
