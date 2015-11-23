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

import io.fabric8.kubernetes.client.Callback;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecPipesExample {

    public static void main(String[] args) throws InterruptedException, IOException {
        String master = "https://localhost:8443/";
        String podName = null;

        if (args.length == 2) {
            master = args[0];
            podName = args[1];
        }
        if (args.length == 1) {
            podName = args[0];
        }

        Config config = new ConfigBuilder().withMasterUrl(master).build();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try (
                KubernetesClient client = new DefaultKubernetesClient(config);
                ExecWatch watch = client.pods().withName(podName)
                        .redirectingInput()
                        .redirectingOutput()
                        .exec();
                InputStreamPumper pump = new InputStreamPumper(watch.getOutput(), new SystemOutCallback()))
        {

            executorService.submit(pump);
            watch.getInput().write("ls -al\n".getBytes());
            Thread.sleep(5 * 1000);
        } catch (Exception e) {
            throw KubernetesClientException.launderThrowable(e);
        } finally {
            executorService.shutdownNow();
        }
    }

    private static class SystemOutCallback implements Callback<byte[]> {
        @Override
        public void call(byte[] data) {
            System.out.print(new String(data));
        }
    }
}
