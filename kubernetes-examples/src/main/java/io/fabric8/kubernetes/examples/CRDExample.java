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

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionList;
import io.fabric8.kubernetes.client.CustomResourceList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.examples.crds.DoneableDummy;
import io.fabric8.kubernetes.examples.crds.Dummy;
import io.fabric8.kubernetes.examples.crds.DummyList;
import io.fabric8.kubernetes.examples.crds.DummySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class CRDExample {

  private static final Logger logger = LoggerFactory.getLogger(CRDExample.class);

  public static String DUMMY_CRD_GROUP = "demo.fabric8.io";
  public static String DUMMY_CRD_NAME = "dummies." +  DUMMY_CRD_GROUP;

  private static boolean logRootPaths = false;

  public static void main(String[] args) {
    String namespace = null;
    if (args.length > 0) {
      namespace = args[0];
    }
    try (final KubernetesClient client = new DefaultKubernetesClient()) {
      if (namespace == null) {
        namespace = client.getNamespace();
      }
      if (namespace == null) {
        System.err.println("No namespace specified and no default defined!");
        return;
      }

      System.out.println("Using namespace: " + namespace);

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
      CustomResourceDefinitionList crds = client.customResourceDefinitions().list();
      List<CustomResourceDefinition> crdsItems = crds.getItems();
      System.out.println("Found " + crdsItems.size() + " CRD(s)");
      CustomResourceDefinition dummyCRD = null;
      for (CustomResourceDefinition crd : crdsItems) {
        ObjectMeta metadata = crd.getMetadata();
        if (metadata != null) {
          String name = metadata.getName();
          System.out.println("    " + name + " => " + metadata.getSelfLink());
          if (DUMMY_CRD_NAME.equals(name)) {
            dummyCRD = crd;
          }
        }
      }
      if (dummyCRD != null) {
        System.out.println("Found CRD: " + dummyCRD.getMetadata().getSelfLink());
      } else {
        dummyCRD = new CustomResourceDefinitionBuilder().
            withApiVersion("apiextensions.k8s.io/v1beta1").
            withNewMetadata().withName(DUMMY_CRD_NAME).endMetadata().
            withNewSpec().withGroup(DUMMY_CRD_GROUP).withVersion("v1").withScope("Namespaced").
              withNewNames().withKind("Dummy").withShortNames("dummy").withPlural("dummies").endNames().endSpec().
            build();

        client.customResourceDefinitions().create(dummyCRD);
        System.out.println("Created CRD " + dummyCRD.getMetadata().getName());
      }


      // lets create a client for the CRD
      NonNamespaceOperation<Dummy, DummyList, DoneableDummy, Resource<Dummy, DoneableDummy>> dummyClient = client.customResource(dummyCRD, Dummy.class, DummyList.class, DoneableDummy.class).inNamespace(namespace);
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

      dummyClient.createOrReplace(dummy);

      System.out.println("Upserted " + dummy);

      System.out.println("Watching for changes to Dummies");
      dummyClient.watch(new Watcher<Dummy>() {
        @Override
        public void eventReceived(Action action, Dummy resource) {
          System.out.println("==> " + action + " for " + resource);
          if (resource.getSpec() == null) {
            logger.error("No Spec for resource " + resource);
          }
        }

        @Override
        public void onClose(KubernetesClientException cause) {
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
