/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionList;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.CustomResourceList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.examples.crds.Dummy;
import io.fabric8.kubernetes.examples.crds.DummyList;
import io.fabric8.kubernetes.examples.crds.DummySpec;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class CRDExample {

  private static final Logger logger = LoggerFactory.getLogger(CRDExample.class);

  private static boolean logRootPaths = false;

  /**
   * Example of Cluster and Namespaced scoped K8S Custom Resources.
   * To test Cluster scoped resource use "--cluster" as first argument.
   * To test Namespaced resource provide namespace as first argument (namespace must exists in K8S).
   *
   * @param args Either "--cluster" or namespace name.
   */
  public static void main(String[] args) {
    boolean resourceNamespaced = true;
    String namespace = null;
    if (args.length > 0) {
      if ("--cluster".equals(args[0])) {
        resourceNamespaced = false;
      } else {
        namespace = args[0];
      }
    }
    try (final KubernetesClient client = new DefaultKubernetesClient()) {
      if (resourceNamespaced) {
        if (namespace == null) {
          namespace = client.getNamespace();
        }
        if (namespace == null) {
          System.err.println("No namespace specified and no default defined!");
          return;
        }

        System.out.println("Using namespace: " + namespace);
      } else {
        System.out.println("Creating cluster scoped resource");
      }

      if (logRootPaths) {
        RootPaths rootPaths = client.rootPaths();
        if (rootPaths != null) {
          List<String> paths = rootPaths.getPaths();
          if (paths != null) {
            System.out.println("Supported API Paths:");
            for (String path : paths) {
              System.out.println("    " + path);
            }
            System.out.println();
          }
        }
      }

      CustomResourceDefinitionList crds = client.apiextensions().v1beta1().customResourceDefinitions().list();
      List<CustomResourceDefinition> crdsItems = crds.getItems();
      System.out.println("Found " + crdsItems.size() + " CRD(s)");
      CustomResourceDefinition dummyCRD = null;
      final String dummyCRDName = CustomResource.getCRDName(Dummy.class);
      for (CustomResourceDefinition crd : crdsItems) {
        ObjectMeta metadata = crd.getMetadata();
        if (metadata != null) {
          String name = metadata.getName();
          System.out.println("    " + name + " => " + metadata.getSelfLink());
          if (dummyCRDName.equals(name)) {
            dummyCRD = crd;
          }
        }
      }
      if (dummyCRD != null) {
        System.out.println("Found CRD: " + dummyCRD.getMetadata().getSelfLink());
      } else {
        dummyCRD = CustomResourceDefinitionContext.v1beta1CRDFromCustomResourceType(Dummy.class).build();
        client.apiextensions().v1beta1().customResourceDefinitions().create(dummyCRD);
        System.out.println("Created CRD " + dummyCRD.getMetadata().getName());
      }

      KubernetesDeserializer.registerCustomKind(HasMetadata.getApiVersion(Dummy.class), dummyCRD.getKind(), Dummy.class);

      // lets create a client for the CRD
      NonNamespaceOperation<Dummy, DummyList, Resource<Dummy>> dummyClient = client.customResources(Dummy.class, DummyList.class);
      if (resourceNamespaced) {
        dummyClient = ((MixedOperation<Dummy, DummyList, Resource<Dummy>>) dummyClient).inNamespace(namespace);
      }
      CustomResourceList<Dummy> dummyList = dummyClient.list();
      List<Dummy> items = dummyList.getItems();
      System.out.println("  found " + items.size() + " dummies");
      for (Dummy item : items) {
        System.out.println("    " + item);
      }

      Dummy dummy = new Dummy();
      ObjectMeta metadata = new ObjectMeta();
      metadata.setName("foo");
      dummy.setMetadata(metadata);
      DummySpec dummySpec = new DummySpec();
      Date now = new Date();
      dummySpec.setBar("beer: " + now);
      dummySpec.setFoo("cheese: " + now);
      dummy.setSpec(dummySpec);

      Dummy created = dummyClient.createOrReplace(dummy);

      System.out.println("Upserted " + dummy);

      created.getSpec().setBar("otherBar");

      dummyClient.createOrReplace(created);

      System.out.println("Watching for changes to Dummies");
      dummyClient.withResourceVersion(created.getMetadata().getResourceVersion()).watch(new Watcher<Dummy>() {
        @Override
        public void eventReceived(Action action, Dummy resource) {
          System.out.println("==> " + action + " for " + resource);
          if (resource.getSpec() == null) {
            logger.error("No Spec for resource " + resource);
          }
        }

        @Override
        public void onClose(WatcherException cause) {
        }
      });

      System.in.read();

    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
  }

}
