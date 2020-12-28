package com.toystore.ecomm.payments;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.toystore.ecomm.payments.model.audit.AuditorAwareImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@ComponentScan(basePackages = { "com.toystore.ecomm.payments", "com.toystore.ecomm.payments.controller",
								"com.toystore.ecomm.payments.config", "com.toystore.ecomm.payments.exception",
								"com.toystore.ecomm.payments.model", "com.toystore.ecomm.payments.repository",
								"com.toystore.ecomm.payments.services", "com.toystore.ecomm.payments.util" })

public class Swagger2SpringBoot implements CommandLineRunner {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
	}

	public static void main(String[] args) throws Exception {
		new SpringApplication(Swagger2SpringBoot.class).run(args);
	}

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}

	}
}
