module github.com/fabric8io/kubernetes-client/extensions/jetstack/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/jetstack/cert-manager v1.6.0
	k8s.io/apiextensions-apiserver v0.22.2
	k8s.io/apimachinery v0.22.2
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	github.com/gogo/protobuf => github.com/gogo/protobuf v1.3.2
	gopkg.in/yaml.v2 => gopkg.in/yaml.v2 v2.4.0
)

go 1.15
