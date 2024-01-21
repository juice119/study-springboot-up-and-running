package com.thehecklers.sburrestdemo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.thehecklers.sburrestdemo.coffee.Coffee;
import com.thehecklers.sburrestdemo.coffee.CoffeeRepository;

import jakarta.annotation.PostConstruct;

/**
 * 처음부터 배우는 자바 예제
 */
@SpringBootApplication
public class SburRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SburRestDemoApplication.class, args);
	}

}

@Component
class DataLoader {
	private final CoffeeRepository coffeeRepository;

	public DataLoader(CoffeeRepository coffeeRepository) {
		this.coffeeRepository = coffeeRepository;
	}

	@PostConstruct
	private void loadData() {
		coffeeRepository.saveAll(List.of(
			new Coffee("Café Cereza"),
			new Coffee("Café Ganador"),
			new Coffee("Café Lareño"),
			new Coffee("Café Três Pontas")
		));
	}
}
