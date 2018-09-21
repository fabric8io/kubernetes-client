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
package v1

import (
	"reflect"
	"testing"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/runtime/serializer"
	"k8s.io/apimachinery/pkg/util/diff"
	kapi "k8s.io/kubernetes/pkg/apis/core"

	"github.com/openshift/api/image/docker10"
	"github.com/openshift/api/image/dockerpre012"
	"github.com/openshift/origin/pkg/api/apihelpers/apitesting"
	newer "github.com/openshift/origin/pkg/image/apis/image"
)

func TestRoundTripVersionedObject(t *testing.T) {
	scheme := runtime.NewScheme()
	docker10.AddToSchemeInCoreGroup(scheme)
	dockerpre012.AddToSchemeInCoreGroup(scheme)
	newer.AddToSchemeInCoreGroup(scheme)
	docker10.AddToScheme(scheme)
	dockerpre012.AddToScheme(scheme)
	AddToSchemeInCoreGroup(scheme)
	newer.AddToScheme(scheme)
	AddToScheme(scheme)
	codecs := serializer.NewCodecFactory(scheme)

	d := &newer.DockerImage{
		Config: &newer.DockerConfig{
			Env: []string{"A=1", "B=2"},
		},
	}
	i := &newer.Image{
		ObjectMeta: metav1.ObjectMeta{Name: "foo"},

		DockerImageLayers:    []newer.ImageLayer{{Name: "foo", LayerSize: 10}},
		DockerImageMetadata:  *d,
		DockerImageReference: "foo/bar/baz",
	}

	data, err := runtime.Encode(codecs.LegacyCodec(SchemeGroupVersion), i)
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}

	obj, err := runtime.Decode(codecs.UniversalDecoder(), data)
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	image := obj.(*newer.Image)
	if image.DockerImageMetadataVersion != "1.0" {
		t.Errorf("did not default to correct metadata version: %#v", image)
	}
	image.DockerImageMetadataVersion = ""
	if !reflect.DeepEqual(i, image) {
		t.Errorf("unable to round trip object: %s", diff.ObjectDiff(i, image))
	}
}

func TestFieldSelectors(t *testing.T) {
	apitesting.FieldKeyCheck{
		SchemeBuilder: []func(*runtime.Scheme) error{LegacySchemeBuilder.AddToScheme, newer.LegacySchemeBuilder.AddToScheme},
		Kind:          LegacySchemeGroupVersion.WithKind("ImageStream"),
		// Ensure previously supported labels have conversions. DO NOT REMOVE THINGS FROM THIS LIST
		AllowedExternalFieldKeys: []string{"name", "spec.dockerImageRepository", "status.dockerImageRepository"},
		FieldKeyEvaluatorFn:      newer.ImageStreamSelector,
	}.Check(t)

	apitesting.FieldKeyCheck{
		SchemeBuilder: []func(*runtime.Scheme) error{SchemeBuilder.AddToScheme, newer.SchemeBuilder.AddToScheme},
		Kind:          SchemeGroupVersion.WithKind("ImageStream"),
		// Ensure previously supported labels have conversions. DO NOT REMOVE THINGS FROM THIS LIST
		AllowedExternalFieldKeys: []string{"spec.dockerImageRepository", "status.dockerImageRepository"},
		FieldKeyEvaluatorFn:      newer.ImageStreamSelector,
	}.Check(t)
}

func TestImageImportSpecDefaulting(t *testing.T) {
	scheme := runtime.NewScheme()
	codecs := serializer.NewCodecFactory(scheme)
	LegacySchemeBuilder.AddToScheme(scheme)
	SchemeBuilder.AddToScheme(scheme)
	newer.LegacySchemeBuilder.AddToScheme(scheme)
	newer.SchemeBuilder.AddToScheme(scheme)

	i := &newer.ImageStreamImport{
		Spec: newer.ImageStreamImportSpec{
			Images: []newer.ImageImportSpec{
				{From: kapi.ObjectReference{Name: "something:other"}},
			},
		},
	}
	data, err := runtime.Encode(codecs.LegacyCodec(SchemeGroupVersion), i)
	if err != nil {
		t.Fatal(err)
	}
	obj, err := runtime.Decode(codecs.UniversalDecoder(), data)
	if err != nil {
		t.Fatal(err)
	}
	isi := obj.(*newer.ImageStreamImport)
	if isi.Spec.Images[0].To == nil || isi.Spec.Images[0].To.Name != "other" {
		t.Errorf("unexpected round trip: %#v", isi)
	}
}
