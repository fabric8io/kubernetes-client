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
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsBuilder;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.examples.crds.Dummy;
import io.fabric8.kubernetes.examples.crds.DummyList;
import io.fabric8.kubernetes.examples.crds.DummySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class CRDExample {

  private static final Logger logger = LoggerFactory.getLogger(CRDExample.class);

  private static final boolean LOG_ROOT_PATHS = false;

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
    try (final KubernetesClient client = new KubernetesClientBuilder().build()) {
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

      if (LOG_ROOT_PATHS) {
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

      CustomResourceDefinitionList crds = client.apiextensions().v1().customResourceDefinitions().list();
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
        dummyCRD = CustomResourceDefinitionContext.v1CRDFromCustomResourceType(Dummy.class)
            .editSpec()
            .editVersion(0)
            .withNewSchema()
            .withNewOpenAPIV3Schema()
            .withTitle("dummy")
            .withType("object")
            .addToRequired("spec")
            .addToProperties("spec", new JSONSchemaPropsBuilder()
                .withType("object")
                .addToProperties("foo", new JSONSchemaPropsBuilder().withType("string").build())
                .addToProperties("bar", new JSONSchemaPropsBuilder().withType("string").build())
                .build())
            .endOpenAPIV3Schema()
            .endSchema()
            .endVersion()
            .endSpec()
            .build();

        client.apiextensions().v1().customResourceDefinitions().resource(dummyCRD).create();
        System.out.println("Created CRD " + dummyCRD.getMetadata().getName());
      }

      // wait a beat for the endpoints to be ready
      Thread.sleep(5000);

      // lets create a client for the CRD
      NonNamespaceOperation<Dummy, DummyList, Resource<Dummy>> dummyClient = client.resources(Dummy.class, DummyList.class);
      if (resourceNamespaced) {
        dummyClient = ((MixedOperation<Dummy, DummyList, Resource<Dummy>>) dummyClient).inNamespace(namespace);
      }
      DummyList dummyList = dummyClient.list();
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

      Dummy created = dummyClient.resource(dummy).createOrReplace();

      System.out.println("Upserted " + dummy);

      created.getSpec().setBar("otherBar");

      dummyClient.resource(created).createOrReplace();

      System.out.println("Watching for changes to Dummies");
      Watch watch = dummyClient.withResourceVersion(created.getMetadata().getResourceVersion()).watch(new Watcher<Dummy>() {
        @Override
        public void eventReceived(Action action, Dummy resource) {
          System.out.println("==> " + action + " for " + resource);
          if (resource.getSpec() == null) {
            logger.error("No Spec for resource {}", resource);
          }
        }

        @Override
        public void onClose(WatcherException cause) {
        }
      });

      System.in.read();

      watch.close();
    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
  }

}
