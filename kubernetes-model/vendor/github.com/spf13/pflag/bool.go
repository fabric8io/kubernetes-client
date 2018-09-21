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
package pflag

import "strconv"

// optional interface to indicate boolean flags that can be
// supplied without "=value" text
type boolFlag interface {
	Value
	IsBoolFlag() bool
}

// -- bool Value
type boolValue bool

func newBoolValue(val bool, p *bool) *boolValue {
	*p = val
	return (*boolValue)(p)
}

func (b *boolValue) Set(s string) error {
	v, err := strconv.ParseBool(s)
	*b = boolValue(v)
	return err
}

func (b *boolValue) Type() string {
	return "bool"
}

func (b *boolValue) String() string { return strconv.FormatBool(bool(*b)) }

func (b *boolValue) IsBoolFlag() bool { return true }

func boolConv(sval string) (interface{}, error) {
	return strconv.ParseBool(sval)
}

// GetBool return the bool value of a flag with the given name
func (f *FlagSet) GetBool(name string) (bool, error) {
	val, err := f.getFlagType(name, "bool", boolConv)
	if err != nil {
		return false, err
	}
	return val.(bool), nil
}

// BoolVar defines a bool flag with specified name, default value, and usage string.
// The argument p points to a bool variable in which to store the value of the flag.
func (f *FlagSet) BoolVar(p *bool, name string, value bool, usage string) {
	f.BoolVarP(p, name, "", value, usage)
}

// BoolVarP is like BoolVar, but accepts a shorthand letter that can be used after a single dash.
func (f *FlagSet) BoolVarP(p *bool, name, shorthand string, value bool, usage string) {
	flag := f.VarPF(newBoolValue(value, p), name, shorthand, usage)
	flag.NoOptDefVal = "true"
}

// BoolVar defines a bool flag with specified name, default value, and usage string.
// The argument p points to a bool variable in which to store the value of the flag.
func BoolVar(p *bool, name string, value bool, usage string) {
	BoolVarP(p, name, "", value, usage)
}

// BoolVarP is like BoolVar, but accepts a shorthand letter that can be used after a single dash.
func BoolVarP(p *bool, name, shorthand string, value bool, usage string) {
	flag := CommandLine.VarPF(newBoolValue(value, p), name, shorthand, usage)
	flag.NoOptDefVal = "true"
}

// Bool defines a bool flag with specified name, default value, and usage string.
// The return value is the address of a bool variable that stores the value of the flag.
func (f *FlagSet) Bool(name string, value bool, usage string) *bool {
	return f.BoolP(name, "", value, usage)
}

// BoolP is like Bool, but accepts a shorthand letter that can be used after a single dash.
func (f *FlagSet) BoolP(name, shorthand string, value bool, usage string) *bool {
	p := new(bool)
	f.BoolVarP(p, name, shorthand, value, usage)
	return p
}

// Bool defines a bool flag with specified name, default value, and usage string.
// The return value is the address of a bool variable that stores the value of the flag.
func Bool(name string, value bool, usage string) *bool {
	return BoolP(name, "", value, usage)
}

// BoolP is like Bool, but accepts a shorthand letter that can be used after a single dash.
func BoolP(name, shorthand string, value bool, usage string) *bool {
	b := CommandLine.BoolP(name, shorthand, value, usage)
	return b
}
