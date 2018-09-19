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
package top

import (
	"testing"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	kapihelper "k8s.io/kubernetes/pkg/apis/core/helper"

	imageapi "github.com/openshift/origin/pkg/image/apis/image"
)

func TestImageStreamsTop(t *testing.T) {
	testCases := map[string]struct {
		images   *imageapi.ImageList
		streams  *imageapi.ImageStreamList
		expected []Info
	}{
		"empty image stream": {
			images: &imageapi.ImageList{},
			streams: &imageapi.ImageStreamList{
				Items: []imageapi.ImageStream{
					{
						ObjectMeta: metav1.ObjectMeta{Name: "stream1", Namespace: "ns1"},
						Status: imageapi.ImageStreamStatus{
							Tags: map[string]imageapi.TagEventList{
								"tag1": {
									Items: []imageapi.TagEvent{{Image: "image1"}},
								},
							},
						},
					},
				},
			},
			expected: []Info{
				imageStreamInfo{
					ImageStream: "ns1/stream1",
					Images:      0,
					Layers:      0,
				},
			},
		},
		"no storage": {
			images: &imageapi.ImageList{
				Items: []imageapi.Image{
					{
						ObjectMeta:        metav1.ObjectMeta{Name: "image1"},
						DockerImageLayers: []imageapi.ImageLayer{{Name: "layer1"}},
					},
				},
			},
			streams: &imageapi.ImageStreamList{
				Items: []imageapi.ImageStream{
					{
						ObjectMeta: metav1.ObjectMeta{Name: "stream1", Namespace: "ns1"},
						Status: imageapi.ImageStreamStatus{
							Tags: map[string]imageapi.TagEventList{
								"tag1": {
									Items: []imageapi.TagEvent{{Image: "image1"}},
								},
							},
						},
					},
				},
			},
			expected: []Info{
				imageStreamInfo{
					ImageStream: "ns1/stream1",
					Images:      1,
					Layers:      1,
				},
			},
		},
		"with storage": {
			images: &imageapi.ImageList{
				Items: []imageapi.Image{
					{
						ObjectMeta:        metav1.ObjectMeta{Name: "image1"},
						DockerImageLayers: []imageapi.ImageLayer{{Name: "layer1", LayerSize: int64(1024)}},
					},
				},
			},
			streams: &imageapi.ImageStreamList{
				Items: []imageapi.ImageStream{
					{
						ObjectMeta: metav1.ObjectMeta{Name: "stream1", Namespace: "ns1"},
						Status: imageapi.ImageStreamStatus{
							Tags: map[string]imageapi.TagEventList{
								"tag1": {
									Items: []imageapi.TagEvent{{Image: "image1"}},
								},
							},
						},
					},
				},
			},
			expected: []Info{
				imageStreamInfo{
					ImageStream: "ns1/stream1",
					Storage:     int64(1024),
					Images:      1,
					Layers:      1,
				},
			},
		},
		"multiple layers": {
			images: &imageapi.ImageList{
				Items: []imageapi.Image{
					{
						ObjectMeta: metav1.ObjectMeta{Name: "image1"},
						DockerImageLayers: []imageapi.ImageLayer{
							{Name: "layer1", LayerSize: 1024},
							{Name: "layer2", LayerSize: 512},
						},
					},
				},
			},
			streams: &imageapi.ImageStreamList{
				Items: []imageapi.ImageStream{
					{
						ObjectMeta: metav1.ObjectMeta{Name: "stream1", Namespace: "ns1"},
						Status: imageapi.ImageStreamStatus{
							Tags: map[string]imageapi.TagEventList{
								"tag1": {
									Items: []imageapi.TagEvent{{Image: "image1"}},
								},
							},
						},
					},
				},
			},
			expected: []Info{
				imageStreamInfo{
					ImageStream: "ns1/stream1",
					Storage:     int64(1536),
					Images:      1,
					Layers:      2,
				},
			},
		},
		"multiple images": {
			images: &imageapi.ImageList{
				Items: []imageapi.Image{
					{
						ObjectMeta:        metav1.ObjectMeta{Name: "image1"},
						DockerImageLayers: []imageapi.ImageLayer{{Name: "layer1", LayerSize: int64(1024)}},
					},
					{
						ObjectMeta: metav1.ObjectMeta{Name: "image2"},
						DockerImageLayers: []imageapi.ImageLayer{
							{Name: "layer1", LayerSize: int64(1024)},
							{Name: "layer2", LayerSize: int64(128)},
						},
					},
				},
			},
			streams: &imageapi.ImageStreamList{
				Items: []imageapi.ImageStream{
					{
						ObjectMeta: metav1.ObjectMeta{Name: "stream1", Namespace: "ns1"},
						Status: imageapi.ImageStreamStatus{
							Tags: map[string]imageapi.TagEventList{
								"tag1": {
									Items: []imageapi.TagEvent{{Image: "image1"}},
								},
								"tag2": {
									Items: []imageapi.TagEvent{{Image: "image2"}},
								},
							},
						},
					},
				},
			},
			expected: []Info{
				imageStreamInfo{
					ImageStream: "ns1/stream1",
					Storage:     int64(1152),
					Images:      2,
					Layers:      3,
				},
			},
		},
		"multiple images with manifest config": {
			images: &imageapi.ImageList{
				Items: []imageapi.Image{
					{
						ObjectMeta:        metav1.ObjectMeta{Name: "image1"},
						DockerImageLayers: []imageapi.ImageLayer{{Name: "layer1", LayerSize: int64(1024)}},
						DockerImageConfig: "raw image config",
						DockerImageMetadata: imageapi.DockerImage{
							ID: "manifestConfigID",
						},
					},
					{
						ObjectMeta: metav1.ObjectMeta{Name: "image2"},
						DockerImageLayers: []imageapi.ImageLayer{
							{Name: "layer1", LayerSize: int64(1024)},
							{Name: "layer2", LayerSize: int64(128)},
						},
						DockerImageConfig: "raw image config",
						DockerImageMetadata: imageapi.DockerImage{
							ID: "manifestConfigID",
						},
					},
				},
			},
			streams: &imageapi.ImageStreamList{
				Items: []imageapi.ImageStream{
					{
						ObjectMeta: metav1.ObjectMeta{Name: "stream1", Namespace: "ns1"},
						Status: imageapi.ImageStreamStatus{
							Tags: map[string]imageapi.TagEventList{
								"tag1": {
									Items: []imageapi.TagEvent{{Image: "image1"}},
								},
								"tag2": {
									Items: []imageapi.TagEvent{{Image: "image2"}},
								},
							},
						},
					},
				},
			},
			expected: []Info{
				imageStreamInfo{
					ImageStream: "ns1/stream1",
					Storage:     int64(1152 + len("raw image config")),
					Images:      2,
					Layers:      3,
				},
			},
		},
		"multiple unreferenced images": {
			images: &imageapi.ImageList{
				Items: []imageapi.Image{
					{
						ObjectMeta:        metav1.ObjectMeta{Name: "image1"},
						DockerImageLayers: []imageapi.ImageLayer{{Name: "layer1", LayerSize: int64(1024)}},
					},
					{
						ObjectMeta: metav1.ObjectMeta{Name: "image2"},
						DockerImageLayers: []imageapi.ImageLayer{
							{Name: "layer1", LayerSize: int64(1024)},
							{Name: "layer2", LayerSize: int64(128)},
						},
					},
				},
			},
			streams: &imageapi.ImageStreamList{
				Items: []imageapi.ImageStream{
					{
						ObjectMeta: metav1.ObjectMeta{Name: "stream1", Namespace: "ns1"},
						Status: imageapi.ImageStreamStatus{
							Tags: map[string]imageapi.TagEventList{
								"tag1": {
									Items: []imageapi.TagEvent{{Image: "image1"}},
								},
							},
						},
					},
				},
			},
			expected: []Info{
				imageStreamInfo{
					ImageStream: "ns1/stream1",
					Storage:     int64(1024),
					Images:      1,
					Layers:      1,
				},
			},
		},
	}

	for name, test := range testCases {
		o := TopImageStreamsOptions{
			Images:  test.images,
			Streams: test.streams,
		}
		infos := o.imageStreamsTop()
		if !infosEqual(infos, test.expected) {
			t.Errorf("%s: unexpected infos, expected %#v, got %#v", name, test.expected, infos)
		}
	}
}

func infosEqual(actual, expected []Info) bool {
	if len(actual) != len(expected) {
		return false
	}

	for _, a := range actual {
		found := false
		for _, e := range expected {
			if kapihelper.Semantic.DeepEqual(a, e) {
				found = true
				break
			}
		}
		if !found {
			return false
		}
	}
	return true
}
