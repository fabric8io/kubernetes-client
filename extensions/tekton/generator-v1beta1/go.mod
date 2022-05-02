module github.com/fabric8io/kubernetes-client/extensions/tekton/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/tektoncd/pipeline v0.35.0
	k8s.io/apimachinery v0.23.5
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	k8s.io/api => k8s.io/api v0.23.5
	k8s.io/apimachinery => k8s.io/apimachinery v0.23.5
	k8s.io/client-go => k8s.io/client-go v0.23.5
)

go 1.13
