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
package clusterresourceoverride

// The ClusterResourceOverride plugin is only active when admission control config is supplied for it.
// The plugin allows administrators to override user-provided container request/limit values
// in order to control overcommit and optionally pin CPU to memory.
// The plugin's actions can be disabled per-project with the project annotation
// quota.openshift.io/cluster-resource-override-enabled="false", so cluster admins
// can exempt infrastructure projects and such from the overrides.
