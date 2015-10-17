package solver.ui;

import javax.swing.JTextArea;

/**
 * Luokka sisältää toiminnallisuuden ilmoitusten näyttämiseen käyttäjälle.
 */
public class Logger {
    
    private JTextArea textarea;
    
    /**
     * Konstruktori luo uuden ilmoittajan.
     * 
     * @param textarea Tekstikenttä, johon ilmoitukset näytetään
     */
    public Logger(JTextArea textarea) {
        this.textarea = textarea;
    }
    
    /**
     * Metodi ilmoittaa halutun tekstin käyttäjälle.
     * 
     * @param text Teksti, joka halutaan näyttää 
     */
    public void log(String text) {
        System.out.println(text);
        textarea.setText("  " + text);
    }
}
