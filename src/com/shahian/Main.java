package com.shahian;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String encoded= Base64.getEncoder().encodeToString("Hamid Reza".getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);
        String decoded=new String(Base64.getDecoder().decode("SGFtaWQgUmV6YQ=="));
        System.out.println(decoded);
    }
}
