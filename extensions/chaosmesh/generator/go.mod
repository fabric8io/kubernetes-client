module github.com/fabric8io/kubernetes-client/extensions/chaosmesh/generator

require (
	github.com/chaos-mesh/chaos-mesh/api/v1alpha1 v0.0.0-20220226050744-799408773657
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	k8s.io/apimachinery v0.23.1
)

require (
	github.com/alecthomas/units v0.0.0-20210927113745-59d0afb8317a // indirect
	github.com/beorn7/perks v1.0.1 // indirect
	github.com/cespare/xxhash/v2 v2.1.1 // indirect
	github.com/davecgh/go-spew v1.1.1 // indirect
	github.com/docker/go-units v0.4.0 // indirect
	github.com/evanphx/json-patch v4.12.0+incompatible // indirect
	github.com/fsnotify/fsnotify v1.5.1 // indirect
	github.com/go-logr/logr v1.2.0 // indirect
	github.com/gogo/protobuf v1.3.2 // indirect
	github.com/golang/groupcache v0.0.0-20210331224755-41bb18bfe9da // indirect
	github.com/golang/protobuf v1.5.2 // indirect
	github.com/google/go-cmp v0.5.5 // indirect
	github.com/google/gofuzz v1.1.0 // indirect
	github.com/google/uuid v1.1.2 // indirect
	github.com/googleapis/gnostic v0.5.5 // indirect
	github.com/imdario/mergo v0.3.12 // indirect
	github.com/json-iterator/go v1.1.12 // indirect
	github.com/matttproud/golang_protobuf_extensions v1.0.2-0.20181231171920-c182affec369 // indirect
	github.com/modern-go/concurrent v0.0.0-20180306012644-bacd9c7ef1dd // indirect
	github.com/modern-go/reflect2 v1.0.2 // indirect
	github.com/pkg/errors v0.9.1 // indirect
	github.com/prometheus/client_golang v1.11.1 // indirect
	github.com/prometheus/client_model v0.2.0 // indirect
	github.com/prometheus/common v0.28.0 // indirect
	github.com/prometheus/procfs v0.6.0 // indirect
	github.com/robfig/cron/v3 v3.0.1 // indirect
	github.com/spf13/pflag v1.0.5 // indirect
	golang.org/x/net v0.23.0 // indirect
	golang.org/x/oauth2 v0.0.0-20210819190943-2bc19b11175f // indirect
	golang.org/x/sys v0.18.0 // indirect
	golang.org/x/term v0.18.0 // indirect
	golang.org/x/text v0.14.0 // indirect
	golang.org/x/time v0.0.0-20210723032227-1f47c861a9ac // indirect
	gomodules.xyz/jsonpatch/v2 v2.2.0 // indirect
	google.golang.org/appengine v1.6.7 // indirect
	google.golang.org/protobuf v1.33.0 // indirect
	gopkg.in/inf.v0 v0.9.1 // indirect
	gopkg.in/yaml.v2 v2.4.0 // indirect
	gopkg.in/yaml.v3 v3.0.0 // indirect
	k8s.io/api v0.23.1 // indirect
	k8s.io/apiextensions-apiserver v0.23.0 // indirect
	k8s.io/client-go v0.23.1 // indirect
	k8s.io/component-base v0.23.0 // indirect
	k8s.io/klog/v2 v2.30.0 // indirect
	k8s.io/kube-openapi v0.0.0-20211115234752-e816edb12b65 // indirect
	k8s.io/utils v0.0.0-20210930125809-cb0fa318a74b // indirect
	sigs.k8s.io/controller-runtime v0.11.0 // indirect
	sigs.k8s.io/json v0.0.0-20211020170558-c049b76a60c6 // indirect
	sigs.k8s.io/structured-merge-diff/v4 v4.2.0 // indirect
	sigs.k8s.io/yaml v1.3.0 // indirect
)

replace (
	github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator
	github.com/gogo/protobuf => github.com/gogo/protobuf v1.3.2
	gopkg.in/yaml.v2 => gopkg.in/yaml.v2 v2.4.0
)

go 1.17
