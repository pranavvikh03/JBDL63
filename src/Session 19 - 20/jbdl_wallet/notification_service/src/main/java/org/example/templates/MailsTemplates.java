package org.example.templates;

import org.example.dto.MailComponents;
import org.springframework.stereotype.Service;

@Service
public class MailsTemplates {

    public static MailComponents getWalletCreationMailBody() {
       return MailComponents.builder()
               .mailSubject("New JBDL Wallet Onboarding")
               .mailBody("Hi %s, \n " +
                       "Your JBDL Wallet account is Created. Now you have Unlimited access to Features offered by JBDL Wallet. \n" +
                       "You daily limit is Rs. 10000 and daily Transactions limit is 10. You can update this anytime you want.\n" +
                       "Thanks & Regards,\n" +
                       "JBDL Wallet Team")
               .build();
    }
}
