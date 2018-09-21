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
package extensions

import (
	"encoding/asn1"
)

// oid is a helper function for concatenating OIDs
func oid(o asn1.ObjectIdentifier, extra ...int) asn1.ObjectIdentifier {
	return asn1.ObjectIdentifier(append(append([]int{}, o...), extra...))
}

var (
	// RedHatOID is the IANA assigned ObjectIdentifier for Red Hat Inc.
	RedHatOID = asn1.ObjectIdentifier{1, 3, 6, 1, 4, 1, 2312}
	// OpenShiftOID is the Red Hat assigned OID arc for OpenShift.
	OpenShiftOID = oid(RedHatOID, 17)
)
