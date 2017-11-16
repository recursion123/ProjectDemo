import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserFrame {

    public void dealFile(String sourcePath, String targetPath) {
        File file = new File(sourcePath);
        if (file.isFile() && (file.getName().endsWith("js") || file.getName().endsWith("jsp"))) {
            parserFile(sourcePath, targetPath);
        } else if (file.isDirectory()) {
            try {
                File fileDir = new File(file.getPath().replace(sourcePath, targetPath));
                if (!fileDir.exists()) {
                    Files.copy(file.toPath(), fileDir.toPath());
                }
                Arrays.stream(file.listFiles()).forEach(tempFile -> {
                    dealFile(tempFile.getPath(), tempFile.getPath().replace(sourcePath, targetPath));
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void parserFile(String sourcePath, String targetPath) {
        try {
            Boolean needDeal=false;
            String tileStr = new String(Files.readAllBytes(Paths.get(sourcePath)), "GBK");
             //Pattern p = Pattern.compile("frames\\([^\\)]*\\)");
            Pattern p = Pattern.compile("frames\\(([^()]+|\\(([^()]+)*\\))*\\)");
            Matcher m = p.matcher(tileStr);
            while (m.find()) {
                needDeal=true;
                StringBuffer tempStr = new StringBuffer(m.group(0).replaceFirst("\\(", "["));
                tempStr.setCharAt(tempStr.length() - 1, ']');
                System.out.println(sourcePath+" ******* "+m.group(0));
                System.out.println(targetPath+" ******* "+tempStr.toString());
                tileStr = tileStr.replace(m.group(0), tempStr.toString());
            }
            if(needDeal){
                Files.write(Paths.get(targetPath), tileStr.getBytes("GBK"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test() throws IOException {
        String sourcePath = "C:\\Users\\zhang\\Desktop\\ROOT";
        String targetPath = "C:\\Users\\zhang\\Desktop\\ROOT2";
        dealFile(sourcePath, targetPath);
    }
}
