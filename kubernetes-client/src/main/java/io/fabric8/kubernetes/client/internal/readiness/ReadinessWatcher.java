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
package io.fabric8.kubernetes.client.internal.readiness;

import java.util.concurrent.CountDownLatch;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;

public class ReadinessWatcher<T extends HasMetadata> implements Watcher<T> {

    private final CountDownLatch latch;

    public ReadinessWatcher(CountDownLatch latch) {
        this.latch = latch;
    }

    public void eventReceived(Action action, T resource) {
        switch (action) {
            case MODIFIED:
                if (Readiness.isReady(resource)) {
                    latch.countDown();
                }
                break;
            default:
        }
    }

    @Override
    public void onClose(KubernetesClientException e) {

    }
}
