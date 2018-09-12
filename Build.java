import com.jcraft.jsch.IO;

import java.io.*;
import java.util.*;

public class Build {
    List<String> info = new ArrayList<>();
    private String DNS1;
    private String DNS2;
    private String Syslog;
    private String NTP1;
    private String NTP2;
    private String Auth1;
    private String Auth2;
    private String SNMP;

    public Build() throws IOException {
        Scanner in = new Scanner(new File("BaseIPList.txt"));
        while (in.hasNext()) {
            info.add(in.nextLine());
        }
        in.close();
        DNS1 = info.get(3);
        DNS2 = info.get(4);
        Syslog = info.get(5);
        NTP1 = info.get(6);
        NTP2 = info.get(7);
        Auth1 = info.get(8);
        Auth2 = info.get(9);
        SNMP = info.get(10);
    }
    public String newFile() throws IOException {
        String path = "ConfigTemplate.txt";
        PrintWriter pw = new PrintWriter(new FileWriter(path));
        pw.println("! Config file for Device: ");
        pw.println("conf t");
        pw.println("!");
        pw.println("ip name-server " + DNS1 + " " + DNS2);
        pw.println("!");
        pw.println("logging host " + Syslog + " session-id hostname");
        pw.println("!");
        pw.println("ntp server " + NTP1 + " " + "version 4");
        pw.println("ntp server " + NTP2 + " " + "version 4");
        pw.println("!");
        /**
        pw.println("aaa new-model");
        pw.println("aaa authentication login CON local");
        pw.println("aaa authentication login DEFAULT local");
        pw.println("aaa group server tacacs+ AUTH-SVR");
        pw.println(" server " + Auth1);
        pw.println(" server " + Auth2);
        pw.println("!");
        pw.println("aaa authentication login VTY group AUTH-SVR local");
        pw.println("!");
        pw.println("line vty 0 15");
        pw.println(" login authentication VTY");
        pw.println("!");
         */
        pw.println("snmp-server view TestView Internet included");
        pw.println("snmp-server group TestGroup v3 priv Read TestView Write TestView");
        pw.println("snmp-server user TestUser TestGroup v3 auth SHA P@ssword priv AES P@ssword");
        pw.println("snmp-server host " + SNMP + " version 3 priv TestUser");
        pw.println("!");
        pw.close();

        return path;
    }
}
