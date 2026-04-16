module github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator

go 1.25.7

require (
	github.com/cert-manager/cert-manager v1.20.2
	github.com/chaos-mesh/chaos-mesh/api v0.0.0-20250513055240-4db47f53978c
	github.com/getkin/kin-openapi v0.135.0
	github.com/k8snetworkplumbingwg/network-attachment-definition-client v1.7.7
	github.com/kubernetes-csi/external-snapshotter/client/v8 v8.4.0
	github.com/metal3-io/baremetal-operator/apis v0.12.3
	github.com/metal3-io/cluster-api-provider-metal3/api v1.12.3
	github.com/metal3-io/ip-address-manager/api v1.12.3 // indirect
	// Match latest commit in the version branch (e.g. release-4.17)
	github.com/openshift/api v3.9.0+incompatible
	github.com/openshift/cloud-credential-operator v0.0.0-20251126011841-0e03b7a0fa39
	github.com/openshift/cluster-network-operator v0.0.0-20251211065745-698e349cb60e
	github.com/openshift/cluster-node-tuning-operator v0.0.0-20251108153041-2ed182ba5710
	github.com/openshift/hive/apis v0.0.0-20240930213556-2d25383963db
	github.com/openshift/installer v0.0.0-00010101000000-000000000000
	github.com/operator-framework/api v0.42.0
	github.com/operator-framework/operator-lifecycle-manager v0.42.0
	github.com/ovn-org/ovn-kubernetes/go-controller v0.0.0-20241030140127-a68ef49d9441
	github.com/prometheus-operator/prometheus-operator/pkg/apis/monitoring v0.90.1
	github.com/spf13/cobra v1.10.2
	github.com/stolostron/discovery v0.0.0-20250721184441-6a13204f0907
	github.com/stolostron/klusterlet-addon-controller v0.0.0-20250324045714-0d7e21c66660
	github.com/stolostron/multicluster-observability-operator v0.0.0-20250726172846-3a17a1a4168e
	github.com/stolostron/multiclusterhub-operator v0.0.0-20250728181123-c3e46b4bdbbc
	github.com/stolostron/search-v2-operator v0.0.0-20250609200037-030a382461f4
	github.com/tektoncd/pipeline v1.11.0
	github.com/tektoncd/triggers v0.35.0
	istio.io/client-go v1.29.2
	k8s.io/api v0.35.4
	k8s.io/apiextensions-apiserver v0.35.4
	k8s.io/apimachinery v0.35.4
	k8s.io/autoscaler/vertical-pod-autoscaler v1.6.0
	k8s.io/client-go v12.0.0+incompatible
	k8s.io/gengo/v2 v2.0.0-20251215205346-5ee0d033ba5b
	k8s.io/kube-openapi v0.0.0-20260319004828-5883c5ee87b9
	k8s.io/metrics v0.35.4
	knative.dev/caching v0.0.0-20260120130310-f1fc03b7f5ee
	knative.dev/eventing v0.48.2
	knative.dev/eventing-awssqs v0.29.0
	knative.dev/eventing-couchdb v0.28.0
	knative.dev/eventing-github v0.48.0
	knative.dev/eventing-gitlab v0.48.0
	knative.dev/eventing-kafka-broker v0.48.2
	knative.dev/eventing-prometheus v0.28.0
	knative.dev/networking v0.0.0-20260120131110-a7cdca238a0d
	knative.dev/serving v0.48.2
	open-cluster-management.io/api v1.2.0
	open-cluster-management.io/governance-policy-propagator v0.18.0
	open-cluster-management.io/multicloud-operators-channel v0.16.0
	open-cluster-management.io/multicloud-operators-subscription v0.16.0
	sigs.k8s.io/cluster-api v1.12.4
	sigs.k8s.io/gateway-api v1.5.1
	sigs.k8s.io/kustomize/api v0.21.1
	// This version is older than v1.10.0 see replacements below
	volcano.sh/apis v1.19.6
)

// Required by some openshift operator dependencies
// Force usage of latest Kuberentes Version
replace (
	// go list -m -json github.com/openshift/api@release-4.19
	github.com/openshift/api => github.com/openshift/api v0.0.0-20251202204302-1cb53e34ca33
	github.com/openshift/assisted-service/api => github.com/openshift/assisted-service/api v1.0.10-0.20251202132226-43bfecff9fdb
	github.com/openshift/assisted-service/client => github.com/openshift/assisted-service/client v1.0.10-0.20251202132226-43bfecff9fdb
	github.com/openshift/assisted-service/models => github.com/openshift/assisted-service/models v1.0.10-0.20251202132226-43bfecff9fdb
	github.com/openshift/hive => github.com/openshift/hive v1.1.17-0.20251208194543-6648a44ea777 // Latest Master
	github.com/openshift/installer => github.com/openshift/installer v1.4.21-pre // Most up-to-date tag https://issues.redhat.com/browse/OCPBUGS-42448

	k8s.io/api => k8s.io/api v0.35.2
	k8s.io/client-go => k8s.io/client-go v0.35.2
	k8s.io/cloud-provider => k8s.io/cloud-provider v0.35.2
	k8s.io/csi-translation-lib => k8s.io/csi-translation-lib v0.35.2
	k8s.io/kube-scheduler => k8s.io/kube-scheduler v0.35.2
	k8s.io/mount-utils => k8s.io/mount-utils v0.35.2

	// knative.dev/pkg/metrics was removed in latest versions, pin to version compatible with tektoncd/pipeline
	knative.dev/pkg => knative.dev/pkg v0.0.0-20250821143151-4ffdcf6b3fa5

	sigs.k8s.io/cluster-api => sigs.k8s.io/cluster-api v1.12.2

	// Some dependencies are not compatible with latest controller-runtime webhooks TODO: should be removed as soon as possible
	sigs.k8s.io/controller-runtime => sigs.k8s.io/controller-runtime v0.19.7
)

// Issues with dependabot, force pseudo-versions as replacements since dependabot will try to replace with invalid tagged major versions
replace (
	github.com/chaos-mesh/chaos-mesh => github.com/chaos-mesh/chaos-mesh v0.0.0-20250513055240-4db47f53978c
	github.com/chaos-mesh/chaos-mesh/api => github.com/chaos-mesh/chaos-mesh/api v0.0.0-20250513055240-4db47f53978c
	github.com/stolostron/multicluster-observability-operator => github.com/stolostron/multicluster-observability-operator v0.0.0-20250726172846-3a17a1a4168e
	github.com/stolostron/multiclusterhub-operator => github.com/stolostron/multiclusterhub-operator v0.0.0-20250728181123-c3e46b4bdbbc
	volcano.sh/apis => volcano.sh/apis v1.11.0
)

require (
	cel.dev/expr v0.25.1 // indirect
	github.com/Azure/azure-sdk-for-go/sdk/azcore v1.21.0 // indirect
	github.com/Azure/azure-sdk-for-go/sdk/internal v1.11.2 // indirect
	github.com/Azure/azure-sdk-for-go/sdk/resourcemanager/compute/armcompute/v5 v5.7.0 // indirect
	github.com/PaesslerAG/gval v1.0.0 // indirect
	github.com/PaesslerAG/jsonpath v0.1.1 // indirect
	github.com/alecthomas/units v0.0.0-20240927000941-0f3dac36c52b // indirect
	github.com/antlr/antlr4/runtime/Go/antlr v1.4.10 // indirect
	github.com/antlr4-go/antlr/v4 v4.13.1 // indirect
	github.com/asaskevich/govalidator v0.0.0-20230301143203-a9d515a09cc2 // indirect
	github.com/asaskevich/govalidator/v11 v11.0.2-0.20250122183457-e11347878e23 // indirect
	github.com/beorn7/perks v1.0.1 // indirect
	github.com/blang/semver/v4 v4.0.0 // indirect
	github.com/blendle/zapdriver v1.3.1 // indirect
	github.com/cenkalti/backoff/v5 v5.0.3 // indirect
	github.com/cespare/xxhash/v2 v2.3.0 // indirect
	github.com/cloudevents/sdk-go/sql/v2 v2.15.2 // indirect
	github.com/cloudevents/sdk-go/v2 v2.16.2 // indirect
	github.com/coreos/go-semver v0.3.1 // indirect
	github.com/coreos/go-systemd/v22 v22.7.0 // indirect
	github.com/coreos/ignition/v2 v2.24.0 // indirect
	github.com/coreos/vcontext v0.0.0-20231102161604-685dc7299dc5 // indirect
	github.com/davecgh/go-spew v1.1.2-0.20180830191138-d8f796af33cc // indirect
	github.com/docker/go-units v0.5.0 // indirect
	github.com/emicklei/go-restful/v3 v3.13.0 // indirect
	github.com/evanphx/json-patch/v5 v5.9.11 // indirect
	github.com/fsnotify/fsnotify v1.9.0 // indirect
	github.com/fxamacker/cbor/v2 v2.9.0 // indirect
	github.com/go-errors/errors v1.5.1 // indirect
	github.com/go-logr/logr v1.4.3 // indirect
	github.com/go-logr/stdr v1.2.2 // indirect
	github.com/go-logr/zapr v1.3.0 // indirect
	github.com/go-openapi/analysis v0.23.0 // indirect
	github.com/go-openapi/errors v0.22.1 // indirect
	github.com/go-openapi/jsonpointer v0.22.4 // indirect
	github.com/go-openapi/jsonreference v0.21.4 // indirect
	github.com/go-openapi/loads v0.22.0 // indirect
	github.com/go-openapi/spec v0.21.0 // indirect
	github.com/go-openapi/strfmt v0.23.0 // indirect
	github.com/go-openapi/swag v0.25.4 // indirect
	github.com/go-openapi/swag/cmdutils v0.25.4 // indirect
	github.com/go-openapi/swag/conv v0.25.4 // indirect
	github.com/go-openapi/swag/fileutils v0.25.4 // indirect
	github.com/go-openapi/swag/jsonname v0.25.4 // indirect
	github.com/go-openapi/swag/jsonutils v0.25.4 // indirect
	github.com/go-openapi/swag/loading v0.25.4 // indirect
	github.com/go-openapi/swag/mangling v0.25.4 // indirect
	github.com/go-openapi/swag/netutils v0.25.4 // indirect
	github.com/go-openapi/swag/stringutils v0.25.4 // indirect
	github.com/go-openapi/swag/typeutils v0.25.4 // indirect
	github.com/go-openapi/swag/yamlutils v0.25.4 // indirect
	github.com/go-openapi/validate v0.24.0 // indirect
	github.com/go-test/deep v1.1.1 // indirect
	github.com/golang/protobuf v1.5.4 // indirect
	github.com/google/cel-go v0.27.0 // indirect
	github.com/google/gnostic-models v0.7.1 // indirect
	github.com/google/go-cmp v0.7.0 // indirect
	github.com/google/go-containerregistry v0.21.3 // indirect
	github.com/google/go-github/v31 v31.0.0 // indirect
	github.com/google/go-querystring v1.1.0 // indirect
	github.com/google/uuid v1.6.0 // indirect
	github.com/grpc-ecosystem/grpc-gateway/v2 v2.28.0 // indirect
	github.com/h2non/filetype v1.1.3 // indirect
	github.com/h2non/go-is-svg v0.0.0-20160927212452-35e8c4b0612c // indirect
	github.com/hashicorp/go-cleanhttp v0.5.2 // indirect
	github.com/hashicorp/golang-lru v1.0.2 // indirect
	github.com/inconshreveable/mousetrap v1.1.0 // indirect
	github.com/josharian/intern v1.0.0 // indirect
	github.com/json-iterator/go v1.1.12 // indirect
	github.com/kdomanski/iso9660 v0.2.1 // indirect
	github.com/kelseyhightower/envconfig v1.4.0 // indirect
	github.com/mailru/easyjson v0.9.1 // indirect
	github.com/mattn/go-sqlite3 v2.0.3+incompatible // indirect
	github.com/mitchellh/mapstructure v1.5.0 // indirect
	github.com/modern-go/concurrent v0.0.0-20180306012644-bacd9c7ef1dd // indirect
	github.com/modern-go/reflect2 v1.0.3-0.20250322232337-35a7c28c31ee // indirect
	github.com/mohae/deepcopy v0.0.0-20170929034955-c48cc78d4826 // indirect
	github.com/munnerz/goautoneg v0.0.0-20191010083416-a7dc8b61c822 // indirect
	github.com/nutanix-cloud-native/prism-go-client v0.5.0 // indirect
	github.com/oasdiff/yaml v0.0.9 // indirect
	github.com/oasdiff/yaml3 v0.0.9 // indirect
	github.com/oklog/ulid v1.3.1 // indirect
	github.com/onsi/gomega v1.39.1 // indirect
	github.com/opencontainers/go-digest v1.0.0 // indirect
	github.com/openshift/custom-resource-status v1.1.3-0.20220503160415-f2fdb4999d87 // indirect
	github.com/operator-framework/operator-registry v1.65.0 // indirect
	github.com/perimeterx/marshmallow v1.1.5 // indirect
	github.com/pkg/errors v0.9.1 // indirect
	github.com/pmezard/go-difflib v1.0.1-0.20181226105442-5d4384ee4fb2 // indirect
	github.com/prometheus/client_golang v1.23.2 // indirect
	github.com/prometheus/client_model v0.6.2 // indirect
	github.com/prometheus/common v0.67.5 // indirect
	github.com/prometheus/otlptranslator v1.0.0 // indirect
	github.com/prometheus/procfs v0.19.2 // indirect
	github.com/rickb777/date v1.14.1 // indirect
	github.com/rickb777/plural v1.2.2 // indirect
	github.com/robfig/cron/v3 v3.0.1 // indirect
	github.com/sirupsen/logrus v1.9.4 // indirect
	github.com/spf13/pflag v1.0.10 // indirect
	github.com/stolostron/backplane-operator v0.0.0-20250724195055-fb90af6051f4 // indirect
	github.com/stolostron/cluster-lifecycle-api v0.0.0-20240813023109-42b5c115d0a3 // indirect
	github.com/vincent-petithory/dataurl v1.0.0 // indirect
	github.com/woodsbury/decimal128 v1.3.0 // indirect
	github.com/x448/float16 v0.8.4 // indirect
	go.mongodb.org/mongo-driver v1.17.4 // indirect
	go.opentelemetry.io/auto/sdk v1.2.1 // indirect
	go.opentelemetry.io/otel v1.43.0 // indirect
	go.opentelemetry.io/otel/exporters/otlp/otlpmetric/otlpmetricgrpc v1.42.0 // indirect
	go.opentelemetry.io/otel/exporters/otlp/otlpmetric/otlpmetrichttp v1.43.0 // indirect
	go.opentelemetry.io/otel/exporters/otlp/otlptrace v1.43.0 // indirect
	go.opentelemetry.io/otel/exporters/otlp/otlptrace/otlptracegrpc v1.42.0 // indirect
	go.opentelemetry.io/otel/exporters/otlp/otlptrace/otlptracehttp v1.43.0 // indirect
	go.opentelemetry.io/otel/exporters/prometheus v0.64.0 // indirect
	go.opentelemetry.io/otel/exporters/stdout/stdouttrace v1.42.0 // indirect
	go.opentelemetry.io/otel/metric v1.43.0 // indirect
	go.opentelemetry.io/otel/sdk v1.43.0 // indirect
	go.opentelemetry.io/otel/sdk/metric v1.43.0 // indirect
	go.opentelemetry.io/otel/trace v1.43.0 // indirect
	go.opentelemetry.io/proto/otlp v1.10.0 // indirect
	go.uber.org/multierr v1.11.0 // indirect
	go.uber.org/zap v1.27.1 // indirect
	go.yaml.in/yaml/v2 v2.4.4 // indirect
	go.yaml.in/yaml/v3 v3.0.4 // indirect
	golang.org/x/crypto v0.49.0 // indirect
	golang.org/x/exp v0.0.0-20260112195511-716be5621a96 // indirect
	golang.org/x/mod v0.34.0 // indirect
	golang.org/x/net v0.52.0 // indirect
	golang.org/x/oauth2 v0.36.0 // indirect
	golang.org/x/sync v0.20.0 // indirect
	golang.org/x/sys v0.42.0 // indirect
	golang.org/x/term v0.41.0 // indirect
	golang.org/x/text v0.35.0 // indirect
	golang.org/x/time v0.15.0 // indirect
	golang.org/x/tools v0.43.0 // indirect
	gomodules.xyz/jsonpatch/v2 v2.5.0 // indirect
	google.golang.org/genproto/googleapis/api v0.0.0-20260401024825-9d38bb4040a9 // indirect
	google.golang.org/genproto/googleapis/rpc v0.0.0-20260401024825-9d38bb4040a9 // indirect
	google.golang.org/grpc v1.80.0 // indirect
	google.golang.org/protobuf v1.36.11 // indirect
	gopkg.in/evanphx/json-patch.v4 v4.13.0 // indirect
	gopkg.in/inf.v0 v0.9.1 // indirect
	istio.io/api v1.29.2-0.20260408155000-a0e4e1cbfcc5 // indirect
	k8s.io/component-base v0.35.4 // indirect
	k8s.io/klog/v2 v2.140.0 // indirect
	k8s.io/utils v0.0.0-20260210185600-b8788abfbbc2 // indirect
	knative.dev/pkg v0.0.0-20260319144603-18c5d580ae64 // indirect
	sigs.k8s.io/cluster-api-provider-azure v1.22.1 // indirect
	sigs.k8s.io/controller-runtime v0.23.3 // indirect
	sigs.k8s.io/json v0.0.0-20250730193827-2d320260d730 // indirect
	sigs.k8s.io/kustomize/kyaml v0.21.1 // indirect
	sigs.k8s.io/randfill v1.0.0 // indirect
	sigs.k8s.io/structured-merge-diff/v6 v6.3.2 // indirect
	sigs.k8s.io/yaml v1.6.0 // indirect
)
