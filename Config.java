import java.io.*;
import java.util.*;

public class Config {

    List<String> text = new ArrayList<>();
    private static final String PATH = "DeviceInfo.txt";
    private String username;
    private String password;
    private String mgmtDevice;
    private String DNS1;
    private String DNS2;
    private String Syslog;
    private String NTP1;
    private String NTP2;
    private String Auth1;
    private String Auth2;
    private String SNMP;

    public Config() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(PATH));

        pw.println("Username:\n" +
                "Password:\n" +
                "Device to Configure IP:\n" +
                "DNS 1 IP:\n" +
                "DNS 2 IP:\n" +
                "Syslog Server IP:\n" +
                "NTP 1 IP:\n" +
                "NTP 2 IP:\n" +
                "Authentication Server 1 IP:\n" +
                "Authentication Server 2 IP:\n" +
                "SNMP Server IP:\n");
        pw.close();
    }
    public void showConfig() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(PATH));
        String text;
        while (in.ready()) {
            text = in.readLine();
            System.out.println(text);
        }
        in.close();
    }
    public void editConfig()throws IOException {
        Scanner in = new Scanner(new File(PATH));
        PrintWriter pw = new PrintWriter(new FileWriter(PATH));
        PrintWriter pw2 = new PrintWriter(new FileWriter("BaseIPList.txt"));

        getData();

        while (in.hasNext()) {
            text.add(in.next());
        }
        in.close();

        text.add("Username: " + username);
        text.add("Password: " + password);
        text.add("Device to Configure IP:  " + mgmtDevice);
        text.add("DNS 1 IP: " + DNS1);
        text.add("DNS 2 IP: " + DNS2);
        text.add("Syslog Server IP: " + Syslog);
        text.add("NTP 1 IP: " + NTP1);
        text.add("NTP 2 IP: " + NTP2);
        text.add("Authentication Server 1 IP: " + Auth1);
        text.add("Authentication Server 2 IP: " + Auth2);
        text.add("SNMP Server IP: " + SNMP);

        for (String temp : text) {
            pw.println(temp);
        }
        pw2.print(username + "\n" +
                password + "\n" +
                mgmtDevice + "\n" +
                DNS1 + "\n" +
                DNS2 + "\n" +
                Syslog + "\n" +
                NTP1 + "\n" +
                NTP2 + "\n" +
                Auth1 + "\n" +
                Auth2 + "\n" +
                SNMP + "\n");
        pw.close();
        pw2.close();
    }
    private void getData() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter Username: ");
        username = scan.next();
        System.out.print("Please Enter Password: ");
        password = scan.next();
        System.out.print("Please Enter MGMT device IP: ");
        mgmtDevice = scan.next();
        System.out.print("Please Enter DNS 1: ");
        DNS1 = scan.next();
        System.out.print("Please Enter DNS 2: ");
        DNS2 = scan.next();
        System.out.print("Please Enter Syslog: ");
        Syslog = scan.next();
        System.out.print("Please Enter NTP 1: ");
        NTP1 = scan.next();
        System.out.print("Please Enter NTP 2: ");
        NTP2 = scan.next();
        System.out.print("Please Enter Auth 1: ");
        Auth1 = scan.next();
        System.out.print("Please Enter Auth 2: ");
        Auth2 = scan.next();
        System.out.print("Please Enter SNMP: ");
        SNMP = scan.next();
    }
}
