module github.com/fabric8io/kubernetes-client/extensions/jetstack/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/jetstack/cert-manager v1.1.1
	k8s.io/apiextensions-apiserver v0.19.0
	k8s.io/apimachinery v0.19.0
)

replace github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator

go 1.15
