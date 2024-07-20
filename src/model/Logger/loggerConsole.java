package model.Logger;

// Nous pouvons afficher les résultats pertinents du traitement des informations sur
// Console en appelant cette méthode.
public class loggerConsole extends Logger{
    public loggerConsole( ) {
        super( );
    }

    @Override
    public void log(loggerLevel level, String messagePrint) {
        System.out.println("Message Level: "+level +"."+"Here is the message: "+messagePrint);

    }


}