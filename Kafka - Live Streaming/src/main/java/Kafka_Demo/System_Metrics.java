package Kafka_Demo;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class System_Metrics {
    public void sys_metrics() {
        while (true) {

            OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

            String x = String.valueOf(osBean.getSystemCpuLoad());

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            Main send_metric = new Main();

            send_metric.print(x);

        }
    }
}