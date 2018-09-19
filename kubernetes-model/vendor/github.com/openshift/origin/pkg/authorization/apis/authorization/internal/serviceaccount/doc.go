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
// serviceaccount is copied from k8s.io/kubernetes/pkg/serviceaccount to avoid an API dependency on k8s.io/kubernetes
// outside of the api types we rely upon.
// The contents of the package can't change without breaking lots of authentication and authorization.
// Using an internal package prevents leaks.
// Do not add more things here or modify values.
package serviceaccount
