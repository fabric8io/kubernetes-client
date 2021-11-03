module github.com/fabric8io/kubernetes-client/extensions/autoscaler/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	k8s.io/api v0.19.7
	k8s.io/apiextensions-apiserver v0.19.7
	k8s.io/apimachinery v0.19.7
	k8s.io/autoscaler/vertical-pod-autoscaler v0.9.2
)

replace github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator

go 1.15
