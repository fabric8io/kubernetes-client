module cmd/generate/generate.go

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 // indirect
	k8s.io/apiextensions-apiserver v0.19.0 // indirect
	volcano.sh/apis v1.3.0-k8s1.18.3 // indirect
)

replace github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator

go 1.16
