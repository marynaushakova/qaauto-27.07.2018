import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BadCode2 {
    public static void main(String args[]) {
        String message = " <!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" " +
                "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> <html xmlns=\"http://www.w3.org/1999/xhtml\"" +
                " lang=\"ru\" xml:lang=\"ru\"> <head> <meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\"> " +
                "<meta name=\"HandheldFriendly\" content=\"true\"> <meta name=\"viewport\" content=\"width=device-width;" +
                " initial-scale=0.666667; maximum-scale=0.666667; user-scalable=0\"> <meta name=\"viewport\" content=\"width=device-width\"> " +
                "<title></title> <!--[if mso]><style type=\"text/css\">body {font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;}" +
                ".phoenix-email-container {width: 512px !important;}</style><![endif]--> <!--[if IE]><style type=\"text/css\">.phoenix-email-container " +
                "{width: 512px !important;}</style><![endif]--> <style type=\"text/css\">@media only screen and (max-width:32em) " +
                "{ .phoenix-email-container { width:100% !important; } } @media only screen and (max-width:20em) {}" +
                " @media only screen and (max-device-width:30em) {} @media screen and (device-width:30em) and " +
                "(device-height:22.5em), screen and (device-width:22.5em) and (device-height:30em), screen and " +
                "(device-width:20em) and (device-height:15em) {} @media screen and (-webkit-min-device-pixel-ratio:0)" +
                " {} @media screen and (max-device-width:25.88em) and (max-device-height:48.5em)" +
                " {} </style> </head> <body style=\"padding:0;margin:0 auto;-webkit-text-size-adjust:100%;width:100% !important;" +
                "-ms-text-size-adjust:100%;font-family:'Helvetica Neue',Helvetica,Arial,sans-serif;\"> <div style=\"overflow:hidden;color:" +
                "transparent;visibility:hidden;mso-hide:all;width:0;font-size:0;opacity:0;height:0;\"> " +
                "Срок действия этой ссылки истечёт через 24&nbsp;часа </div> <table align=\"center\" border=\"0\" cellspacing=\"" +
                "0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#EDF0F3\" style=\"background-color:#EDF0F3;table-layout:fixed;-" +
                "webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> " +
                "<tbody> <tr> <td align=\"center\" style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-" +
                "table-lspace:0pt;-ms-text-size-adjust:100%;\"> <center style=\"width:100%;\"> <table border=\"0\"" +
                " class=\"phoenix-email-container\" cellspacing=\"0\" cellpadding=\"0\" width=\"512\" bgcolor=\"#FFFFFF\" " +
                "style=\"background-color:#FFFFFF;margin:0 auto;max-width:512px;-webkit-text-size-adjust:100%;mso-" +
                "table-rspace:0pt;width:inherit;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <tbody> <tr>" +
                " <td bgcolor=\"#F6F8FA\" style=\"background-color:#F6F8FA;padding:12px;-webkit-text-size-adjust:" +
                "100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;border-bottom:1px solid #ECECEC;\"> " +
                "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"-webkit-text-size-adjust:" +
                "100%;mso-table-rspace:0pt;width:100% !important;mso-table-lspace:0pt;-ms-text-size-adjust:100%;min-width:100% " +
                "!important;\"> <tbody> <tr> <td align=\"left\" valign=\"middle\" style=\"-webkit-text-size-adjust:100%;" +
                "mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\">" +
                "<a href=\"https://www.linkedin.com/comm/feed/?midToken=AQG7vDmxPP930g&amp;trk=eml-security_password_reset_" +
                "checkpoint-header-0-home&amp;trkEmail=eml-security_password_reset_checkpoint-header-0-home-null-b" +
                "3l8q3%7Ejlf1zsbh%7E3h-null-neptune%2Ffeed&amp;lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_" +
                "checkpoint%3B5q39uQUzRSu9jOQgRkREnA%3D%3D\" style=\"cursor:pointer;color:#008CC9;-webkit-text-size-adjust:" +
                "100%;display:inline-block;text-decoration:none;-ms-text-size-adjust:100%;\"> <img alt=\"LinkedIn \"" +
                " border=\"0\" src=\"https://static.licdn.com/scds/common/u/images/email/phoenix/logos/logo_phoenix_" +
                "header_blue_78x66_v1.png\" height=\"34\" width=\"40\" style=\"outline:none;-ms-interpolation-" +
                "mode:bicubic;color:#FFFFFF;text-decoration:none;\"></a></td> <td valign=\"middle\" width=\"100%\" " +
                "align=\"right\" style=\"padding:0 0 0 10px;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;" +
                "mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"><a href=\"https://www.linkedin.com/comm/in/" +
                "miriam-mermaid-663929168?midToken=AQG7vDmxPP930g&amp;trk=eml-security_password_reset_checkpoint" +
                "-header-5-profile&amp;trkEmail=eml-security_password_reset_checkpoint-header-5-profile-null-b3l8q3%7Ejlf1zsbh%7E3h" +
                "-null-neptune%2Fprofile%7Evanity%2Eview&amp;lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3B5q39uQUzRSu9jOQgRkREnA%3D%3D\" " +
                "style=\"cursor:pointer;margin:0;color:#008CC9;-webkit-text-size-adjust:100%;display:inline-block;" +
                "text-decoration:none;-ms-text-size-adjust:100%;\"> <span style=\"word-wrap:break-word;color:#4C4C4C;word-break:break-word;" +
                "font-weight:400;-ms-word-break:break-all;font-size:14px;line-height:1.429;overflow-wrap:break-word;\"" +
                ">Miriam Mermaid</span></a></td> <td width=\"1\" style=\"-webkit-text-size-adjust:100%;mso-table-rspace:" +
                "0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\">&nbsp;</td> </tr> </tbody> </table></td> </tr> " +
                "<tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> " +
                "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"-webkit-text-size-adjust:100%;" +
                "mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <tbody> <tr> <td style=\"padding:20px " +
                "24px 32px 24px;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> " +
                "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"-webkit-text-size-adjust:100%;mso-" +
                "table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <tbody> <tr> <td style=\"-" +
                "webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;padding-" +
                "bottom:20px;\"> <h2 style=\"margin:0;color:#262626;font-weight:700;font-size:20px;line-height:1.2;\">" +
                "Здравствуйте, Miriam!</h2></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;" +
                "mso-table-lspace:0pt;-ms-text-size-adjust:100%;padding-bottom:20px;\"> <p style=\"margin:0;color:#4C4C4C;" +
                "font-weight:400;font-size:16px;line-height:1.25;\">Измените свой пароль, и мы поможем Вам исправить ситуацию." +
                "</p></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-" +
                "ms-text-size-adjust:100%;padding-bottom:20px;\"> <p style=\"margin:0;color:#4C4C4C;font-weight:400;font-" +
                "size:16px;line-height:1.25;\">Чтобы изменить пароль в LinkedIn, " +
                "нажмите <a href=\"<a href=&quot;https://www.linkedin.com/e/v2?e=b3l8q3-jlf1zsbh-3h&amp;lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3B5q39uQUzRSu9jOQgRkREnA%3D%3D&amp;a=checkpoint-password-reset&amp;midToken=AQG7vDmxPP930g&amp;tracking=eml-jav-saved-job&amp;ek=security_password_reset_checkpoint&amp;encryptedEmail=AgEtJpKV6ctV0gAAAWWFbccE3KxwX_d8fPCvbNnbXYTmQdDhZPH6vv8U5pnvXLSY6Dxeog&amp;requestSubmissionId=AgHoJ3GYp7eJyAAAAWWFbccPHRR8rZWIrixRkhWUOCLfXHRZl5NuKylM5w-28NHrt9QF9gGyOSY-UzDf0icnCQKEplGj0D9aF9r49N3cF-s&amp;oneTimeToken=-2592034478138417766&amp;_sig=2iY9BiP0cIwEo1&quot;>[text]</a>\" style=\"cursor:pointer;color:#008CC9;-webkit-text-size-adjust:100%;display:inline-block;text-decoration:none;-ms-text-size-adjust:100%;\">здесь</a> или вставьте в адресную строку браузера следующую ссылку:</p></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;padding-bottom:20px;\"> <p style=\"margin:0;color:#4C4C4C;font-weight:400;font-size:16px;line-height:1.25;\">https://www.linkedin.com/e/v2?e=b3l8q3-jlf1zsbh-3h&amp;lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3B5q39uQUzRSu9jOQgRkREnA%3D%3D&amp;a=checkpoint-password-reset&amp;midToken=AQG7vDmxPP930g&amp;tracking=eml-jav-saved-job&amp;ek=security_password_reset_checkpoint&amp;encryptedEmail=AgEtJpKV6ctV0gAAAWWFbccE3KxwX_d8fPCvbNnbXYTmQdDhZPH6vv8U5pnvXLSY6Dxeog&amp;requestSubmissionId=AgHoJ3GYp7eJyAAAAWWFbccPHRR8rZWIrixRkhWUOCLfXHRZl5NuKylM5w-28NHrt9QF9gGyOSY-UzDf0icnCQKEplGj0D9aF9r49N3cF-s&amp;oneTimeToken=-2592034478138417766&amp;_sig=2iY9BiP0cIwEo1</p></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;padding-bottom:20px;\"> <p style=\"margin:0;color:#4C4C4C;font-weight:400;font-size:16px;line-height:1.25;\">Срок действия этой ссылки истечёт через 24&nbsp;часа, поэтому воспользуйтесь ею прямо сейчас.</p></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;padding-bottom:20px;\"> <p style=\"margin:0;color:#4C4C4C;font-weight:400;font-size:16px;line-height:1.25;\">Благодарим за использование LinkedIn!</p> <p style=\"margin:0;color:#4C4C4C;font-weight:400;font-size:16px;line-height:1.25;\">коллектив компании LinkedIn</p></td> </tr> </tbody> </table></td> </tr> </tbody> </table></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#EDF0F3\" align=\"center\" style=\"background-color:#EDF0F3;padding:0 24px;color:#6A6C6D;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;text-align:center;\"> <tbody> <tr> <td align=\"center\" style=\"padding:16px 0 0 0;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;text-align:center;\"></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <tbody> <tr> <td align=\"center\" style=\"padding:0 0 12px 0;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;text-align:center;\"> <p style=\"margin:0;color:#6A6C6D;font-weight:400;font-size:12px;line-height:1.333;\"></p></td> </tr> <tr> <td align=\"center\" style=\"padding:0 0 12px 0;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;text-align:center;\"> <p style=\"margin:0;word-wrap:break-word;color:#6A6C6D;word-break:break-word;font-weight:400;-ms-word-break:break-all;font-size:12px;line-height:1.333;overflow-wrap:break-word;\">Это сообщение адресовано участнику Miriam Mermaid (QA Tester – Global Solutions). <a href=\"<a class=&quot;phoenix-footer-link&quot; href=&quot;https://www.linkedin.com/e/v2?e=b3l8q3-jlf1zsbh-3h&amp;lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3B5q39uQUzRSu9jOQgRkREnA%3D%3D&amp;a=customerServiceUrl&amp;midToken=AQG7vDmxPP930g&amp;ek=security_password_reset_checkpoint&amp;articleId=4788&quot;>[text]</a>\" style=\"cursor:pointer;color:#6A6C6D;-webkit-text-size-adjust:100%;text-decoration:underline;display:inline-block;-ms-text-size-adjust:100%;\">Что это значит?</a></p></td> </tr> <tr> <td align=\"center\" style=\"padding:0 0 8px 0;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;text-align:center;\"><a href=\"https://www.linkedin.com/comm/feed/?midToken=AQG7vDmxPP930g&amp;trk=eml-security_password_reset_checkpoint-footer-2-home&amp;trkEmail=eml-security_password_reset_checkpoint-footer-2-home-null-b3l8q3%7Ejlf1zsbh%7E3h-null-neptune%2Ffeed&amp;lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3B5q39uQUzRSu9jOQgRkREnA%3D%3D\" style=\"cursor:pointer;color:#6A6C6D;-webkit-text-size-adjust:100%;text-decoration:underline;display:inline-block;-ms-text-size-adjust:100%;\"><img alt=\"LinkedIn \" border=\"0\" height=\"14\" src=\"https://static.licdn.com/scds/common/u/images/email/phoenix/logos/logo_phoenix_footer_darkgray_197x48_v1.png\" width=\"58\" style=\"outline:none;-ms-interpolation-mode:bicubic;color:#FFFFFF;display:block;text-decoration:none;\"></a></td> </tr> <tr> <td align=\"center\" style=\"padding:0 0 12px 0;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;text-align:center;\"> <p style=\"margin:0;color:#6A6C6D;font-weight:400;font-size:12px;line-height:1.333;\">© 2018 LinkedIn Ireland Unlimited Company, Wilton Plaza, Wilton Place, Dublin 2. LinkedIn является зарегистрированным фирменным наименованием LinkedIn Ireland Unlimited Company. LinkedIn и эмблема LinkedIn являются товарными знаками компании LinkedIn.</p></td> </tr> </tbody> </table></td> </tr> </tbody> </table></td> </tr> </tbody> </table> </center></td> </tr> </tbody> </table> <img src=\"https://www.linkedin.com/emimp/ip_WWpOc09IRXpMV3BzWmpGNmMySm9MVE5vOmMyVmpkWEpwZEhsZmNHRnpjM2R2Y21SZmNtVnpaWFJmWTJobFkydHdiMmx1ZEE9PTo=.gif\" style=\"outline:none;-ms-interpolation-mode:bicubic;color:#FFFFFF;text-decoration:none;width:1px;height:1px;\"> </body> </html>";


        String link= message.substring(message.indexOf("<a href=&quot;")+14, message.indexOf("&quot;>"));
        System.out.println("LINK!!:" +link);

    }
}
