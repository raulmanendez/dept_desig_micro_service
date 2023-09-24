Get Inside minikube => minikube ssh


To transfer Image from host machine to minikube ssh

1. Create tar on host machine => docker save backend_java-webapp > backend_java-webapp.tar
2. Copy tar inside minikube => scp -i $(minikube ssh-key) backend_java-webapp.tar docker@$(minikube ip):/home/docker/
3. Load Image inside minikube => docker load -i backend_java-webapp.tar