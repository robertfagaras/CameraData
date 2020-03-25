package com.robertfagaras.lpc;

import com.robertfagaras.lpc.utils.JavaWatchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@SpringBootApplication
@EnableScheduling
public class LpcApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(LpcApplication.class, args);
	}

}
