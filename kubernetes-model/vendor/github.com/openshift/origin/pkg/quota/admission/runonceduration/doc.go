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
Package runonceduration contains the RunOnceDuration admission control plugin.
The plugin allows overriding the ActiveDeadlineSeconds for pods that have a
RestartPolicy of RestartPolicyNever (run once). If configured to allow a project
annotation override, and an annotation exists in the pod's namespace of:

 openshift.io/active-deadline-seconds-override

the value of the annotation will take precedence over the globally configured
value in the plugin's configuration.


Configuration

The plugin is configured via a RunOnceDurationConfig object:

 apiVersion: v1
 kind: RunOnceDurationConfig
 enabled: true
 activeDeadlineSecondsOverride: 3600
*/
package runonceduration
