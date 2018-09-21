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
package registry

import (
	"reflect"
	"testing"

	"github.com/docker/distribution/configuration"
)

// Tests to ensure nextProtos returns the correct protocols when:
// * config.HTTP.HTTP2.Disabled is not explicitly set => [h2 http/1.1]
// * config.HTTP.HTTP2.Disabled is explicitly set to false [h2 http/1.1]
// * config.HTTP.HTTP2.Disabled is explicitly set to true [http/1.1]
func TestNextProtos(t *testing.T) {
	config := &configuration.Configuration{}
	protos := nextProtos(config)
	if !reflect.DeepEqual(protos, []string{"h2", "http/1.1"}) {
		t.Fatalf("expected protos to equal [h2 http/1.1], got %s", protos)
	}
	config.HTTP.HTTP2.Disabled = false
	protos = nextProtos(config)
	if !reflect.DeepEqual(protos, []string{"h2", "http/1.1"}) {
		t.Fatalf("expected protos to equal [h2 http/1.1], got %s", protos)
	}
	config.HTTP.HTTP2.Disabled = true
	protos = nextProtos(config)
	if !reflect.DeepEqual(protos, []string{"http/1.1"}) {
		t.Fatalf("expected protos to equal [http/1.1], got %s", protos)
	}
}
