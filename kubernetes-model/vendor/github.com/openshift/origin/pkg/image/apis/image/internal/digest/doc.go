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
// digest is a copy from "github.com/docker/distribution/digest" that is kept because we want to avoid the godep,
// this package has no non-standard dependencies, and if it changes lots of other docker registry stuff breaks.
// Don't try this at home!
// Changes here require sign-off from openshift/api-reviewers and they will be rejected.
package digest
