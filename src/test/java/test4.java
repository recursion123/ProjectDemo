import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

public class test4
{
    public interface kernel32 extends StdCallLibrary
    {
        kernel32 INSTANCE = (kernel32)Native.loadLibrary("kernel32",kernel32.class);//加载系统kernel32 DLL文件，也可以是C++写的DLL文件
        int RemoveDirectoryA(String path);
    }
    public static void main(String[] args) throws Exception
    {
        //System.setProperty("jna.encoding","GBK");//设置编码，防止乱码
        System.out.println(kernel32.INSTANCE.RemoveDirectoryA("C:\\Users\\zhang\\Desktop\\11"));

    }
}
