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
        Scanner in = new Scanner(new File("ConfigTemplate.txt"));
        while (in.hasNext()) {
            info.add(in.next());
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
    public String newFile() {
        String builtConfig = "";
        return builtConfig;
    }
}
