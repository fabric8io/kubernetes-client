package io.fabric8.kubernetes.examples;

import com.ning.http.client.ws.WebSocket;
import io.fabric8.kubernetes.DefaultKubernetesClient;
import io.fabric8.kubernetes.KubernetesClient;
import io.fabric8.kubernetes.KubernetesClientException;
import io.fabric8.kubernetes.Watcher;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.Pod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WatchExamples {

  private static final Logger logger = LoggerFactory.getLogger(WatchExamples.class);

  public static void main(String[] args) {
    KubernetesClient client = null;

    String master = "https://localhost:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    try {
      client = new DefaultKubernetesClient.Builder().configFromSysPropsOrEnvVars().masterUrl(master).build();

     WebSocket websocket = client.namespaces().watch(new Watcher<Namespace>() {
        @Override
        public void eventReceived(Action action, Namespace resource) {
          System.out.println(action + ": " + resource);
        }
      });

      Thread.sleep(10000);
      websocket.close();

      websocket = client.pods().inNamespace("default").withLabel("mq", "rabbitmq").watch(new Watcher<Pod>() {
        @Override
        public void eventReceived(Action action, Pod resource) {
          System.out.println(action + ": " + resource);
        }
      });

      Thread.sleep(10000);
      websocket.close();
    } catch (KubernetesClientException | InterruptedException e) {
      logger.error(e.getMessage(), e);
    } finally {
      if (client != null) {
        client.close();
      }
    }
  }

}
