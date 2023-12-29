package com.javaintensive.telegrambot;

import org.springframework.stereotype.Component;

@Component
public class CardValidator {
    public boolean isValidCardNumber(String cardNumber) {
        return cardNumber.matches("\\d{16}");
    }

    public boolean isValidCardholderName(String cardHolderName) {
        return cardHolderName.matches("\\p{Alpha}+ \\p{Alpha}+");
    }

    public boolean isValidCardDate(String cardDate) {
        if(cardDate.matches("\\d{2}/\\d{2}")) {
            String month = cardDate.substring(0, 2);
            if(month.charAt(0) != '0') {
                int number = Integer.parseInt(month);
                if(number > 12) return false;
            } else {
                if(month.charAt(1) == '0')
                    return false;
            }
            String year = cardDate.substring(3);
            if(year.charAt(0) != '0') {
                int number = Integer.parseInt(year);
                return number > 23 && number < 27;
            }
        }
        return false;
    }

    public boolean isValidCvv(String cvv) {
        return cvv.matches("\\d{3}");
    }
}
