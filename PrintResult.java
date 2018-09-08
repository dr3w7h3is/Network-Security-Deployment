import com.jcraft.jsch.Channel;
import java.io.InputStream;

public class PrintResult {

    public PrintResult(InputStream input, Channel channel) throws Exception {
        int SIZE = 1024;
        byte[] tmp = new byte[SIZE];
        while (true) {
            while (input.available() > 0) {
                int i = input.read(tmp, 0, SIZE);
                if(i < 0) {
                    break;
                }
                System.out.print(new String(tmp, 0, i));
            }
            if(channel.isClosed()) {
                break;
            }
        }
    }
}
