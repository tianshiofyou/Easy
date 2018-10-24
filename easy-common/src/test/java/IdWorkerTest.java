import com.easy.utils.IdWorker;
import org.junit.Test;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/10/8 15:20
 * @Version: 1.0
 */
public class IdWorkerTest {

    @Test
    public void TestMutiIdWorker()
    {
        IdWorker idWorker1 = new IdWorker(0, 0);
        IdWorker idWorker2 = new IdWorker(1, 0);
        Thread t1 = new Thread(() -> DoTestIdWoker(idWorker1, "\tt1\t"));
        Thread t2 = new Thread(() -> DoTestIdWoker(idWorker2, "\tt2\t"));

        t1.start();
        t2.start();
        try {
            Thread.sleep(30000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("done");
    }

    public void TestIdWorker(){
        IdWorker idWorker = new IdWorker(0, 0);
        for (int i = 0; i < 10; i++) {
            long id = idWorker.nextId();
            System.out.println(Long.toBinaryString(id));
            System.out.println(id);
        }
    }

    private static void DoTestIdWoker(IdWorker idWorker, String name)  {
        while (true)
        {
            long id = idWorker.nextId();
            System.out.println("duplicate:" + name + id);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
