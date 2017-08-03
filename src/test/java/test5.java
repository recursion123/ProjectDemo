import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

public class test5 {
    public interface SiInterface extends StdCallLibrary {
        SiInterface INSTANCE = (SiInterface) Native.loadLibrary("dll/SiInterface", SiInterface.class);//加载系统kernel32 DLL文件，也可以是C++写的DLL文件

        int INIT(String pErrMsg);

        int BUSINESS_HANDLE(String inputData,
                            String outputData);
    }

    public static void main(String[] args) throws Exception {
        //System.setProperty("jna.encoding","GBK");//设置编码，防止乱码


        System.out.println(SiInterface.INSTANCE.INIT("test"));

    }
}
