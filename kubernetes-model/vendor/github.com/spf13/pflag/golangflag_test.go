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
// Copyright 2009 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package pflag

import (
	goflag "flag"
	"testing"
)

func TestGoflags(t *testing.T) {
	goflag.String("stringFlag", "stringFlag", "stringFlag")
	goflag.Bool("boolFlag", false, "boolFlag")

	f := NewFlagSet("test", ContinueOnError)

	f.AddGoFlagSet(goflag.CommandLine)
	err := f.Parse([]string{"--stringFlag=bob", "--boolFlag"})
	if err != nil {
		t.Fatal("expected no error; get", err)
	}

	getString, err := f.GetString("stringFlag")
	if err != nil {
		t.Fatal("expected no error; get", err)
	}
	if getString != "bob" {
		t.Fatalf("expected getString=bob but got getString=%s", getString)
	}

	getBool, err := f.GetBool("boolFlag")
	if err != nil {
		t.Fatal("expected no error; get", err)
	}
	if getBool != true {
		t.Fatalf("expected getBool=true but got getBool=%v", getBool)
	}
}
