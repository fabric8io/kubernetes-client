module github.com/fabric8io/kubernetes-client/kubernetes-model-generator

go 1.14

require (
	github.com/docker/docker v20.10.2+incompatible // indirect
	github.com/gorilla/mux v1.8.0 // indirect
	github.com/k8snetworkplumbingwg/network-attachment-definition-client v1.2.0
	github.com/k8snetworkplumbingwg/whereabouts v0.4.3-0.20211129155010-abd29e856f36
	github.com/metal3-io/baremetal-operator/apis v0.0.0-20211201170610-92ffa60c683d
	github.com/metal3-io/baremetal-operator/pkg/hardwareutils v0.0.0-20211201170610-92ffa60c683d // indirect
	github.com/openshift/api v0.0.0-20211201215911-5a82bae32e46
	github.com/openshift/cloud-credential-operator v0.0.0-20211129235416-c4ce9b8b79de
	github.com/openshift/cluster-autoscaler-operator v0.0.1-0.20211120222321-da0812a49473
	github.com/openshift/cluster-network-operator v0.0.0-20211123023629-88b7cdc9034e
	github.com/openshift/cluster-node-tuning-operator v0.0.0-20211115083052-29e877edbbf1
	github.com/openshift/machine-config-operator v0.0.1-0.20211201165713-c533e61a9e4f
	github.com/operator-framework/api v0.10.7
	github.com/operator-framework/operator-lifecycle-manager v0.19.1
	github.com/prometheus-operator/prometheus-operator/pkg/apis/monitoring v0.52.1
	k8s.io/api v0.22.3
	k8s.io/apiextensions-apiserver v0.22.3
	k8s.io/apimachinery v0.22.3
	k8s.io/client-go v12.0.0+incompatible
	k8s.io/kube-aggregator v0.22.1
	k8s.io/metrics v0.22.1
	sigs.k8s.io/kube-storage-version-migrator v0.0.5
)

replace (
	bitbucket.org/ww/goautoneg => github.com/munnerz/goautoneg v0.0.0-20120707110453-a547fc61f48d
	github.com/mikefarah/yaml/v2 => gopkg.in/yaml.v2 v2.4.0
	github.com/openshift/api => github.com/openshift/api v0.0.0-20211201215911-5a82bae32e46
	k8s.io/client-go => k8s.io/client-go v0.22.1
	k8s.io/component-helpers => k8s.io/component-helpers v0.22.1
	k8s.io/controller-manager => k8s.io/controller-manager v0.22.1
	k8s.io/mount-utils => k8s.io/mount-utils v0.22.1
	sigs.k8s.io/cluster-api-provider-aws => github.com/openshift/cluster-api-provider-aws v0.2.1-0.20201125052318-b85a18cbf338
	sigs.k8s.io/cluster-api-provider-azure => github.com/openshift/cluster-api-provider-azure v0.0.0-20210209143830-3442c7a36c1e
)

exclude (
	github.com/golangci/golangci-lint v1.42.1
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
	k8s.io/legacy-cloud-providers v0.0.0
	k8s.io/metrics v0.0.0
	k8s.io/sample-apiserver v0.0.0
)
