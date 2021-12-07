module github.com/fabric8io/kubernetes-client/extensions/open-cluster-management/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/google/go-cmp v0.5.6 // indirect
	github.com/open-cluster-management/search-operator v1.0.1-2020-06-08-14-28-27.0.20211123212515-8daedeb76342
	gopkg.in/check.v1 v1.0.0-20201130134442-10cb98267c6c // indirect
	k8s.io/apimachinery v0.22.2
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	k8s.io/client-go => k8s.io/client-go v0.21.3
)

go 1.16
