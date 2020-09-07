module github.com/fabric8io/kubernetes-client/extensions/knative/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/robfig/cron v1.2.0 // indirect
	gomodules.xyz/jsonpatch/v2 v2.1.0 // indirect
	k8s.io/apimachinery v0.19.0
	knative.dev/eventing v0.17.3
	knative.dev/eventing-contrib v0.17.0
	knative.dev/pkg v0.0.0-20200824160247-5343c1d19369
	knative.dev/serving v0.17.2
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	github.com/googleapis/gnostic => github.com/googleapis/gnostic v0.3.1
	k8s.io/apimachinery => k8s.io/apimachinery v0.17.6
	k8s.io/client-go => k8s.io/client-go v0.17.6
)

go 1.13
