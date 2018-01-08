package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.api.model.extensions.NetworkPolicy;
import io.fabric8.kubernetes.api.model.extensions.NetworkPolicyBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.rmi.CORBA.Util;
import java.util.HashMap;

/**
 * Created by hshinde on 1/6/18.
 */
public class NetworkPolicyExample {
  private static final Logger logger = LoggerFactory.getLogger(PodLogExample.class);

  public static void main(String[] args) {
    String namespace = "myproject";

    KubernetesClient client = new DefaultKubernetesClient();

    NetworkPolicy networkPolicy = new NetworkPolicyBuilder()
                                        .withNewMetadata()
                                          .withName("test-network-policy")
                                        .endMetadata()
                                        .withNewSpec()
                                        .withNewPodSelector()
                                          .withMatchLabels( new HashMap<String, String>() {{
                                            put("role","db");
                                          }})
                                        .endPodSelector()
                                        .endSpec()
                                  .build();


    // create polict using NetworkPolicyBuilder object
    networkPolicy = client.extensions()
      .networkPolicies()
      .create(networkPolicy);

    // crate policy using YAML reosurce
    networkPolicy = client.extensions()
                                    .networkPolicies()
                                    .inNamespace(namespace)
                                    .load(NetworkPolicyExample.class.getResourceAsStream("/network-policy.yml"))
                                    .createOrReplace();

  }
}
