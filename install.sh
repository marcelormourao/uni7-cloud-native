#!/bin/bash
kubectl create -f ./k8s/01-namespace.yaml

kubectl create -n mourao -f ./k8s/02-deployment.yaml

kubectl create -n mourao -f ./k8s/03-service.yaml