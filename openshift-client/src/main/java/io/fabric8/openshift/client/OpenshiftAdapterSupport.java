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

package io.fabric8.openshift.client;

import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class OpenshiftAdapterSupport {

    static final ConcurrentMap<URL, Boolean> IS_OPENSHIFT = new ConcurrentHashMap<>();
    static final ConcurrentMap<URL, Boolean> USES_OPENSHIFT_APIGROUPS = new ConcurrentHashMap<>();

    public Boolean isAdaptable(Client client) {
        OpenShiftConfig config = new OpenShiftConfig(client.getConfiguration());
        if (!hasCustomOpenShiftUrl(config) && !isOpenShift(client)) {
            return false;
        }
        return true;
    }

    /**
     * Check if OpenShift is available.
     * @param client   The client.
     * @return         True if oapi is found in the root paths.
     */
    static boolean isOpenShift(Client client) {
        URL masterUrl = client.getMasterUrl();
        if (IS_OPENSHIFT.containsKey(masterUrl)) {
            return IS_OPENSHIFT.get(masterUrl);
        } else {
            RootPaths rootPaths = client.rootPaths();
            if (rootPaths != null) {
                List<String> paths = rootPaths.getPaths();
                if (paths != null) {
                    for (String path : paths) {
                        // lets detect the new API Groups APIs for OpenShift
                        if (path.endsWith(".openshift.io") || path.contains(".openshift.io/")) {
                            USES_OPENSHIFT_APIGROUPS.putIfAbsent(masterUrl, true);
                            IS_OPENSHIFT.putIfAbsent(masterUrl, true);
                            return true;
                        }
                    }
                    for (String path : paths) {
                        if (java.util.Objects.equals("/oapi", path) || java.util.Objects.equals("oapi", path)) {
                            IS_OPENSHIFT.putIfAbsent(masterUrl, true);
                            return true;
                        }
                    }
                }
            }
        }
        IS_OPENSHIFT.putIfAbsent(masterUrl, false);
        return false;
    }

    /**
     * Check if OpenShift API Groups are available
     * @param client   The client.
     * @return         True if the new <code>/apis/*.openshift.io/</code> APIs are found in the root paths.
     */
    static boolean isOpenShiftAPIGroups(Client client) {
        Config configuration = client.getConfiguration();
        if (configuration instanceof OpenShiftConfig) {
            OpenShiftConfig openShiftConfig = (OpenShiftConfig) configuration;
            if (openShiftConfig.isDisableApiGroupCheck()) {
                return false;
            }
        }
        URL masterUrl = client.getMasterUrl();
        if (isOpenShift(client) && USES_OPENSHIFT_APIGROUPS.containsKey(masterUrl)) {
            return USES_OPENSHIFT_APIGROUPS.get(masterUrl);
        }
        return false;
    }


    /**
     * Checks if a custom URL for OpenShift has been used.
     * @param config  The openshift configuration.
     * @return        True if both master and openshift url have the same root.
     */
    static boolean hasCustomOpenShiftUrl(OpenShiftConfig config) {
        try {
            URI masterUri = new URI(config.getMasterUrl()).resolve("/");
            URI openshfitUri = new URI(config.getOpenShiftUrl()).resolve("/");
            return !masterUri.equals(openshfitUri);
        } catch (Exception e) {
            throw KubernetesClientException.launderThrowable(e);
        }
    }
}
