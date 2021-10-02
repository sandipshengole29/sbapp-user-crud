/**
 * 
 */
package com.sbapp.user.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

/**
 * @author user
 *
 */
@Configuration
@EnableEncryptableProperties
public class JasyptConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(JasyptConfig.class);

	@Autowired
	private Environment environment;
	
	@Bean(name = "jasyptStringEncryptor")
	public StringEncryptor encryptor() {
		LOGGER.info("============== inside JasyptConfig -> encryptor ==============");
		final PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
		pbeStringEncryptor.setConfig(getSimpleStringPBEConfig());

		return pbeStringEncryptor;
	}

	public SimpleStringPBEConfig getSimpleStringPBEConfig() {
		LOGGER.info("============== inside JasyptConfig -> getSimpleStringPBEConfig ==============");
		final SimpleStringPBEConfig pbeConfig = new SimpleStringPBEConfig();
		// TODO - hardcoding to be removed -> can be picked via the environment variable
		pbeConfig.setPassword(environment.getProperty("SECRET_ENCRYPTION_KEY"));
		pbeConfig.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
		pbeConfig.setKeyObtentionIterations("1000");
		pbeConfig.setPoolSize("1");
		pbeConfig.setProviderName("SunJCE");
		pbeConfig.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
		pbeConfig.setStringOutputType("base64");

		return pbeConfig;
	}
}
