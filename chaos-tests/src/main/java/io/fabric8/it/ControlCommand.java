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
package io.fabric8.it;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.HashMap;
import java.util.Map;

@Command(name = "control", mixinStandardHelpOptions = true)
public class ControlCommand implements Runnable {

  @CommandLine.Option(names = {
      "--num" }, paramLabel = "<num>", defaultValue = "10", description = "The number to be reached to quit successfully")
  int num;

  @CommandLine.Option(names = {
      "--namespace" }, paramLabel = "<namespace>", defaultValue = "default", description = "The namespace where the configMap will be created")
  String namespace;

  @CommandLine.Option(names = {
      "--labelkey" }, paramLabel = "<labelKey>", defaultValue = "chaos", description = "The label key to match")
  String labelKey;

  @CommandLine.Option(names = {
      "--labelvalue" }, paramLabel = "<labelValue>", defaultValue = "test", description = "The label value to match")
  String labelValue;

  @CommandLine.Option(names = {
      "--delay" }, paramLabel = "<delay>", defaultValue = "1000", description = "The delay between each number increase")
  int delay;

  private static final String COUNTER = "counter";

  private int extractValue(ConfigMap configMap) {
    return Integer.parseInt(configMap.getData().get(COUNTER));
  }

  @Override
  public void run() {
    System.out.println("Running Control App");
    KubernetesClient client = new KubernetesClientBuilder().build();

    Map<String, String> labels = new HashMap<>();
    labels.put(labelKey, labelValue);
    Map<String, String> data = new HashMap<>();
    data.put("counter", Integer.toString(0));
    ConfigMap defaultConfigMap = new ConfigMapBuilder()
        .withNewMetadata()
        .withName("chaos-test")
        .withNamespace(namespace)
        .withLabels(labels)
        .endMetadata()
        .withData(data)
        .build();

    if (client.resource(defaultConfigMap).inNamespace(namespace).get() != null) {
      System.out.println("ConfigMap detected removing it before starting");
      client.resource(defaultConfigMap).inNamespace(namespace).delete();
    }
    client.resource(defaultConfigMap).inNamespace(namespace).create();

    while (true) {
      try {
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      ConfigMap currentConfigMap = client.resource(defaultConfigMap).inNamespace(namespace).get();

      if (currentConfigMap == null) {
        throw new RuntimeException("Cannot find the configMap!");
      } else {
        int counter = extractValue(currentConfigMap);
        System.out.println("going to increment the value, current: " + counter);

        if (counter == num) {
          System.out.println("I'm done here!");
          break;
        } else if (counter > num) {
          throw new RuntimeException("Something went wrong!");
        } else {
          currentConfigMap.getData().put(COUNTER, Integer.toString(counter + 1));
          client.resource(currentConfigMap).inNamespace(namespace).createOrReplace();
          System.out.println("Counter incremented");
        }
      }
    }

    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Finished! deleting the ConfigMap");
    client.resource(defaultConfigMap).inNamespace(namespace).delete();
  }

  public static void main(String[] args) {
    int exitCode = new CommandLine(new ControlCommand()).execute(args);
    System.exit(exitCode);
  }

}
