package com.yorky.inventoryservice;

import com.yorky.inventoryservice.model.Inventory;
import com.yorky.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setQuantity(2);
            inventory.setSkuCode("Samsung");

            Inventory inventory1 = new Inventory();
            inventory1.setQuantity(0);
            inventory1.setSkuCode("Iphone");

            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory);
        };
    }
}
