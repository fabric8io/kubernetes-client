module github.com/fabric8io/kubernetes-client/extensions/tekton/generator-triggers-v1alpha1

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/tektoncd/triggers v0.20.2
	k8s.io/apiextensions-apiserver v0.23.4
	k8s.io/apimachinery v0.23.5
	k8s.io/client-go v11.0.1-0.20190805182717-6502b5e7b1b5+incompatible // indirect
	knative.dev/pkg v0.0.0-20220329144915-0a1ec2e0d46c
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	k8s.io/api => k8s.io/api v0.23.5
	k8s.io/apimachinery => k8s.io/apimachinery v0.23.5
	k8s.io/client-go => k8s.io/client-go v0.23.5
)

go 1.13
