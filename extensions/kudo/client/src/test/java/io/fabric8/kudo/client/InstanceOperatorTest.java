package io.fabric8.kudo.client;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kudo.v1beta1.Instance;
import io.fabric8.kudo.v1beta1.InstanceList;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

// import edu.stanford.nlp.trees.TreePrint;

/**
 * @author pangms
 * @date 2020/4/21
 */

public class InstanceOperatorTest {

  @Test
  public void TestUninstall() {
    try {
      InstanceKudoClient client = getCmdClient();
      String instanceName = "redis-instance-n1";
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

  @Test
  public void TestInstanceGet() {
    String ns = "default";
    String instance = "redis-instance-n1";
    try {
      Instance i = getCmdClient().instance(ns, instance);
      System.out.println("instance:" + i);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void TestInstanceStatus() {
    String ns = "default";
    String instance = "redis-instance";
    try {
      String i = new PlanKudoClient(getCmdClient()).status(ns, instance, true);
      System.out.println(i);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void TestInstanceHistory() {
    String ns = "default";
    String instance = "redis-instance";
    try {
      String i = new PlanKudoClient(getCmdClient()).history(ns, instance);
      System.out.println(i);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void TestInstanceTriggerPlan() {
    String ns = "default";
    String instance = "n1";
    String plan = "backup";
    // String plan = "deploy-redis";
    try {
      new PlanKudoClient(getCmdClient()).trigger(ns, instance, plan);
      // System.out.println(i);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void TestInstall(){
    String folder = "/Users/lionel/CusData/Projects/Asiainfo/kudo/client/src/test/resources/redis/operator";
    ByteArrayOutputStream operator = new ByteArrayOutputStream();
    ByteArrayOutputStream params = new ByteArrayOutputStream();
    ByteArrayOutputStream config = new ByteArrayOutputStream();
    ByteArrayOutputStream init = new ByteArrayOutputStream();
    ByteArrayOutputStream pdb = new ByteArrayOutputStream();
    ByteArrayOutputStream service = new ByteArrayOutputStream();
    ByteArrayOutputStream statefulset = new ByteArrayOutputStream();
    try {
      Files.copy(Paths.get(folder+"/operator.yaml"), operator);
      Files.copy(Paths.get(folder+"/params.yaml"), params);

      Files.copy(Paths.get(folder+"/templates/configmap.yaml"), config);
      Files.copy(Paths.get(folder+"/templates/init.yaml"), init);
      Files.copy(Paths.get(folder+"/templates/pdb.yaml"), pdb);
      Files.copy(Paths.get(folder+"/templates/service.yaml"), service);
      Files.copy(Paths.get(folder+"/templates/statefulset.yaml"), statefulset);
    } catch (IOException e) {
      e.printStackTrace();
    }

    Map<String, String> tpls = new HashMap<>();
    tpls.put("configmap.yaml", config.toString());
    tpls.put("init.yaml", init.toString());
    tpls.put("pdb.yaml", pdb.toString());
    tpls.put("service.yaml", service.toString());
    tpls.put("statefulset.yaml", statefulset.toString());

    String ns = "default";
    String instance = "redis-instance-n1";
    try {
      InstanceKudoClient client = getCmdClient();
      Instance ki = client.install(instance, ns, operator.toString(), params.toString(), tpls);
      System.out.println("instance:" + ki);
    } catch (IOException e) {
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
