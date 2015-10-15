package solver.ui;

import javax.swing.JTextArea;

public class Logger {
    
    private JTextArea textarea;
    
    public Logger(JTextArea textarea) {
        this.textarea = textarea;
    }
    
    public void log(String text) {
        System.out.println(text);
        textarea.setText("  " + text);
    }
}
