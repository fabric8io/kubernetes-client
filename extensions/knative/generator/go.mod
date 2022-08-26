module github.com/fabric8io/kubernetes-client/extensions/knative/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	k8s.io/apimachinery v0.23.9
	knative.dev/eventing v0.34.1
	knative.dev/eventing-awssqs v0.28.0
	knative.dev/eventing-couchdb v0.28.0
	knative.dev/eventing-github v0.34.0
	knative.dev/eventing-gitlab v0.34.0
	knative.dev/eventing-kafka v0.34.0
	knative.dev/eventing-prometheus v0.28.0
	knative.dev/pkg v0.0.0-20220818004048-4a03844c0b15
	knative.dev/serving v0.34.0
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	github.com/googleapis/gnostic => github.com/googleapis/gnostic v0.5.5
	k8s.io/apimachinery => k8s.io/apimachinery v0.23.9
	k8s.io/client-go => k8s.io/client-go v0.23.9
        github.com/gogo/protobuf => github.com/gogo/protobuf v1.3.2
        gopkg.in/yaml.v2 => gopkg.in/yaml.v2 v2.4.0
        github.com/containerd/containerd => github.com/containerd/containerd v1.6.0
        github.com/docker/distribution => github.com/docker/distribution v2.8.0+incompatible
        github.com/opencontainers/image-spec => github.com/opencontainers/image-spec v1.0.3-0.20220114050600-8b9d41f48198
)

exclude github.com/apache/camel-k v0.0.0-20200430164844-778ae8a2bd63

go 1.13
