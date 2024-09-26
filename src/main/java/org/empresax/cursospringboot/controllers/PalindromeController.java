package org.empresax.cursospringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para verificar palíndromos
 */
@RestController
public class PalindromeController {
    /**
     *
     * @param word La palabra a verificar
     * @return Mensaje indicando si la palabra es palindrome o no
     */
    @GetMapping("/palindrome/{word}")
    public String Palindrome(@PathVariable String word) {
        boolean palindrome = isPalindrome(word);
        if (palindrome) {
            return "La palabra \" + word + \" ES palindrome";
        }
        return "La palabra " + word + " NO es palindrome";
    }

    private boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
