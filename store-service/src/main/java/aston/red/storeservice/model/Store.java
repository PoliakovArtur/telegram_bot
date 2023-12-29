package aston.red.storeservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "stores")
@RequiredArgsConstructor
@Data
public class Store {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
}
