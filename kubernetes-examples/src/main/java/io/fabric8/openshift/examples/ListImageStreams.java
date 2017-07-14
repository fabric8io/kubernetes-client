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

package io.fabric8.openshift.examples;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamList;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftAPIGroups;
import io.fabric8.openshift.client.OpenShiftClient;

import java.util.List;

public class ListImageStreams {
  public static void main(String[] args) {
    try {
      OpenShiftClient client = new DefaultOpenShiftClient();
      if (!client.supportsOpenShiftAPIGroup(OpenShiftAPIGroups.IMAGE)) {
        System.out.println("WARNING this cluster does not support the API Group " + OpenShiftAPIGroups.IMAGE);
        return;
      }
      ImageStreamList list = client.imageStreams().list();
      if (list == null) {
        System.out.println("ERROR no list returned!");
        return;
      }
      List<ImageStream> items = list.getItems();
      for (ImageStream item : items) {
        System.out.println("ImageStream " + item.getMetadata().getName() + " has version: " + item.getApiVersion());
      }
      System.out.println("Found " + items.size() + " ImageStream(s)");
    } catch (KubernetesClientException e) {
      System.out.println("Failed: " + e);
      e.printStackTrace();
    }
  }

}
