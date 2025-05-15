module github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator

go 1.24.0

toolchain go1.24.1

require (
	github.com/cert-manager/cert-manager v1.17.2
	github.com/chaos-mesh/chaos-mesh/api v0.0.0-20250513055240-4db47f53978c
	github.com/getkin/kin-openapi v0.131.0
	github.com/k8snetworkplumbingwg/network-attachment-definition-client v1.7.6
	github.com/kubernetes-csi/external-snapshotter/client/v8 v8.2.0
	github.com/metal3-io/baremetal-operator/apis v0.9.1
	github.com/metal3-io/cluster-api-provider-metal3/api v1.9.3
	// Match latest commit in the version branch (e.g. release-4.17)
	github.com/openshift/api v3.9.0+incompatible
	github.com/openshift/cloud-credential-operator v0.0.0-20240910052617-d668c182b0e3
	github.com/openshift/cluster-network-operator v0.0.0-20240912134426-a3188633549d
	github.com/openshift/cluster-node-tuning-operator v0.0.0-20241001165112-1685a8fc1376
	github.com/openshift/hive/apis v0.0.0-20240930213556-2d25383963db
	github.com/openshift/installer v0.0.0-00010101000000-000000000000
	github.com/operator-framework/api v0.29.0
	github.com/operator-framework/operator-lifecycle-manager v0.31.0
	github.com/ovn-org/ovn-kubernetes/go-controller v0.0.0-20241030140127-a68ef49d9441
	github.com/prometheus-operator/prometheus-operator/pkg/apis/monitoring v0.79.2
	github.com/spf13/cobra v1.9.1
	github.com/stolostron/discovery v0.0.0-20250318172401-0420e4bb969d
	github.com/stolostron/klusterlet-addon-controller v0.0.0-20250324045714-0d7e21c66660
	github.com/stolostron/multicluster-observability-operator v0.0.0-20250514110222-f012fb274292
	github.com/stolostron/multiclusterhub-operator v0.0.0-20250512195158-bdd641abff01
	github.com/stolostron/search-v2-operator v0.0.0-20250328175715-c789830f4144
	github.com/tektoncd/pipeline v0.70.0
	github.com/tektoncd/triggers v0.31.0
	istio.io/client-go v1.25.2
	k8s.io/api v0.33.0
	k8s.io/apiextensions-apiserver v0.33.0
	k8s.io/apimachinery v0.33.0
	k8s.io/autoscaler/vertical-pod-autoscaler v1.3.0
	k8s.io/client-go v12.0.0+incompatible
	k8s.io/gengo/v2 v2.0.0-20250207200755-1244d31929d7
	k8s.io/kube-openapi v0.0.0-20250318190949-c8a335a9a2ff
	k8s.io/metrics v0.33.0
	knative.dev/caching v0.0.0-20250415164313-8f20a1163dbf
	knative.dev/eventing v0.45.0
	knative.dev/eventing-awssqs v0.29.0
	knative.dev/eventing-couchdb v0.28.0
	knative.dev/eventing-github v0.44.0
	knative.dev/eventing-gitlab v0.45.0
	knative.dev/eventing-kafka-broker v0.44.2
	knative.dev/eventing-prometheus v0.28.0
	knative.dev/networking v0.0.0-20250415164913-6268d931d247
	knative.dev/serving v0.45.0
	open-cluster-management.io/api v0.16.1
	open-cluster-management.io/governance-policy-propagator v0.16.0
	open-cluster-management.io/multicloud-operators-channel v0.16.0
	open-cluster-management.io/multicloud-operators-subscription v0.16.0
	sigs.k8s.io/cluster-api v1.10.1
	sigs.k8s.io/gateway-api v1.2.1
	sigs.k8s.io/kustomize/api v0.19.0
	// This version is older than v1.10.0 see replacements below
	volcano.sh/apis v1.19.6
)

// Required by some openshift operator dependencies
// Force usage of latest Kuberentes Version
replace (
	github.com/openshift/api => github.com/openshift/api v0.0.0-20250305013520-e7f23be12279 // Latest 4.18
	github.com/openshift/assisted-service/api => github.com/openshift/assisted-service/api v0.0.0-20241003070528-341f9860c455
	github.com/openshift/assisted-service/client => github.com/openshift/assisted-service/client v0.0.0-20241003070528-341f9860c455
	github.com/openshift/assisted-service/models => github.com/openshift/assisted-service/models v0.0.0-20241003070528-341f9860c455
	github.com/openshift/hive => github.com/openshift/hive v1.1.17-0.20240930213556-2d25383963db // Latest Master
	github.com/openshift/installer => github.com/openshift/installer v0.91.0 // Most up-to-date tag https://issues.redhat.com/browse/OCPBUGS-42448

	k8s.io/api => k8s.io/api v0.33.0
	k8s.io/client-go => k8s.io/client-go v0.33.0
	k8s.io/cloud-provider => k8s.io/cloud-provider v0.33.0
	k8s.io/csi-translation-lib => k8s.io/csi-translation-lib v0.33.0
	k8s.io/kube-scheduler => k8s.io/kube-scheduler v0.33.0
	k8s.io/mount-utils => k8s.io/mount-utils v0.33.0
)

// Issues with dependabot, force pseudo-versions as replacements since dependabot will try to replace with invalid tagged major versions
replace (
	github.com/chaos-mesh/chaos-mesh => github.com/chaos-mesh/chaos-mesh v0.0.0-20250513055240-4db47f53978c
	github.com/chaos-mesh/chaos-mesh/api => github.com/chaos-mesh/chaos-mesh/api v0.0.0-20250513055240-4db47f53978c
	github.com/stolostron/multicluster-observability-operator => github.com/stolostron/multicluster-observability-operator v0.0.0-20250514110222-f012fb274292
	github.com/stolostron/multiclusterhub-operator => github.com/stolostron/multiclusterhub-operator v0.0.0-20250512195158-bdd641abff01
	volcano.sh/apis => volcano.sh/apis v1.11.0
)

require (
	cel.dev/expr v0.19.1 // indirect
	contrib.go.opencensus.io/exporter/ocagent v0.7.1-0.20200907061046-05415f1de66d // indirect
	contrib.go.opencensus.io/exporter/prometheus v0.4.2 // indirect
	github.com/99designs/gqlgen v0.17.63 // indirect
	github.com/PaesslerAG/gval v1.0.0 // indirect
	github.com/PaesslerAG/jsonpath v0.1.1 // indirect
	github.com/alecthomas/units v0.0.0-20231202071711-9a357b53e9c9 // indirect
	github.com/antlr/antlr4/runtime/Go/antlr v1.4.10 // indirect
	github.com/antlr4-go/antlr/v4 v4.13.1 // indirect
	github.com/aws/aws-sdk-go v1.53.5 // indirect
	github.com/beorn7/perks v1.0.1 // indirect
	github.com/blang/semver/v4 v4.0.0 // indirect
	github.com/blendle/zapdriver v1.3.1 // indirect
	github.com/census-instrumentation/opencensus-proto v0.4.1 // indirect
	github.com/cespare/xxhash/v2 v2.3.0 // indirect
	github.com/cloudevents/sdk-go/sql/v2 v2.15.2 // indirect
	github.com/cloudevents/sdk-go/v2 v2.15.2 // indirect
	github.com/coreos/go-semver v0.3.1 // indirect
	github.com/coreos/go-systemd/v22 v22.5.0 // indirect
	github.com/coreos/ignition/v2 v2.19.0 // indirect
	github.com/coreos/vcontext v0.0.0-20231102161604-685dc7299dc5 // indirect
	github.com/davecgh/go-spew v1.1.2-0.20180830191138-d8f796af33cc // indirect
	github.com/docker/go-units v0.5.0 // indirect
	github.com/emicklei/go-restful/v3 v3.12.2 // indirect
	github.com/evanphx/json-patch/v5 v5.9.11 // indirect
	github.com/fsnotify/fsnotify v1.8.0 // indirect
	github.com/fxamacker/cbor/v2 v2.7.0 // indirect
	github.com/go-errors/errors v1.5.1 // indirect
	github.com/go-kit/log v0.2.1 // indirect
	github.com/go-logfmt/logfmt v0.6.0 // indirect
	github.com/go-logr/logr v1.4.2 // indirect
	github.com/go-logr/zapr v1.3.0 // indirect
	github.com/go-openapi/jsonpointer v0.21.0 // indirect
	github.com/go-openapi/jsonreference v0.21.0 // indirect
	github.com/go-openapi/swag v0.23.0 // indirect
	github.com/go-test/deep v1.1.1 // indirect
	github.com/gogo/protobuf v1.3.2 // indirect
	github.com/golang/groupcache v0.0.0-20210331224755-41bb18bfe9da // indirect
	github.com/golang/protobuf v1.5.4 // indirect
	github.com/google/btree v1.1.3 // indirect
	github.com/google/cel-go v0.24.1 // indirect
	github.com/google/gnostic-models v0.6.9 // indirect
	github.com/google/go-cmp v0.7.0 // indirect
	github.com/google/go-containerregistry v0.20.3 // indirect
	github.com/google/go-github/v31 v31.0.0 // indirect
	github.com/google/go-querystring v1.1.0 // indirect
	github.com/google/gofuzz v1.2.0 // indirect
	github.com/google/uuid v1.6.0 // indirect
	github.com/grpc-ecosystem/grpc-gateway/v2 v2.26.1 // indirect
	github.com/h2non/filetype v1.1.3 // indirect
	github.com/h2non/go-is-svg v0.0.0-20160927212452-35e8c4b0612c // indirect
	github.com/hashicorp/errwrap v1.1.0 // indirect
	github.com/hashicorp/go-cleanhttp v0.5.2 // indirect
	github.com/hashicorp/go-multierror v1.1.1 // indirect
	github.com/hashicorp/golang-lru v1.0.2 // indirect
	github.com/inconshreveable/mousetrap v1.1.0 // indirect
	github.com/josharian/intern v1.0.0 // indirect
	github.com/json-iterator/go v1.1.12 // indirect
	github.com/kdomanski/iso9660 v0.2.1 // indirect
	github.com/kelseyhightower/envconfig v1.4.0 // indirect
	github.com/mailru/easyjson v0.9.0 // indirect
	github.com/mattn/go-sqlite3 v2.0.3+incompatible // indirect
	github.com/metal3-io/baremetal-operator/pkg/hardwareutils v0.5.1 // indirect
	github.com/metal3-io/ip-address-manager/api v1.9.4 // indirect
	github.com/moby/sys/sequential v0.6.0 // indirect
	github.com/modern-go/concurrent v0.0.0-20180306012644-bacd9c7ef1dd // indirect
	github.com/modern-go/reflect2 v1.0.2 // indirect
	github.com/mohae/deepcopy v0.0.0-20170929034955-c48cc78d4826 // indirect
	github.com/munnerz/goautoneg v0.0.0-20191010083416-a7dc8b61c822 // indirect
	github.com/nutanix-cloud-native/prism-go-client v0.3.4 // indirect
	github.com/oasdiff/yaml v0.0.0-20250309154309-f31be36b4037 // indirect
	github.com/oasdiff/yaml3 v0.0.0-20250309153720-d2182401db90 // indirect
	github.com/onsi/gomega v1.36.3 // indirect
	github.com/opencontainers/go-digest v1.0.0 // indirect
	github.com/openshift/custom-resource-status v1.1.3-0.20220503160415-f2fdb4999d87 // indirect
	github.com/operator-framework/operator-registry v1.50.0 // indirect
	github.com/perimeterx/marshmallow v1.1.5 // indirect
	github.com/phayes/freeport v0.0.0-20220201140144-74d24b5ae9f5 // indirect
	github.com/pkg/errors v0.9.1 // indirect
	github.com/prometheus/client_golang v1.22.0 // indirect
	github.com/prometheus/client_model v0.6.1 // indirect
	github.com/prometheus/common v0.62.0 // indirect
	github.com/prometheus/procfs v0.15.1 // indirect
	github.com/prometheus/statsd_exporter v0.22.7 // indirect
	github.com/rickb777/date v1.14.1 // indirect
	github.com/rickb777/plural v1.2.2 // indirect
	github.com/robfig/cron/v3 v3.0.1 // indirect
	github.com/sirupsen/logrus v1.9.3 // indirect
	github.com/spf13/pflag v1.0.6 // indirect
	github.com/stoewer/go-strcase v1.3.0 // indirect
	github.com/stolostron/backplane-operator v0.0.0-20250403142233-0078b1b2dc60 // indirect
	github.com/stolostron/cluster-lifecycle-api v0.0.0-20240813023109-42b5c115d0a3 // indirect
	github.com/vincent-petithory/dataurl v1.0.0 // indirect
	github.com/x448/float16 v0.8.4 // indirect
	go.opencensus.io v0.24.0 // indirect
	go.uber.org/multierr v1.11.0 // indirect
	go.uber.org/zap v1.27.0 // indirect
	golang.org/x/crypto v0.37.0 // indirect
	golang.org/x/exp v0.0.0-20250210185358-939b2ce775ac // indirect
	golang.org/x/mod v0.24.0 // indirect
	golang.org/x/net v0.39.0 // indirect
	golang.org/x/oauth2 v0.28.0 // indirect
	golang.org/x/sync v0.13.0 // indirect
	golang.org/x/sys v0.32.0 // indirect
	golang.org/x/term v0.31.0 // indirect
	golang.org/x/text v0.24.0 // indirect
	golang.org/x/time v0.10.0 // indirect
	golang.org/x/tools v0.32.0 // indirect
	gomodules.xyz/jsonpatch/v2 v2.5.0 // indirect
	google.golang.org/api v0.217.0 // indirect
	google.golang.org/genproto/googleapis/api v0.0.0-20250207221924-e9438ea467c6 // indirect
	google.golang.org/genproto/googleapis/rpc v0.0.0-20250324211829-b45e905df463 // indirect
	google.golang.org/grpc v1.71.1 // indirect
	google.golang.org/protobuf v1.36.6 // indirect
	gopkg.in/evanphx/json-patch.v4 v4.12.0 // indirect
	gopkg.in/inf.v0 v0.9.1 // indirect
	gopkg.in/yaml.v2 v2.4.0 // indirect
	gopkg.in/yaml.v3 v3.0.1 // indirect
	istio.io/api v1.25.2-0.20250410212420-84c271001f68 // indirect
	k8s.io/klog/v2 v2.130.1 // indirect
	k8s.io/utils v0.0.0-20241210054802-24370beab758 // indirect
	knative.dev/pkg v0.0.0-20250415155312-ed3e2158b883 // indirect
	sigs.k8s.io/controller-runtime v0.20.4 // indirect
	sigs.k8s.io/json v0.0.0-20241014173422-cfa47c3a1cc8 // indirect
	sigs.k8s.io/kustomize/kyaml v0.19.0 // indirect
	sigs.k8s.io/randfill v1.0.0 // indirect
	sigs.k8s.io/structured-merge-diff/v4 v4.6.0 // indirect
	sigs.k8s.io/yaml v1.4.0 // indirect
)
