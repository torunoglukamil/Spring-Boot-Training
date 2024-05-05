package com.example.public_transport_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    //@ManyToMany(cascade = CascadeType.ALL)
    //private List<Station> stations;

    //@OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    //private List<Vehicle> vehicles;

}
