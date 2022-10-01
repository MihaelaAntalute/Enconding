package designprinciples.solid.dip.enconding.refactored;

import java.io.IOException;

public class Main {

    public static void main(String[] args)  {

        MyFileWriter myFileWriter = new MyFileWriter("fileEncrypted.txt");
        DatabaseWriter databaseWriter = new DatabaseWriter();
        MyFileReader myFileReader = new MyFileReader("src/main/java/designprinciples/solid/dip/enconding/dirty/fileToBeEncrypted.txt");
        EncodingModule encodingModule = new EncodingModule(myFileReader, myFileWriter);
        try {
            encodingModule.encode();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        encodingModule = new EncodingModule(myFileReader, databaseWriter);
        try {
            encodingModule.encode();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
