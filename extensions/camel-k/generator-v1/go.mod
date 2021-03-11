module github.com/fabric8io/kubernetes-client/extensions/camel-k/generator

require (
	github.com/apache/camel-k v1.3.1 // indirect
	github.com/apache/camel-k/pkg/apis/camel v1.3.1
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/tektoncd/pipeline v0.13.1-0.20200625065359-44f22a067b75 // indirect
	k8s.io/apimachinery v0.19.0
	knative.dev/pkg v0.0.0-20200922164940-4bf40ad82aab
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	k8s.io/api => k8s.io/api v0.16.5
	k8s.io/apimachinery => k8s.io/apimachinery v0.16.5
	k8s.io/client-go => k8s.io/client-go v0.16.5
)

go 1.13
