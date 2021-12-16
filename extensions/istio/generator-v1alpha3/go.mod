module github.com/fabric8io/kubernetes-client/extensions/istio/generator

go 1.13

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/gogo/protobuf v1.3.2
	istio.io/api v0.0.0-20211124143550-67f86871f2a5
  istio.io/client-go v1.12.0
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	k8s.io/apimachinery => k8s.io/apimachinery v0.19.7
	k8s.io/client-go => k8s.io/client-go v0.19.7
)
