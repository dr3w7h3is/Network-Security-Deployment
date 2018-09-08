import com.jcraft.jsch.*;
import java.io.*;
import java.util.*;

public class Apply {
    List<String> info = new ArrayList<>();

    private static final int PORT = 22;
    private String user;
    private String password;
    private String IP;
    private String builtConfig;

    public Apply() throws IOException {
        Scanner in = new Scanner(new File("ConfigTemplate.txt"));

        while (in.hasNext()) {
            info.add(in.next());
        }
        in.close();
        user = info.get(0);
        password = info.get(1);
        IP = info.get(2);
        Build config = new Build();
        builtConfig = config.newFile();
    }
    public void applyConfig() throws Exception {
        JSch ssh = new JSch();

        Session session = ssh.getSession(user, IP, PORT);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();

        Channel channel = session.openChannel("shell");
        channel.connect();
        OutputStream output = channel.getOutputStream();
        PrintStream commandStream = new PrintStream(output, true);

        InputStream input = channel.getInputStream();

        Scanner scan = new Scanner(new File(builtConfig));
        while (scan.hasNextLine()) {
            commandStream.println(scan.nextLine());
        }
        commandStream.close();

        PrintResult results = new PrintResult(input, channel);

        channel.disconnect();
        session.disconnect();
        scan.close();
    }
}
