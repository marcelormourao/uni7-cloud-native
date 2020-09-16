#!/bin/bash
kubectl delete service myapp -n mourao

kubectl delete deployment myapp-deployment -n mourao

kubectl delete namespaces mourao