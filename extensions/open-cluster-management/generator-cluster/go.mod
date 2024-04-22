module github.com/fabric8io/kubernetes-client/extensions/open-cluster-management/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/google/go-cmp v0.5.6 // indirect
	github.com/json-iterator/go v1.1.11 // indirect
	github.com/stretchr/testify v1.7.0 // indirect
	golang.org/x/net v0.23.0 // indirect
	gopkg.in/check.v1 v1.0.0-20201130134442-10cb98267c6c // indirect
	gopkg.in/yaml.v3 v3.0.0 // indirect
	k8s.io/apimachinery v0.21.3
	open-cluster-management.io/api v0.5.1-0.20211202065430-827eba48608a
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	k8s.io/client-go => k8s.io/client-go v0.21.3
)

go 1.16
