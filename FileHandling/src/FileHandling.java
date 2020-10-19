import java.io.File;
import java.io.FileInputStream; import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.IOUtils;




public class FileHandling {
    static File folder=new File("./");

    static String temp="";
    public static void main(String[] args) throws
            FileNotFoundException {
        System.out.println("Reading files under the folder --> "+folder.getAbsolutePath());
        listFilesForFolder(folder);

        FileInputStream inputStream=new FileInputStream("F://Codes//JAVA//Files/add.java");

        try {
            String everything=IOUtils.toString(inputStream);
        } catch (IOException e) {
// TODO Auto-generated catch block e.printStackTrace();
        }
    }

    private static void listFilesForFolder(File folder) {
// TODO Auto-generated method stub System.out.println("Java Files are :- "); for( File fileEntry :folder.listFiles()) {
        if(fileEntry.isDirectory()) {

            listFilesForFolder(fileEntry);
        }
        else {
            if(fileEntry.isFile()) {
                temp=fileEntry.getName();

                if((temp.substring(temp.lastIndexOf('.')+1,
                        temp.length()).toLowerCase()).equals("java"))
                {

                    System.out.println(fileEntry.getName());
                }

            }
        }
    }

}
}
