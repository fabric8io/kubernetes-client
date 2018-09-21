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
package imagestreamimport

import (
	"testing"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/runtime"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	"k8s.io/apiserver/pkg/registry/rest"
	kapi "k8s.io/kubernetes/pkg/apis/core"
	kapihelper "k8s.io/kubernetes/pkg/apis/core/helper"

	imageapi "github.com/openshift/origin/pkg/image/apis/image"
)

type fakeImageCreater struct{}

func (_ fakeImageCreater) New() runtime.Object {
	return nil
}

func (_ fakeImageCreater) Create(ctx apirequest.Context, obj runtime.Object, _ rest.ValidateObjectFunc, _ bool) (runtime.Object, error) {
	return obj, nil
}

func TestImportSuccessful(t *testing.T) {
	one := int64(1)
	two := int64(2)
	now := metav1.Now()
	tests := map[string]struct {
		image    *imageapi.Image
		stream   *imageapi.ImageStream
		expected imageapi.TagEvent
	}{
		"reference differs": {
			image: &imageapi.Image{
				ObjectMeta: metav1.ObjectMeta{
					Name: "image",
				},
				DockerImageReference: "registry.com/namespace/image:mytag",
			},
			stream: &imageapi.ImageStream{
				Spec: imageapi.ImageStreamSpec{
					Tags: map[string]imageapi.TagReference{
						"mytag": {
							Name: "mytag",
							From: &kapi.ObjectReference{
								Kind: "DockerImage",
								Name: "registry.com/namespace/image:mytag",
							},
							Generation: &one,
						},
					},
				},
				Status: imageapi.ImageStreamStatus{
					Tags: map[string]imageapi.TagEventList{
						"mytag": {
							Items: []imageapi.TagEvent{{
								DockerImageReference: "registry.com/namespace/image:othertag",
								Image:                "image",
								Generation:           one,
							}},
						},
					},
				},
			},
			expected: imageapi.TagEvent{
				DockerImageReference: "registry.com/namespace/image:mytag",
				Image:                "image",
				Generation:           two,
			},
		},
		"image differs": {
			image: &imageapi.Image{
				ObjectMeta: metav1.ObjectMeta{
					Name: "image",
				},
				DockerImageReference: "registry.com/namespace/image:mytag",
			},
			stream: &imageapi.ImageStream{
				Spec: imageapi.ImageStreamSpec{
					Tags: map[string]imageapi.TagReference{
						"mytag": {
							Name: "mytag",
							From: &kapi.ObjectReference{
								Kind: "DockerImage",
								Name: "registry.com/namespace/image:mytag",
							},
							Generation: &one,
						},
					},
				},
				Status: imageapi.ImageStreamStatus{
					Tags: map[string]imageapi.TagEventList{
						"mytag": {
							Items: []imageapi.TagEvent{{
								DockerImageReference: "registry.com/namespace/image:othertag",
								Image:                "non-image",
								Generation:           one,
							}},
						},
					},
				},
			},
			expected: imageapi.TagEvent{
				Created:              now,
				DockerImageReference: "registry.com/namespace/image:mytag",
				Image:                "image",
				Generation:           two,
			},
		},
		"empty status": {
			image: &imageapi.Image{
				ObjectMeta: metav1.ObjectMeta{
					Name: "image",
				},
				DockerImageReference: "registry.com/namespace/image:mytag",
			},
			stream: &imageapi.ImageStream{
				Spec: imageapi.ImageStreamSpec{
					Tags: map[string]imageapi.TagReference{
						"mytag": {
							Name: "mytag",
							From: &kapi.ObjectReference{
								Kind: "DockerImage",
								Name: "registry.com/namespace/image:mytag",
							},
							Generation: &one,
						},
					},
				},
				Status: imageapi.ImageStreamStatus{},
			},
			expected: imageapi.TagEvent{
				Created:              now,
				DockerImageReference: "registry.com/namespace/image:mytag",
				Image:                "image",
				Generation:           two,
			},
		},
		// https://github.com/openshift/origin/issues/10402:
		"only generation differ": {
			image: &imageapi.Image{
				ObjectMeta: metav1.ObjectMeta{
					Name: "image",
				},
				DockerImageReference: "registry.com/namespace/image:mytag",
			},
			stream: &imageapi.ImageStream{
				Spec: imageapi.ImageStreamSpec{
					Tags: map[string]imageapi.TagReference{
						"mytag": {
							Name: "mytag",
							From: &kapi.ObjectReference{
								Kind: "DockerImage",
								Name: "registry.com/namespace/image:mytag",
							},
							Generation: &two,
						},
					},
				},
				Status: imageapi.ImageStreamStatus{
					Tags: map[string]imageapi.TagEventList{
						"mytag": {
							Items: []imageapi.TagEvent{{
								DockerImageReference: "registry.com/namespace/image:mytag",
								Image:                "image",
								Generation:           one,
							}},
						},
					},
				},
			},
			expected: imageapi.TagEvent{
				DockerImageReference: "registry.com/namespace/image:mytag",
				Image:                "image",
				Generation:           two,
			},
		},
	}

	for name, test := range tests {
		ref, err := imageapi.ParseDockerImageReference(test.image.DockerImageReference)
		if err != nil {
			t.Errorf("%s: error parsing image ref: %v", name, err)
			continue
		}

		importPolicy := imageapi.TagImportPolicy{}
		referencePolicy := imageapi.TagReferencePolicy{Type: imageapi.SourceTagReferencePolicy}
		importedImages := make(map[string]error)
		updatedImages := make(map[string]*imageapi.Image)
		storage := REST{images: fakeImageCreater{}}
		_, ok := storage.importSuccessful(apirequest.NewDefaultContext(), test.image, test.stream,
			ref.Tag, ref.Exact(), two, now, importPolicy, referencePolicy, importedImages, updatedImages)
		if !ok {
			t.Errorf("%s: expected success, didn't get one", name)
		}
		actual := test.stream.Status.Tags[ref.Tag].Items[0]
		if !kapihelper.Semantic.DeepEqual(actual, test.expected) {
			t.Errorf("%s: expected %#v, got %#v", name, test.expected, actual)
		}
	}
}
