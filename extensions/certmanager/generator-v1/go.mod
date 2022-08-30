module github.com/fabric8io/kubernetes-client/extensions/jetstack/generator

require (
	github.com/cert-manager/cert-manager v1.9.0-beta.1.0.20220829113803-8465f1223efb
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	k8s.io/apiextensions-apiserver v0.24.2
	k8s.io/apimachinery v0.24.2
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	github.com/gogo/protobuf => github.com/gogo/protobuf v1.3.2
	gopkg.in/yaml.v2 => gopkg.in/yaml.v2 v2.4.0
)

go 1.15
