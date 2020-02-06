package com.pkfrc.digital.onboarding.digital_onboarding;

import com.pkfrc.digital.onboarding.digital_onboarding.config.OnBoardingProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ OnBoardingProperties.class })
public class DigitalOnboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalOnboardingApplication.class, args);
	}

}
