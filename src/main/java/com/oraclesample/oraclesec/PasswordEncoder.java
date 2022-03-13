package com.oraclesample.oraclesec;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "users";
//        sabihin natin ung password na gusto mong gamitin ay user dito mo ilalagay sa rawpassword tapos
        //ung output sa baba gaya neto
        // $2a$10$U89LqBxYW4V7cMNjW12Hz.lZN9ThLj/a0TJAkgqA1d551WIq4tegq
        // ayan ung ilalagay mo sa password field
        String encodedPw = encoder.encode(rawPassword);
        System.out.println(encodedPw);
    }
}
