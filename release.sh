#!/bin/bash

#
# Script requires `grab`. To install it:
# curl -s https://raw.githubusercontent.com/shellib/grab/master/install.sh | bash
#

source $(grab github.com/shellib/maven as maven)

maven::release $*
