import com.android.dx.io.DexBuffer;
import com.android.dx.merge.CollisionPolicy;
import com.android.dx.merge.DexMerger;

import java.io.File;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        DexBuffer dexA = new DexBuffer(new File("C:\\Users\\lenovo\\Desktop\\classes.dex"));
        dexA.strings().get(1);
        dexA.putMapping("Lcom/luyd/MainApplication;", "Lcom/luyd/TestApplication;");
//        dexA.putMapping("load", "anyeLead");

//	for (int i = 0; i <  dexA.strings().size(); i++)
//	{
//	    System.out.println(dexA.strings().get(i));
//	}
//	System.out.println(dexA.sortStrings(false));

        DexBuffer dex = new DexBuffer();
        DexMerger dm = new DexMerger(dexA, dex, CollisionPolicy.KEEP_FIRST);
        DexBuffer buff = dm.merge();
        buff.writeTo(new File("C:\\Users\\lenovo\\Desktop\\test.dex"));

    }
}
