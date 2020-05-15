module github.com/fabric8io/kubernetes-client/extensions/knative/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/kubernetes-sigs/service-catalog v0.2.2
	k8s.io/apimachinery v0.18.2
)

replace github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator

go 1.13
