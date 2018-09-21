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

OpenShift v3 Diagnostics

This is a tool to help administrators and users resolve common problems
that occur with OpenShift v3 deployments. It will likely remain
under continuous development as the OpenShift Origin project progresses.

The goals of the diagnostics tool are summarized in the Trello card
https://trello.com/c/LdUogKuN; Diagnostics are included as an `openshift`
sub-command that analyzes OpenShift as it is able, whether from the
perspective of an OpenShift client or on an OpenShift host.

View pkg/diagnostics/README.md for more details on developing
diagnostics.

*/
package diagnostics
