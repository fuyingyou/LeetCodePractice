package demo.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile reader = new RandomAccessFile("C:\\Users\\69425\\Desktop\\a.txt", "r");
            FileChannel readerChannel = reader.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            readerChannel.read(buffer);
            printState(buffer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 打印buffer的capacity、limit、position、mark的位置
    private static void printState(ByteBuffer buffer) {
        System.out.print("capacity: " + buffer.capacity());
        System.out.print(", limit: " + buffer.limit());
        System.out.print(", position: " + buffer.position());
        System.out.print(", mark 开始读取的字符: " + buffer.mark());
        System.out.println("\n");
    }
}
