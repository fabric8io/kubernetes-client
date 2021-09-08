module github.com/fabric8io/kubernetes-client/kubernetes-model-generator

go 1.14

require (
	github.com/Microsoft/go-winio v0.4.15 // indirect
	github.com/Microsoft/hcsshim v0.8.10-0.20200715222032-5eafd1556990 // indirect
	github.com/containerd/containerd v1.4.4 // indirect
	github.com/containerd/ttrpc v1.0.2 // indirect
	github.com/containerd/typeurl v1.0.1 // indirect
	github.com/docker/docker v20.10.2+incompatible // indirect
	github.com/dougbtv/whereabouts v0.0.0-20200723172855-1e6ed41d0b3c
	github.com/gorilla/mux v1.8.0 // indirect
	github.com/k8snetworkplumbingwg/network-attachment-definition-client v1.1.0
	github.com/metal3-io/baremetal-operator/apis v0.0.0-20210608100644-f5228fa38953
	github.com/opencontainers/runtime-spec v1.0.3-0.20200929063507-e6143ca7d51d // indirect
	github.com/openshift/api v0.0.0-20210526151222-14f26e4285a4
	github.com/openshift/cloud-credential-operator v0.0.0-20210604234117-8814b05f76c3
	github.com/openshift/cluster-autoscaler-operator v0.0.1-0.20210519002000-fdae5baad94f
	github.com/openshift/cluster-network-operator v0.0.0-20210607181852-1ae6dc1b00c5
	github.com/openshift/cluster-node-tuning-operator v0.0.0-20210524233058-db8189430089
	github.com/openshift/machine-api-operator v0.2.1-0.20210513225032-5644b5803418
	github.com/openshift/machine-config-operator v0.0.1-0.20210522071823-15494d85812c
	github.com/operator-framework/api v0.9.1
	github.com/operator-framework/operator-lifecycle-manager v0.18.1
	github.com/prometheus-operator/prometheus-operator/pkg/apis/monitoring v0.47.1
	golang.org/x/oauth2 v0.0.0-20210210192628-66670185b0cd // indirect
	k8s.io/api v0.22.1
	k8s.io/apiextensions-apiserver v0.22.1
	k8s.io/apimachinery v0.22.1
	k8s.io/client-go v12.0.0+incompatible
	k8s.io/kube-aggregator v0.22.1
	k8s.io/metrics v0.22.1
	sigs.k8s.io/kube-storage-version-migrator v0.0.3
)

replace (
	bitbucket.org/ww/goautoneg => github.com/munnerz/goautoneg v0.0.0-20120707110453-a547fc61f48d
	github.com/mikefarah/yaml/v2 => gopkg.in/yaml.v2 v2.4.0
	github.com/openshift/api => github.com/openshift/api v0.0.0-20210601190906-e782d76c7bc4
	github.com/openshift/image-registry => github.com/openshift/image-registry v0.0.0-20200311172808-7511ca65e07b
	k8s.io/client-go => k8s.io/client-go v0.22.1
	k8s.io/component-helpers => k8s.io/component-helpers v0.22.1
	k8s.io/controller-manager => k8s.io/controller-manager v0.22.1
	k8s.io/mount-utils => k8s.io/mount-utils v0.22.1
	sigs.k8s.io/cluster-api-provider-aws => github.com/openshift/cluster-api-provider-aws v0.2.1-0.20201125052318-b85a18cbf338
	sigs.k8s.io/cluster-api-provider-azure => github.com/openshift/cluster-api-provider-azure v0.0.0-20210209143830-3442c7a36c1e
)

exclude (
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
