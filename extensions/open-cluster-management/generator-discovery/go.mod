module github.com/fabric8io/kubernetes-client/extensions/open-cluster-management/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/open-cluster-management/discovery v0.0.0-20211111172442-74c6f43c409b
	k8s.io/apimachinery v0.22.1
)

replace github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator

go 1.16
