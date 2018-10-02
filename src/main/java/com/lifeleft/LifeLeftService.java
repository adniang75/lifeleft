package com.lifeleft;

import java.time.Year;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService( serviceName = "LifeLeft" )
public class LifeLeftService {

    private static final Integer ESPERANCE_VIE_HOMMES = 79;
    private static final Integer ESPERANCE_VIE_FEMMES = 85;

    private static final String  homme                = "homme";

    Integer                      evDeReference        = 0;

    @WebMethod
    public String anneeRestantesAVivre( String prenom, String sexe, Integer anneeNaissance ) {

        if ( sexe.equalsIgnoreCase( homme ) ) {
            evDeReference = ESPERANCE_VIE_HOMMES;
        } else {
            evDeReference = ESPERANCE_VIE_FEMMES;
        }

        Integer anneeRestantes = evDeReference - ( Year.now().getValue() - anneeNaissance );

        if ( anneeRestantes > 0 ) {
            return "Bonjour " + prenom + ", il vous reste " + anneeRestantes + " à vivre, profitez-en au maximum !";
        } else {
            return "Tout n'est que bonheur !!!!";
        }

    }

}
