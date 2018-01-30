package io.fabric8.kubernetes.client;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;

public class WaitTest {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private KubernetesClient client;
    private Pod pod;

    @Before
    public void configure() throws Exception {
        client = new DefaultKubernetesClient();

        String image = "busybox";
        Container c = new ContainerBuilder().withName(image).withImagePullPolicy("IfNotPresent").withImage(image)
                .withCommand("cat").withTty(true).build();
        String podName = "test-waiting-" + RandomStringUtils.random(5, "bcdfghjklmnpqrstvwxz0123456789");
        pod = client.pods().create(new PodBuilder().withNewMetadata().withName(podName).endMetadata().withNewSpec()
                .withContainers(c).endSpec().build());

        System.out.println("Created pod: " + pod.getMetadata().getName());
    }

    @Test(timeout = 100000)
    public void testWaitForPod() throws Exception {
        Thread[] t = new Thread[20];
        List<Boolean> results = Collections.synchronizedList(new ArrayList<Boolean>(t.length));
        for (int i = 0; i < t.length; i++) {
            t[i] = newThread(i, results);
        }
        for (int i = 0; i < t.length; i++) {
            t[i].start();
        }
        for (int i = 0; i < t.length; i++) {
            t[i].join();
        }
        assertEquals("Not all threads finished successfully", t.length, results.size());
        for (Boolean r : results) {
            assertTrue(r);
        }
    }

    private Thread newThread(final int i, final List<Boolean> results) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client.pods().inNamespace(pod.getMetadata().getNamespace()).withName(pod.getMetadata().getName())
                            .waitUntilReady(5, TimeUnit.MINUTES);
                    results.add(Boolean.TRUE);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(dtf.format(LocalDateTime.now()) + " Thread " + i + " finished");
                }
            }
        }, "test-" + i);
    }

}
