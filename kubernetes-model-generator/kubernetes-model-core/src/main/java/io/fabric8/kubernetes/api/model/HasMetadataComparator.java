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
package io.fabric8.kubernetes.api.model;


import java.util.Comparator;

public class HasMetadataComparator implements Comparator<HasMetadata> {

    private Integer getKindValue(String kind) {
        try {
          return switch (kind) {
            case "SecurityContextConstraints" -> 0;
            case "Namespace", "Project", "ProjectRequest" -> 1;
            case "LimitRange" -> 2;
            case "ResourceQuota" -> 3;
            case "RoleBindingRestriction" -> 4;
            case "Secret" -> 12;
            case "ServiceAccount" -> 13;
            case "OAuthClient" -> 14;
            case "Service" -> 15;
            case "PolicyBinding" -> 16;
            case "ClusterPolicyBinding" -> 17;
            case "Role" -> 18;
            case "RoleBinding" -> 19;
            case "PersistentVolume" -> 20;
            case "PersistentVolumeClaim" -> 21;
            case "ImageStream" -> 30;
            case "ImageStreamTag" -> 31;
            default -> 100;
          };
        } catch (IllegalArgumentException e) {
            return 100;
        }
    }

    @Override
    public int compare(HasMetadata a, HasMetadata b) {
        if (a == null || b == null) {
            throw new NullPointerException("Cannot compare null HasMetadata objects");
        }
        if (a == b || a.equals(b)) {
            return 0;
        }

        int kindOrderCompare = getKindValue(a.getKind()).compareTo(getKindValue(b.getKind()));
        if (kindOrderCompare != 0) {
            return kindOrderCompare;
        }

        String classNameA = a.getClass().getSimpleName();
        String classNameB = b.getClass().getSimpleName();

        int classCompare = classNameA.compareTo(classNameB);
        if (classCompare != 0) {
            return classCompare;
        }
        return a.getMetadata().getName().compareTo(b.getMetadata().getName());
    }
}
