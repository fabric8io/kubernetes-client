module github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator

go 1.23

toolchain go1.23.1

require (
	github.com/getkin/kin-openapi v0.125.0
	// Match latest commit in the version branch (e.g. release-4.17)
	github.com/openshift/api v3.9.0+incompatible
	github.com/openshift/cluster-network-operator v0.0.0-20240912134426-a3188633549d
	github.com/operator-framework/api v0.27.0
	github.com/operator-framework/operator-lifecycle-manager v0.22.0
	github.com/spf13/cobra v1.8.1
	k8s.io/api v0.31.1
	k8s.io/apiextensions-apiserver v0.31.1
	k8s.io/apimachinery v0.31.1
	k8s.io/client-go v0.31.1
	k8s.io/gengo/v2 v2.0.0-20240911193312-2b36238f13e9
	k8s.io/kube-openapi v0.0.0-20240903163716-9e1beecbcb38
	k8s.io/metrics v0.30.2
	sigs.k8s.io/gateway-api v1.1.0
	sigs.k8s.io/kustomize/api v0.17.2
)

// TODO: WIP while this gets merged or fixed https://github.com/openshift/api/pull/2050
replace github.com/openshift/api => github.com/marcnuri-forks/api v0.0.0-20240930125604-62d5277244a4

// TODO: WIP while this gets merged or fixed https://github.com/operator-framework/api/pull/365
replace github.com/operator-framework/api => github.com/marcnuri-forks/operator-framework-api v0.0.0-20241001140003-cf4aa8da1ffa

// TODO: WIP while this gets merged or fixed https://github.com/operator-framework/operator-lifecycle-manager/pull/3406
replace github.com/operator-framework/operator-lifecycle-manager => github.com/marcnuri-forks/operator-lifecycle-manager v0.0.0-20241002090802-7539192fbf96

require (
	github.com/antlr4-go/antlr/v4 v4.13.0 // indirect
	github.com/blang/semver/v4 v4.0.0 // indirect
	github.com/davecgh/go-spew v1.1.2-0.20180830191138-d8f796af33cc // indirect
	github.com/emicklei/go-restful/v3 v3.12.1 // indirect
	github.com/fxamacker/cbor/v2 v2.7.0 // indirect
	github.com/go-errors/errors v1.4.2 // indirect
	github.com/go-logr/logr v1.4.2 // indirect
	github.com/go-openapi/jsonpointer v0.21.0 // indirect
	github.com/go-openapi/jsonreference v0.21.0 // indirect
	github.com/go-openapi/swag v0.23.0 // indirect
	github.com/gogo/protobuf v1.3.2 // indirect
	github.com/golang/groupcache v0.0.0-20210331224755-41bb18bfe9da // indirect
	github.com/golang/protobuf v1.5.4 // indirect
	github.com/google/cel-go v0.20.1 // indirect
	github.com/google/gnostic-models v0.6.8 // indirect
	github.com/google/gofuzz v1.2.0 // indirect
	github.com/h2non/filetype v1.1.3 // indirect
	github.com/h2non/go-is-svg v0.0.0-20160927212452-35e8c4b0612c // indirect
	github.com/inconshreveable/mousetrap v1.1.0 // indirect
	github.com/invopop/yaml v0.2.0 // indirect
	github.com/josharian/intern v1.0.0 // indirect
	github.com/json-iterator/go v1.1.12 // indirect
	github.com/mailru/easyjson v0.7.7 // indirect
	github.com/modern-go/concurrent v0.0.0-20180306012644-bacd9c7ef1dd // indirect
	github.com/modern-go/reflect2 v1.0.2 // indirect
	github.com/mohae/deepcopy v0.0.0-20170929034955-c48cc78d4826 // indirect
	github.com/onsi/gomega v1.34.2 // indirect
	github.com/operator-framework/operator-registry v1.47.0 // indirect
	github.com/perimeterx/marshmallow v1.1.5 // indirect
	github.com/sirupsen/logrus v1.9.3 // indirect
	github.com/spf13/pflag v1.0.6-0.20210604193023-d5e0c0615ace // indirect
	github.com/stoewer/go-strcase v1.3.0 // indirect
	github.com/x448/float16 v0.8.4 // indirect
	golang.org/x/exp v0.0.0-20240719175910-8a7402abbf56 // indirect
	golang.org/x/mod v0.21.0 // indirect
	golang.org/x/net v0.29.0 // indirect
	golang.org/x/oauth2 v0.22.0 // indirect
	golang.org/x/sync v0.8.0 // indirect
	golang.org/x/sys v0.25.0 // indirect
	golang.org/x/term v0.24.0 // indirect
	golang.org/x/text v0.18.0 // indirect
	golang.org/x/time v0.6.0 // indirect
	golang.org/x/tools v0.25.0 // indirect
	google.golang.org/genproto/googleapis/api v0.0.0-20240604185151-ef581f913117 // indirect
	google.golang.org/genproto/googleapis/rpc v0.0.0-20240701130421-f6361c86f094 // indirect
	google.golang.org/grpc v1.66.0 // indirect
	google.golang.org/protobuf v1.34.2 // indirect
	gopkg.in/inf.v0 v0.9.1 // indirect
	gopkg.in/yaml.v2 v2.4.0 // indirect
	gopkg.in/yaml.v3 v3.0.1 // indirect
	k8s.io/klog/v2 v2.130.1 // indirect
	k8s.io/utils v0.0.0-20240711033017-18e509b52bc8 // indirect
	sigs.k8s.io/controller-runtime v0.19.0 // indirect
	sigs.k8s.io/json v0.0.0-20221116044647-bc3834ca7abd // indirect
	sigs.k8s.io/kustomize/kyaml v0.17.1 // indirect
	sigs.k8s.io/structured-merge-diff/v4 v4.4.1 // indirect
	sigs.k8s.io/yaml v1.4.0 // indirect
)
