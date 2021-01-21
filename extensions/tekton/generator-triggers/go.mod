module github.com/fabric8io/kubernetes-client/extensions/tekton/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/tektoncd/triggers v0.11.1
	k8s.io/apimachinery v0.19.0
	knative.dev/pkg v0.0.0-20210107022335-51c72e24c179
	knative.dev/test-infra v0.0.0-20200921012245-37f1a12adbd3 // indirect
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator

	k8s.io/api => k8s.io/api v0.18.8
	k8s.io/apimachinery => k8s.io/apimachinery v0.18.8
	k8s.io/client-go => k8s.io/client-go v0.18.8

)

go 1.13
