package io.fabric8.kudo.client;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kudo.api.model.v1beta1.InstanceList;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author pangms
 * @date 2020/4/21
 */

public class InstanceOperatorTest {

  @Test
  public void TestUninstall() {
    try {
      InstanceKudoClient client = getCmdClient();
      String instanceName = "zk1";
      // String ns = "kudo-system";
      String ns = "default";
      boolean rs = client.uninstall(instanceName, ns);
      System.out.println("uninstall rs:" + rs);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void TestListInstances() {
    try {
      InstanceKudoClient client = getCmdClient();
      String instanceName = "zk1";
      // String ns = "kudo-system";
      String ns = "default";
      // boolean rs = client.uninstall(instanceName, ns);
      // System.out.println("uninstall rs:" + rs);

      InstanceList instanceList = client.listInstance(ns);
      System.out.println("list:" + instanceList);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private InstanceKudoClient getCmdClient() throws IOException {
    Path adminFile = Paths.get("/Users/lionel/CusData/Projects/Other/kubernetes/kubernetes-client/extensions/kudo/tests/src/test/resources/admin.conf");
    // bytearra
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    Files.copy(adminFile, baos);

    Config config = Config.fromKubeconfig(baos.toString());
    // Kudo
    InstanceKudoClient client = new InstanceKudoClient(config);
    return client;
  }
}
