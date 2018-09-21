CI JSON Schema Generator for Kubernetes and OpenShift v3 Origin API Objects
===========================================================================

`rawlingsj/origin-schema-generator` is a docker image used by the fabric8 project to automatically generate and test internals used to interact with OpenShift and Kubernetes API's.

The [Schema Generator](https://github.com/fabric8io/origin-schema-generator) generates a JSON Schema based on updated go package dependencies from [Origin](https://github.com/openshift/origin) and [Kubernetes](https://github.com/GoogleCloudPlatform/kubernetes), which in turn is used to generate Java types in fabric8 representing each API and enables communication with both via REST at runtime.  These API's are updated when a Kubernetes rebase occurs in OpenShift.  fabric8 is required to generate its updated Java types, compile, run, unit test, integration test and if successuful submit a Pull Request on the [fabric8](https://github.com/fabric8io/fabric8) project.

This image is a building block towards Continuous Delivery for [fabric8](https://github.com/fabric8io/fabric8) aiming to automate the process when updating integration points of upstream projects.

- trigger on updates to [OpenShift v3](https://github.com/openshift/origin)
- pull the latest [Schema Generator](https://github.com/fabric8io/origin-schema-generator) 
- update Kubernetes and Origin pkg dependencies
- generate new JSON schema
- build kubernetes-model with new schema generating latest api
- run fabric8 unit test suite
- run fabric8 quickstart integration tests
- release kubernetes-model to Maven Central _not yet implemented_
- notify IRC of CI job result 
- if successful creates a PR for [fabric8](https://github.com/fabric8io/fabric8) to update to new kubernetes-model dependency - _not yet implemented_

## To run...

You might want to 'prime' your registry by pullinf the integration test images before running.

```
docker pull openshift/jenkins-1-centos
docker pull fabric8/infinispan-server
docker run -p 8080:8080 -e GIT_REPO=rawlingsj -e QUICKSTART_GIT_REPO=rawlingsj -e FABRIC8_GIT_BRANCH=schema -e KUBERNETES_MASTER=https://172.30.17.191:443 -e KUBERNETES_TRUST_CERT=true  rawlingsj/origin-schema-generator
```

## To view...

Follow what's going on, in your browser launch Jenkins and look at the build pipeline

```
http://$DOCKER_HOST:8080/view/Schema%20Generation%20CD%20view/
```

### Note, currently no volumes are mounted so if you start a new container Maven will download its Java dependencies again when compiling fabric8 with the new schema.  

### Job time is currently about 8 mins.
