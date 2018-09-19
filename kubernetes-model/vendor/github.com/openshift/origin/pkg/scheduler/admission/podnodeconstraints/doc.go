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
/*
Package podnodeconstraints contains the PodNodeConstraints admission
control plugin. This plugin allows administrators to set policy
governing the use of the NodeName and NodeSelector attributes in pod
specs.

Enabling this plugin will prevent the use of the NodeName field in Pod
templates for users and serviceaccounts which lack the "pods/binding"
permission, and which don't belong to groups which have the
"pods/binding" permission.

This plugin will also prevent users, serviceaccounts and groups which
lack the "pods/binding" permission from specifying the NodeSelector field
in Pod templates for labels which appear in the
nodeSelectorLabelBlacklist list field.

Configuration

The plugin is configured via a PodNodeConstraintsConfig object in the
origin and kubernetes Master configs:

admissionConfig:
  pluginConfig:
    PodNodeConstraints:
      configuration:
        apiVersion: v1
        kind: PodNodeConstraintsConfig
        nodeSelectorLabelBlacklist:
          - label1
          - label2
...
kubernetesMasterConfig:
  admissionConfig:
    pluginConfig:
      PodNodeConstraints:
        configuration:
          apiVersion: v1
          kind: PodNodeConstraintsConfig
          nodeSelectorLabelBlacklist:
            - label1
            - label2
*/

package podnodeconstraints
