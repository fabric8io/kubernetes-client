module github.com/fabric8io/kubernetes-client/extensions/camel-k/generator

require (
	github.com/apache/camel-k/pkg/apis/camel v1.9.2
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/google/go-cmp v0.5.7 // indirect
	github.com/stretchr/testify v1.7.1 // indirect
	golang.org/x/net v0.0.0-20220412020605-290c469a71a5 // indirect
	golang.org/x/sys v0.0.0-20220412211240-33da011f77ad // indirect
	golang.org/x/xerrors v0.0.0-20220411194840-2f41105eb62f // indirect
	k8s.io/apimachinery v0.23.8
	knative.dev/pkg v0.0.0-20220705130606-e60d250dc637
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	github.com/gogo/protobuf => github.com/gogo/protobuf v1.3.2
	github.com/openshift/api => github.com/openshift/api v3.9.1-0.20190927182313-d4a64ec2cbd8+incompatible
	k8s.io/api => k8s.io/api v0.23.8
	k8s.io/apimachinery => k8s.io/apimachinery v0.23.8
	k8s.io/client-go => k8s.io/client-go v0.23.8
)

exclude github.com/mikefarah/yaml/v2 v2.4.0

go 1.13
