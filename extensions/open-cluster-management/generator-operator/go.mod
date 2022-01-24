module github.com/fabric8io/kubernetes-client/extensions/open-cluster-management/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/open-cluster-management/multiclusterhub-operator v0.0.0-20211124161036-3362e31b8413
	k8s.io/apimachinery v0.21.3
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	github.com/openshift/hive/apis => github.com/openshift/hive/apis v0.0.0-20210521175321-356f6bf08f83
	k8s.io/client-go => k8s.io/client-go v0.21.3
)

exclude (
	github.com/mikefarah/yaml/v2 v2.4.0
	github.com/openshift/api v3.9.1-0.20190924102528-32369d4db2ad+incompatible
	github.com/openshift/api v3.9.1-0.20191111211345-a27ff30ebf09+incompatible
)

go 1.16
