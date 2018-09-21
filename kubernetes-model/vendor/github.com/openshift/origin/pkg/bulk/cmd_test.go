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
package bulk

import (
	"bytes"
	"fmt"
	"reflect"
	"testing"

	"k8s.io/apimachinery/pkg/api/meta"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/runtime/schema"
	kapi "k8s.io/kubernetes/pkg/apis/core"
	"k8s.io/kubernetes/pkg/kubectl/resource"
)

type bulkTester struct {
	meta.RESTMapper

	mapping *meta.RESTMapping
	err     error
	opErr   error

	infos    []runtime.Object
	recorded []runtime.Object
}

func (bt *bulkTester) ResourceSingularizer(resource string) (string, error) {
	return resource, nil
}

func (bt *bulkTester) InfoForObject(obj runtime.Object, preferredGVKs []schema.GroupVersionKind) (*resource.Info, error) {
	bt.infos = append(bt.infos, obj)
	// These checks are here to make sure the preferredGVKs are set to retain the legacy
	// behavior for bulk operations.
	if len(preferredGVKs) == 0 {
		return nil, fmt.Errorf("expected preferred gvk to not be empty")
	}
	if preferredGVKs[0].Group != "" {
		return nil, fmt.Errorf("expected preferred gvk to be set to prefer the legacy group")
	}
	return &resource.Info{Object: obj, Mapping: bt.mapping}, bt.err
}

func (bt *bulkTester) Record(info *resource.Info, namespace string, obj runtime.Object) (runtime.Object, error) {
	bt.recorded = append(bt.recorded, obj)
	return obj, bt.opErr
}

func TestBulk(t *testing.T) {
	bt := &bulkTester{
		mapping: &meta.RESTMapping{
			MetadataAccessor: meta.NewAccessor(),
		},
	}
	b := Bulk{Mapper: bt, Op: bt.Record}

	in := &kapi.Pod{}
	if errs := b.Run(&kapi.List{Items: []runtime.Object{in}}, "test_namespace"); len(errs) > 0 {
		t.Fatal(errs)
	}
	if !reflect.DeepEqual(bt.infos, []runtime.Object{in}) {
		t.Fatalf("unexpected: %#v", bt.infos)
	}
	if !reflect.DeepEqual(bt.recorded, []runtime.Object{in}) {
		t.Fatalf("unexpected: %#v", bt.recorded)
	}
}

func TestBulkInfoError(t *testing.T) {
	bt := &bulkTester{
		mapping: &meta.RESTMapping{
			MetadataAccessor: meta.NewAccessor(),
		},
		err: fmt.Errorf("error1"),
	}
	b := Bulk{Mapper: bt, Op: bt.Record}

	in := &kapi.Pod{}
	if errs := b.Run(&kapi.List{Items: []runtime.Object{in}}, "test_namespace"); len(errs) != 1 || errs[0] != bt.err {
		t.Fatal(errs)
	}
	if !reflect.DeepEqual(bt.infos, []runtime.Object{in}) {
		t.Fatalf("unexpected: %#v", bt.infos)
	}
	if !reflect.DeepEqual(bt.recorded, []runtime.Object(nil)) {
		t.Fatalf("unexpected: %#v", bt.recorded)
	}
}

func TestBulkOpError(t *testing.T) {
	bt := &bulkTester{
		mapping: &meta.RESTMapping{
			MetadataAccessor: meta.NewAccessor(),
		},
		opErr: fmt.Errorf("error1"),
	}
	b := Bulk{Mapper: bt, Op: bt.Record}

	in := &kapi.Pod{}
	if errs := b.Run(&kapi.List{Items: []runtime.Object{in}}, "test_namespace"); len(errs) != 1 || errs[0] != bt.opErr {
		t.Fatal(errs)
	}
	if !reflect.DeepEqual(bt.infos, []runtime.Object{in}) {
		t.Fatalf("unexpected: %#v", bt.infos)
	}
	if !reflect.DeepEqual(bt.recorded, []runtime.Object{in}) {
		t.Fatalf("unexpected: %#v", bt.recorded)
	}
}

func TestBulkAction(t *testing.T) {
	bt := &bulkTester{
		mapping: &meta.RESTMapping{
			MetadataAccessor: meta.NewAccessor(),
		},
	}
	out, err := &bytes.Buffer{}, &bytes.Buffer{}
	bulk := Bulk{Mapper: bt, Op: bt.Record}
	b := &BulkAction{Bulk: bulk, Output: "", Out: out, ErrOut: err}
	b2 := b.WithMessage("test1", "test2")

	in := &kapi.Pod{ObjectMeta: metav1.ObjectMeta{Name: "obj1"}}
	if errs := b2.Run(&kapi.List{Items: []runtime.Object{in}}, "test_namespace"); len(errs) != 0 {
		t.Fatal(errs)
	}
	if !reflect.DeepEqual(bt.infos, []runtime.Object{in}) {
		t.Fatalf("unexpected: %#v", bt.infos)
	}
	if !reflect.DeepEqual(bt.recorded, []runtime.Object{in}) {
		t.Fatalf("unexpected: %#v", bt.recorded)
	}
	if out.String() != `--> test1 ...
    "obj1" test2
--> Success
` {
		t.Fatalf("unexpected: %s", out.String())
	}
	if err.String() != `` {
		t.Fatalf("unexpected: %s", err.String())
	}
}

func TestBulkActionCompact(t *testing.T) {
	bt := &bulkTester{
		mapping: &meta.RESTMapping{
			MetadataAccessor: meta.NewAccessor(),
		},
	}
	out, err := &bytes.Buffer{}, &bytes.Buffer{}
	bulk := Bulk{Mapper: bt, Op: bt.Record}
	b := &BulkAction{Bulk: bulk, Output: "", Out: out, ErrOut: err}
	b.Compact()
	b2 := b.WithMessage("test1", "test2")

	in := &kapi.Pod{ObjectMeta: metav1.ObjectMeta{Name: "obj1"}}
	if errs := b2.Run(&kapi.List{Items: []runtime.Object{in}}, "test_namespace"); len(errs) != 0 {
		t.Fatal(errs)
	}
	if !reflect.DeepEqual(bt.infos, []runtime.Object{in}) {
		t.Fatalf("unexpected: %#v", bt.infos)
	}
	if !reflect.DeepEqual(bt.recorded, []runtime.Object{in}) {
		t.Fatalf("unexpected: %#v", bt.recorded)
	}
	if out.String() != `` {
		t.Fatalf("unexpected: %s", out.String())
	}
	if err.String() != `` {
		t.Fatalf("unexpected: %s", err.String())
	}
}
