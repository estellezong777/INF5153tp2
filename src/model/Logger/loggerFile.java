package model.Logger;


import java.io.*;
// Les résultats pertinents du traitement des informations sont enregistrées dans un fichier 'fileName' qui est défini
//dans le Main. Ici, nous utilisons 'log.txt'
public class loggerFile extends Logger implements AutoCloseable{
    private final PrintWriter writer;

    public loggerFile( String fileName) throws IOException{
        super( );
        this.writer = new PrintWriter(new FileWriter(fileName,true));
    }
    @Override
    public void log(loggerLevel level, String message) {
        writer.println("[" + level + "] " + message);
        writer.flush();
    }

    @Override
    public void close() {
        writer.close();
    }
}
