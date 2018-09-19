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
package notifications

import (
	"encoding/json"
	"expvar"
	"testing"
)

func TestMetricsExpvar(t *testing.T) {
	endpointsVar := expvar.Get("registry").(*expvar.Map).Get("notifications").(*expvar.Map).Get("endpoints")

	var v interface{}
	if err := json.Unmarshal([]byte(endpointsVar.String()), &v); err != nil {
		t.Fatalf("unexpected error unmarshaling endpoints: %v", err)
	}
	if v != nil {
		t.Fatalf("expected nil, got %#v", v)
	}

	NewEndpoint("x", "y", EndpointConfig{})

	if err := json.Unmarshal([]byte(endpointsVar.String()), &v); err != nil {
		t.Fatalf("unexpected error unmarshaling endpoints: %v", err)
	}
	if slice, ok := v.([]interface{}); !ok || len(slice) != 1 {
		t.Logf("expected one-element []interface{}, got %#v", v)
	}
}
