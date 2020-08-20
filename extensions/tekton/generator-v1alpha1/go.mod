module github.com/fabric8io/kubernetes-client/extensions/tekton/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/tektoncd/pipeline v0.10.2
	k8s.io/apimachinery v0.17.1
)

replace github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator

go 1.13
