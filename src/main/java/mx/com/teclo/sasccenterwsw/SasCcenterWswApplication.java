package mx.com.teclo.sasccenterwsw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan( basePackages = "mx.com")
@EntityScan(basePackages = "mx.com")
public class SasCcenterWswApplication {

	public static void main(String[] args) {
		SpringApplication.run(SasCcenterWswApplication.class, args);
	}
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		return new HibernateJpaSessionFactoryBean();
	}
	@Bean
	public MailSender mailSender() {
		return new JavaMailSenderImpl();
	}
}
