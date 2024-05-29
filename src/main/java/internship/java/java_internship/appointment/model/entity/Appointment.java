package internship.java.java_internship.appointment.model.entity;

import internship.java.java_internship.animal.cat.model.entity.Cat;
import internship.java.java_internship.client.model.entity.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    UUID id;
    @NotNull
    String clientPESEL;
    @NotNull
    UUID catId;
    @NotNull
    LocalDateTime date;
}
