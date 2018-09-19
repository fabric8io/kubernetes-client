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
package ldapclient

import "gopkg.in/ldap.v2"

// Config knows how to connect to an LDAP server and can describe which server it is connecting to
type Config interface {
	Connect() (client ldap.Client, err error)
	GetBindCredentials() (bindDN, bindPassword string)
	Host() string
}
