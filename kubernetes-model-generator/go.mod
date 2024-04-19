module github.com/fabric8io/kubernetes-client/kubernetes-model-generator

go 1.21

require (
	github.com/k8snetworkplumbingwg/network-attachment-definition-client v1.4.0
	github.com/k8snetworkplumbingwg/whereabouts v0.4.3-0.20211129155010-abd29e856f36
	github.com/metal3-io/baremetal-operator/apis v0.2.0
	github.com/metal3-io/cluster-api-provider-metal3/api v0.0.0-00010101000000-000000000000
	github.com/openshift/api v0.0.0-20231003083825-c3f7566f6ef6
	github.com/openshift/cloud-credential-operator v0.0.0-20230928214554-c98388e9e379
	github.com/openshift/cluster-autoscaler-operator v0.0.1-0.20230925164720-b85f20ceee19
	github.com/openshift/cluster-network-operator v0.0.0-20230929174123-e06f5c0b5651
	github.com/openshift/cluster-node-tuning-operator v0.0.0-20230929150138-890d5eefa956
	github.com/openshift/hive/apis v0.0.0-20230921195800-227c25916da4
	github.com/openshift/installer v0.9.0-master.0.20230306121016-3485fddca1c3
	github.com/openshift/machine-config-operator v0.0.1-0.20230807154212-886c5c3fc7a9
	github.com/operator-framework/api v0.17.7
	github.com/operator-framework/operator-lifecycle-manager v0.22.0
	github.com/prometheus-operator/prometheus-operator/pkg/apis/monitoring v0.68.0
	k8s.io/api v0.29.0
	k8s.io/apiextensions-apiserver v0.29.0
	k8s.io/apimachinery v0.29.0
	k8s.io/client-go v12.0.0+incompatible
	k8s.io/kube-aggregator v0.29.0
	k8s.io/metrics v0.29.0
	sigs.k8s.io/gateway-api v1.0.0
	sigs.k8s.io/kube-storage-version-migrator v0.0.5
	sigs.k8s.io/kustomize/api v0.14.0
)

require (
	github.com/PaesslerAG/gval v1.0.0 // indirect
	github.com/PaesslerAG/jsonpath v0.1.1 // indirect
	github.com/antlr/antlr4/runtime/Go/antlr/v4 v4.0.0-20230305170008-8188dc5388df // indirect
	github.com/aws/aws-sdk-go v1.44.204 // indirect
	github.com/beorn7/perks v1.0.1 // indirect
	github.com/blang/semver v3.5.1+incompatible // indirect
	github.com/blang/semver/v4 v4.0.0 // indirect
	github.com/bshuster-repo/logrus-logstash-hook v1.1.0 // indirect
	github.com/cespare/xxhash/v2 v2.2.0 // indirect
	github.com/davecgh/go-spew v1.1.2-0.20180830191138-d8f796af33cc // indirect
	github.com/emicklei/go-restful/v3 v3.11.0 // indirect
	github.com/evanphx/json-patch/v5 v5.7.0 // indirect
	github.com/fsnotify/fsnotify v1.7.0 // indirect
	github.com/go-errors/errors v1.4.2 // indirect
	github.com/go-logr/logr v1.3.0 // indirect
	github.com/go-logr/zapr v1.2.4 // indirect
	github.com/go-openapi/jsonpointer v0.20.0 // indirect
	github.com/go-openapi/jsonreference v0.20.2 // indirect
	github.com/go-openapi/swag v0.22.4 // indirect
	github.com/gogo/protobuf v1.3.2 // indirect
	github.com/golang/groupcache v0.0.0-20210331224755-41bb18bfe9da // indirect
	github.com/golang/protobuf v1.5.3 // indirect
	github.com/google/cel-go v0.17.7 // indirect
	github.com/google/gnostic-models v0.6.8 // indirect
	github.com/google/go-cmp v0.6.0 // indirect
	github.com/google/gofuzz v1.2.0 // indirect
	github.com/google/uuid v1.3.1 // indirect
	github.com/h2non/filetype v1.1.1 // indirect
	github.com/h2non/go-is-svg v0.0.0-20160927212452-35e8c4b0612c // indirect
	github.com/imdario/mergo v0.3.16 // indirect
	github.com/josharian/intern v1.0.0 // indirect
	github.com/json-iterator/go v1.1.12 // indirect
	github.com/kdomanski/iso9660 v0.2.1 // indirect
	github.com/mailru/easyjson v0.7.7 // indirect
	github.com/matttproud/golang_protobuf_extensions/v2 v2.0.0 // indirect
	github.com/metal3-io/baremetal-operator/pkg/hardwareutils v0.2.0 // indirect
	github.com/metal3-io/ip-address-manager/api v1.5.1 // indirect
	github.com/modern-go/concurrent v0.0.0-20180306012644-bacd9c7ef1dd // indirect
	github.com/modern-go/reflect2 v1.0.2 // indirect
	github.com/munnerz/goautoneg v0.0.0-20191010083416-a7dc8b61c822 // indirect
	github.com/nutanix-cloud-native/prism-go-client v0.2.1-0.20220804130801-c8a253627c64 // indirect
	github.com/onsi/gomega v1.29.0 // indirect
	github.com/openshift/custom-resource-status v1.1.3-0.20220503160415-f2fdb4999d87 // indirect
	github.com/operator-framework/operator-registry v1.29.0 // indirect
	github.com/pkg/errors v0.9.1 // indirect
	github.com/prometheus/client_golang v1.17.0 // indirect
	github.com/prometheus/client_model v0.5.0 // indirect
	github.com/prometheus/common v0.45.0 // indirect
	github.com/prometheus/procfs v0.12.0 // indirect
	github.com/sirupsen/logrus v1.9.3 // indirect
	github.com/spf13/pflag v1.0.6-0.20210604193023-d5e0c0615ace // indirect
	github.com/stoewer/go-strcase v1.3.0 // indirect
	go.uber.org/multierr v1.11.0 // indirect
	go.uber.org/zap v1.26.0 // indirect
	golang.org/x/exp v0.0.0-20231006140011-7918f672742d // indirect
	golang.org/x/net v0.23.0 // indirect
	golang.org/x/oauth2 v0.13.0 // indirect
	golang.org/x/sys v0.18.0 // indirect
	golang.org/x/term v0.18.0 // indirect
	golang.org/x/text v0.14.0 // indirect
	golang.org/x/time v0.3.0 // indirect
	gomodules.xyz/jsonpatch/v2 v2.4.0 // indirect
	google.golang.org/appengine v1.6.8 // indirect
	google.golang.org/genproto/googleapis/api v0.0.0-20230726155614-23370e0ffb3e // indirect
	google.golang.org/genproto/googleapis/rpc v0.0.0-20230822172742-b8732ec3820d // indirect
	google.golang.org/grpc v1.58.3 // indirect
	google.golang.org/protobuf v1.33.0 // indirect
	gopkg.in/inf.v0 v0.9.1 // indirect
	gopkg.in/yaml.v2 v2.4.0 // indirect
	gopkg.in/yaml.v3 v3.0.1 // indirect
	k8s.io/component-base v0.29.0 // indirect
	k8s.io/klog/v2 v2.110.1 // indirect
	k8s.io/kube-openapi v0.0.0-20231010175941-2dd684a91f00 // indirect
	k8s.io/utils v0.0.0-20230726121419-3b25d923346b // indirect
	sigs.k8s.io/cluster-api v1.5.2 // indirect
	sigs.k8s.io/controller-runtime v0.16.3 // indirect
	sigs.k8s.io/json v0.0.0-20221116044647-bc3834ca7abd // indirect
	sigs.k8s.io/kustomize/kyaml v0.14.3 // indirect
	sigs.k8s.io/structured-merge-diff/v4 v4.4.1 // indirect
	sigs.k8s.io/yaml v1.4.0 // indirect
)

replace (
	bitbucket.org/ww/goautoneg => github.com/munnerz/goautoneg v0.0.0-20120707110453-a547fc61f48d
	github.com/IBM-Cloud/terraform-provider-ibm => github.com/openshift/terraform-provider-ibm v1.26.2-openshift-2
	github.com/containerd/containerd => github.com/containerd/containerd v1.5.13
	github.com/docker/distribution => github.com/docker/distribution v2.8.0+incompatible
	github.com/gogo/protobuf => github.com/gogo/protobuf v1.3.2
	github.com/metal3-io/baremetal-operator => github.com/openshift/baremetal-operator v0.0.0-20231002072530-755bd1d88f04
	github.com/metal3-io/baremetal-operator/apis => github.com/openshift/baremetal-operator/apis v0.0.0-20231002072530-755bd1d88f04
	github.com/metal3-io/cluster-api-provider-metal3/api => github.com/metal3-io/cluster-api-provider-metal3/api v1.5.1
	github.com/mikefarah/yaml/v2 => gopkg.in/yaml.v2 v2.4.0
	github.com/opencontainers/image-spec => github.com/opencontainers/image-spec v1.0.2
	github.com/openshift/api => github.com/openshift/api v0.0.0-20230615141659-a6fbaf36017d
	github.com/openshift/assisted-service/api => github.com/openshift/assisted-service/api v0.0.0-20231001134623-54b30e6f7d8e
	github.com/openshift/assisted-service/models => github.com/openshift/assisted-service/models v0.0.0-20231001134623-54b30e6f7d8e
	github.com/terraform-providers/terraform-provider-aws => github.com/openshift/terraform-provider-aws v1.60.1-0.20211215220004-24df6d73af46
	github.com/terraform-providers/terraform-provider-ignition/v2 => github.com/community-terraform-providers/terraform-provider-ignition/v2 v2.1.0
	k8s.io/client-go => k8s.io/client-go v0.29.0
	k8s.io/cloud-provider-vsphere => github.com/openshift/cloud-provider-vsphere v1.19.1-0.20230928092837-f518c23f1b0d
	k8s.io/component-helpers => k8s.io/component-helpers v0.29.0
	k8s.io/controller-manager => k8s.io/controller-manager v0.29.0
	k8s.io/mount-utils => k8s.io/mount-utils v0.29.0
	sigs.k8s.io/cluster-api => sigs.k8s.io/cluster-api v1.5.2
	sigs.k8s.io/cluster-api-provider-aws => github.com/openshift/cluster-api-provider-aws v0.2.1-0.20230919101006-78c1a04f0a1c
	sigs.k8s.io/cluster-api-provider-azure => github.com/openshift/cluster-api-provider-azure v0.1.0-alpha.3.0.20230918123958-2aec6b9229c3
	sigs.k8s.io/cluster-api-provider-openstack => github.com/openshift/cluster-api-provider-openstack v0.0.0-20230919060426-51224b6ed0c3
	sigs.k8s.io/controller-runtime => sigs.k8s.io/controller-runtime v0.16.2
)

exclude (
	github.com/golangci/golangci-lint v1.42.1
	github.com/gorilla/mux v0.0.0
	github.com/metal3-io/baremetal-operator/pkg/hardwareutils v0.0.0
	github.com/mikefarah/yaml/v2 v2.4.0
	k8s.io/api v0.0.0
	k8s.io/apiextensions-apiserver v0.0.0
	k8s.io/apimachinery v0.0.0
	k8s.io/apiserver v0.0.0
	k8s.io/cli-runtime v0.0.0
	k8s.io/client-go v0.0.0
	k8s.io/cloud-provider v0.0.0
	k8s.io/cluster-bootstrap v0.0.0
	k8s.io/code-generator v0.0.0
	k8s.io/component-base v0.0.0
	k8s.io/cri-api v0.0.0
	k8s.io/csi-translation-lib v0.0.0
	k8s.io/kube-aggregator v0.0.0
	k8s.io/kube-controller-manager v0.0.0
	k8s.io/kube-proxy v0.0.0
	k8s.io/kube-scheduler v0.0.0
	k8s.io/kubectl v0.0.0
	k8s.io/kubelet v0.0.0
	k8s.io/kubernetes v0.0.0
	k8s.io/legacy-cloud-providers v0.0.0
	k8s.io/metrics v0.0.0
	k8s.io/sample-apiserver v0.0.0
)
