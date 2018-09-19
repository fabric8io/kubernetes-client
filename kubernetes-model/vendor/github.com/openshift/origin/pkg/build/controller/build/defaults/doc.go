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
Package defaults contains the BuildDefaults admission control plugin.

The plugin allows setting default values for build setings like the git HTTP
and HTTPS proxy URLs and additional environment variables for the build
strategy

Configuration

Configuration is done via a BuildDefaultsConfig object:

 apiVersion: v1
 kind: BuildDefaultsConfiguration
 gitHTTPProxy: http://my.proxy.server:12345
 gitHTTPSProxy: https://my.proxy.server:7890
 env:
 - name: ENV_VAR1
   value: VALUE1
 - name: ENV_VAR2
   value: VALUE2
*/
package defaults
