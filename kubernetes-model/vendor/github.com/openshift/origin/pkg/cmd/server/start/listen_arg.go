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
package start

import (
	"github.com/spf13/pflag"

	"github.com/openshift/origin/pkg/cmd/flagtypes"
)

// ListenArg is a struct that the command stores flag values into.
type ListenArg struct {
	// ListenAddr is the address to listen for connections on (scheme://host:port).
	ListenAddr flagtypes.Addr
}

// BindListenArg binds values to the given arguments by using flags
func BindListenArg(args *ListenArg, flags *pflag.FlagSet, prefix string) {
	flags.Var(&args.ListenAddr, prefix+"listen", "The address to listen for connections on (scheme://host:port).")
}

// NewDefaultListenArg returns a new address to listen for connections
func NewDefaultListenArg() *ListenArg {
	config := &ListenArg{
		ListenAddr: flagtypes.Addr{Value: "0.0.0.0:8443", DefaultScheme: "https", DefaultPort: 8443, AllowPrefix: true}.Default(),
	}

	return config
}

// UseTLS checks whether the address we listen for connections uses TLS or not
func (l *ListenArg) UseTLS() bool {
	return l.ListenAddr.URL.Scheme == "https"
}
