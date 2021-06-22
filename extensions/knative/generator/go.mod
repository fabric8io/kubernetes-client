module github.com/fabric8io/kubernetes-client/extensions/knative/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/robfig/cron v1.2.0 // indirect
	k8s.io/apimachinery v0.19.7
	knative.dev/eventing v0.23.0
	knative.dev/eventing-contrib v0.17.8
	knative.dev/pkg v0.0.0-20210526081028-980a33719a10
	knative.dev/serving v0.23.0
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	github.com/googleapis/gnostic => github.com/googleapis/gnostic v0.5.3
	k8s.io/apimachinery => k8s.io/apimachinery v0.19.7
	k8s.io/client-go => k8s.io/client-go v0.19.7
)

exclude (
       github.com/apache/camel-k v0.0.0-20200430164844-778ae8a2bd63
)


go 1.13
