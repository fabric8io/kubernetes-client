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
package goautoneg

import (
	"testing"
)

var chrome = "application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5"

func TestParseAccept(t *testing.T) {
	alternatives := []string{"text/html", "image/png"}
	content_type := Negotiate(chrome, alternatives)
	if content_type != "image/png" {
		t.Errorf("got %s expected image/png", content_type)
	}

	alternatives = []string{"text/html", "text/plain", "text/n3"}
	content_type = Negotiate(chrome, alternatives)
	if content_type != "text/html" {
		t.Errorf("got %s expected text/html", content_type)
	}

	alternatives = []string{"text/n3", "text/plain"}
	content_type = Negotiate(chrome, alternatives)
	if content_type != "text/plain" {
		t.Errorf("got %s expected text/plain", content_type)
	}

	alternatives = []string{"text/n3", "application/rdf+xml"}
	content_type = Negotiate(chrome, alternatives)
	if content_type != "text/n3" {
		t.Errorf("got %s expected text/n3", content_type)
	}
}
