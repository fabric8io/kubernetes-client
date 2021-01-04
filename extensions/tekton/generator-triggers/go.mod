module github.com/fabric8io/kubernetes-client/extensions/tekton/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/tektoncd/triggers v0.10.2
	k8s.io/apimachinery v0.19.0
	knative.dev/pkg v0.0.0-20200922164940-4bf40ad82aab
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator

	k8s.io/api => k8s.io/api v0.18.8
    k8s.io/apimachinery => k8s.io/apimachinery v0.18.8
    k8s.io/client-go => k8s.io/client-go v0.18.8

)

go 1.13
