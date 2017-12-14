package project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Readers {
    private BufferedReader reader;
    private InputStreamReader isr;

    public Readers() {
        isr = new InputStreamReader(System.in);
        reader = new BufferedReader(isr);
    }

    public String readString() throws IOException {
            return reader.readLine();
    }

    public int readInt() throws IOException {
        return Integer.parseInt(readString());
    }
}
