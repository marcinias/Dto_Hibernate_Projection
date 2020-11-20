package pl.sixfaces.relationship_db;

import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import pl.sixfaces.relationship_db.model.*;
import pl.sixfaces.relationship_db.repository.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableJpaAuditing
@SpringBootApplication
public class RelationshipDbApplication {


    public static void main(String[] args) {
        SpringApplication.run(RelationshipDbApplication.class, args);
    }


}
