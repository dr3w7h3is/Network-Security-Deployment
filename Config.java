import java.io.*;
import java.util.*;

public class Config {

    List<String> text = new ArrayList<>();
    private static final String PATH = "ConfigTemplate.txt";

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
                "SNMP Server IP:\n\n");
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

        while (in.hasNext()) {
            text.add(in.next());
        }
        in.close();
        text.add("Username: " + getUsername());
        text.add("Password: " + getPassword());
        text.add("Device to Configure IP:  " + getDevice());
        text.add("DNS 1 IP: " + getDNS1());
        text.add("DNS 2 IP: " + getDNS2());
        text.add("Syslog Server IP: " + getSyslog());
        text.add("NTP 1 IP: " + getNTP1());
        text.add("NTP 2 IP: " + getNTP2());
        text.add("Authentication Server 1 IP: " + getAuth1());
        text.add("Authentication Server 2 IP: " + getAuth2());
        text.add("SNMP Server IP: " + getSNMP());

        for (String temp : text) {
            pw.println(temp);
        }
        pw.close();
    }
    private String getUsername() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter Username: ");
        return scan.next();
    }
    private String getPassword() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter Password: ");
        return scan.next();
    }
    private String getDevice() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter MGMT device IP: ");
        return scan.next();
    }
    private String getDNS1() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter DNS 1: ");
        return scan.next();
    }
    private String getDNS2() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter DNS 2: ");
        return scan.next();
    }
    private String getSyslog() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter Syslog: ");
        return scan.next();
    }
    private String getNTP1() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter NTP 1: ");
        return scan.next();
    }
    private String getNTP2() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter NTP 2: ");
        return scan.next();
    }
    private String getAuth1() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter Auth 1: ");
        return scan.next();
    }
    private String getAuth2() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter Auth 2: ");
        return scan.next();
    }
    private String getSNMP() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter SNMP: ");
        return scan.next();
    }
}
