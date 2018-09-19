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
package netid

import (
	"fmt"

	"github.com/openshift/origin/pkg/network"
)

type NetIDRange struct {
	Base uint32
	Size uint32
}

// Contains tests whether a given netid falls within the Range.
func (r *NetIDRange) Contains(netid uint32) (bool, uint32) {
	if (netid >= r.Base) && ((netid - r.Base) < r.Size) {
		offset := netid - r.Base
		return true, offset
	}
	return false, 0
}

func (r *NetIDRange) String() string {
	if r.Size == 0 {
		return ""
	}
	return fmt.Sprintf("%d-%d", r.Base, r.Base+r.Size-1)
}

func (r *NetIDRange) Set(base, size uint32) error {
	if base < network.MinVNID {
		return fmt.Errorf("invalid netid base, must be greater than %d", network.MinVNID)
	}
	if size == 0 {
		return fmt.Errorf("invalid netid size, must be greater than zero")
	}
	if (base + size - 1) > network.MaxVNID {
		return fmt.Errorf("netid range exceeded max value %d", network.MaxVNID)
	}

	r.Base = base
	r.Size = size
	return nil
}

func NewNetIDRange(min, max uint32) (*NetIDRange, error) {
	r := &NetIDRange{}
	err := r.Set(min, max-min+1)
	if err != nil {
		return nil, err
	}
	return r, nil
}
