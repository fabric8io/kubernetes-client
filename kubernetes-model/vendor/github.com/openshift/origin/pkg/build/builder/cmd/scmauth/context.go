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
package scmauth

import (
	"fmt"
	"net/url"
)

type defaultSCMContext struct {
	vars        map[string]string
	overrideURL *url.URL
}

func NewDefaultSCMContext() *defaultSCMContext {
	return &defaultSCMContext{
		vars: make(map[string]string),
	}
}

func (c *defaultSCMContext) Get(name string) (string, bool) {
	value, ok := c.vars[name]
	return value, ok
}

// Set will set the value of a variable. If a variable has already been set
// and the value sent is different, then an error will be returned.
func (c *defaultSCMContext) Set(name, value string) error {
	if oldValue, isSet := c.Get(name); isSet && value != oldValue {
		return fmt.Errorf("cannot set the value of variable %s with value %q. Existing value: %q", name, value, oldValue)
	}
	c.vars[name] = value
	return nil
}

// SetOverrideURL will set an override URL. If a value has already been set
// and the URL passed is different, then an error will be returned.
func (c *defaultSCMContext) SetOverrideURL(u *url.URL) error {
	if c.overrideURL != nil && c.overrideURL.String() != u.String() {
		return fmt.Errorf("cannot set the value of overrideURL with value %s. Existing value: %s", c.overrideURL.String(), u.String())
	}
	c.overrideURL = u
	return nil
}

// OverrideURL returns an override URL if one is set
func (c *defaultSCMContext) OverrideURL() *url.URL {
	return c.overrideURL
}

// Env returns a string slice with variables set on this context
func (c *defaultSCMContext) Env() []string {
	env := []string{}
	for k, v := range c.vars {
		env = append(env, fmt.Sprintf("%s=%s", k, v))
	}
	return env
}
