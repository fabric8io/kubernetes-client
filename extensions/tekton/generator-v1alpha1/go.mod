module github.com/fabric8io/kubernetes-client/extensions/tekton/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/tektoncd/pipeline v0.15.1
	k8s.io/apimachinery v0.17.6
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	k8s.io/api => k8s.io/api v0.16.5
	k8s.io/apimachinery => k8s.io/apimachinery v0.16.5
	k8s.io/client-go => k8s.io/client-go v0.16.5
)

go 1.13
