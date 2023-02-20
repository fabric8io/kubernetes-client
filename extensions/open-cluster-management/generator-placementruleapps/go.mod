module github.com/fabric8io/kubernetes-client/extensions/open-cluster-management/generator

require (
	github.com/emicklei/go-restful v2.16.0+incompatible // indirect
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/google/go-cmp v0.5.6 // indirect
	github.com/onsi/gomega v1.15.0 // indirect
	github.com/open-cluster-management/multicloud-integrations v0.0.0-20211122215332-8df668a32c2f
	github.com/open-cluster-management/multicloud-operators-placementrule v1.2.4-0-20210816-699e5
	gopkg.in/check.v1 v1.0.0-20201130134442-10cb98267c6c // indirect
	k8s.io/apimachinery v0.21.3
	sigs.k8s.io/controller-runtime v0.9.2 // indirect
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
