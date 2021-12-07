module github.com/fabric8io/kubernetes-client/extensions/open-cluster-management/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/google/go-cmp v0.5.6 // indirect
	github.com/onsi/gomega v1.15.0 // indirect
	github.com/open-cluster-management/multicluster-observability-operator v0.0.0-20211207052956-b7db87286188
	gopkg.in/check.v1 v1.0.0-20201130134442-10cb98267c6c // indirect
	k8s.io/apiextensions-apiserver v0.21.3 // indirect
	k8s.io/apimachinery v0.21.3
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	github.com/kubevirt/terraform-provider-kubevirt => github.com/nirarg/terraform-provider-kubevirt v0.0.0-20201222125919-101cee051ed3
	github.com/metal3-io/baremetal-operator => github.com/openshift/baremetal-operator v0.0.0-20200715132148-0f91f62a41fe
	github.com/metal3-io/cluster-api-provider-baremetal => github.com/openshift/cluster-api-provider-baremetal v0.0.0-20190821174549-a2a477909c1d
	github.com/openshift/hive/apis => github.com/openshift/hive/apis v0.0.0-20210521175321-356f6bf08f83
	github.com/terraform-providers/terraform-provider-aws => github.com/openshift/terraform-provider-aws v1.60.1-0.20210622193531-7d13cfbb1a8c
	github.com/terraform-providers/terraform-provider-azurerm => github.com/openshift/terraform-provider-azurerm v1.44.1-0.20210224232508-7509319df0f4
	github.com/terraform-providers/terraform-provider-ignition/v2 => github.com/community-terraform-providers/terraform-provider-ignition/v2 v2.1.0
	k8s.io/client-go => k8s.io/client-go v0.21.3
	// HiveConfig import dependencies
	sigs.k8s.io/cluster-api-provider-aws => github.com/openshift/cluster-api-provider-aws v0.2.1-0.20200506073438-9d49428ff837
	sigs.k8s.io/cluster-api-provider-azure => github.com/openshift/cluster-api-provider-azure v0.1.0-alpha.3.0.20200120114645-8a9592f1f87b
	sigs.k8s.io/cluster-api-provider-openstack => github.com/openshift/cluster-api-provider-openstack v0.0.0-20200526112135-319a35b2e38e
	sigs.k8s.io/kube-storage-version-migrator => github.com/openshift/kubernetes-kube-storage-version-migrator v0.0.3-0.20210302135122-481bd04dbc78
)

exclude (
	bitbucket.org/ww/goautoneg v0.0.0-20120707110453-75cd24fc2f2c
	github.com/hashicorp/terraform v0.12.21
	github.com/mikefarah/yaml/v2 v2.4.0
	github.com/open-cluster-management/multicloud-operators-foundation v1.0.0-2021-09-15-06-57-52
	github.com/openshift/api v3.9.1-0.20190924102528-32369d4db2ad+incompatible
	github.com/openshift/api v3.9.1-0.20191111211345-a27ff30ebf09+incompatible
	github.com/openshift/installer v0.9.0-master.0.20210211002944-d237b9dee575
	github.com/openshift/machine-api-operator v0.2.1-0.20191128180243-986b771e661d
	github.com/openshift/machine-api-operator v0.2.1-0.20200429102619-d36974451290
)

go 1.16
