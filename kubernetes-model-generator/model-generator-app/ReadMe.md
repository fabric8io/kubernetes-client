This image is a building block towards Continuous Delivery for fabric8 aiming to automate the process when updating integration points of upstream projects.

- trigger on updates to OpenShift v3
- pull the latest Schema Generator
- update Kubernetes and Origin pkg dependencies
- generate new JSON schema
- generate new java model
- run tests against fabric8
- release to Maven Central - not yet implemented
- notify IRC of CI job result
- creates a PR for fabric8 to update to latest released version of the model - not yet implemented