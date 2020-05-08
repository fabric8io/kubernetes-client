module github.com/fabric8io/kubernetes-client/extensions/knative/generator

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	github.com/google/go-containerregistry v0.0.0-20200413145205-82d30a103c0a // indirect
	github.com/knative/eventing v0.13.2
	github.com/knative/serving v0.13.2
	github.com/robfig/cron v1.2.0 // indirect
	go.uber.org/zap v1.14.1 // indirect
	gomodules.xyz/jsonpatch/v2 v2.1.0 // indirect
	k8s.io/api v0.17.4 // indirect
	k8s.io/apimachinery v0.17.4
	k8s.io/client-go v0.17.4 // indirect
	knative.dev/eventing v0.13.2
	knative.dev/pkg v0.0.0-20200306230727-a56a6ea3fa56
	knative.dev/serving v0.13.2 // indirect
)

replace github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator

go 1.13
