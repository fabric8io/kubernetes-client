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
package origin

import (
	"strings"
	"testing"

	"k8s.io/kubernetes/pkg/api/legacyscheme"

	"github.com/openshift/origin/pkg/api/latest"
)

func TestLegacyKinds(t *testing.T) {
	for gvk := range legacyscheme.Scheme.AllKnownTypes() {
		if latest.OriginLegacyKind(gvk) && !OriginLegacyKinds.Has(gvk.Kind) &&
			!strings.HasPrefix(gvk.Kind, "SecurityContextConstraint") /* SCC is a special case that's allowed */ {
			t.Errorf("%s should not be registered into legacy Origin API", gvk.Kind)
		}
	}
}
