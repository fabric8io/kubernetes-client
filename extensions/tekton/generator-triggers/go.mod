module github.com/fabric8io/kubernetes-client/extensions/tekton/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/tektoncd/pipeline v0.14.2 // indirect
	github.com/tektoncd/triggers v0.8.0
	k8s.io/apimachinery v0.18.2
	knative.dev/pkg v0.0.0-20200625173728-dfb81cf04a7c
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	k8s.io/client-go => k8s.io/client-go v0.16.5
)

go 1.13
