Maven Skip Tests => mvn clean install -Dmaven.test.skip=true

kubectl apply -f deployment_kubectl.yaml

kubectl get node

kubectl get deployments

kubectl get service

kubectl get pods

kubectl delete pod department-584dfc5685-fftjf

kubectl logs department-584dfc5685-fftjf -f




Get Inside minikube => minikube ssh


To transfer Image from host machine to minikube ssh

1. Create tar on host machine => docker save backend_java-webapp > backend_java-webapp.tar
2. Copy tar inside minikube => scp -i $(minikube ssh-key) backend_java-webapp.tar docker@$(minikube ip):/home/docker/
3. Load Image inside minikube => docker load -i backend_java-webapp.tar
