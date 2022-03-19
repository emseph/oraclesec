//package com.oraclesample.oraclesec.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table
//public class UserRole {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
//    private User user;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
//    private Role role;
//}