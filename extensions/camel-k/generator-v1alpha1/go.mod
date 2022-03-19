module github.com/fabric8io/kubernetes-client/extensions/camel-k/generator

require (
	github.com/apache/camel-k v1.8.2 // indirect
	github.com/apache/camel-k/pkg/apis/camel v1.8.2
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	k8s.io/apimachinery v0.21.4
        knative.dev/pkg v0.0.0-20211206113427-18589ac7627e
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	github.com/openshift/api => github.com/openshift/api v3.9.1-0.20190927182313-d4a64ec2cbd8+incompatible
	k8s.io/api => k8s.io/api v0.21.4
	k8s.io/apimachinery => k8s.io/apimachinery v0.21.4
	k8s.io/client-go => k8s.io/client-go v0.21.4
)

exclude github.com/mikefarah/yaml/v2 v2.4.0

go 1.13
