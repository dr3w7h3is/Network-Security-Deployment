/**
 * Version: v0.2.0
 * update note: added UI to command line
 */

import java.io.*;

public class NSD {
    public static void main(String[] args) throws IOException {
        int choice;

        Menu menu = new Menu();
        Config config = new Config();
        Apply apply = new Apply();
        Check check = new Check();
        try {
            do {
                menu.display();
                choice = menu.getSelection();
                switch (choice) {
                    case 1: config.showConfig(); break;
                    case 2: config.editConfig(); break;
                    case 3: apply.applyConfig(); break;
                    case 4: check.complianceCheck(); break;
                }
            } while (choice != 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
